package com.ikraybill.discordbot.init

import com.ikraybill.discordbot.DiscordBot.Companion.message
import com.ikraybill.discordbot.Utility
import com.ikraybill.discordbot.Utility.getFile
import com.ikraybill.discordbot.commands.Command
import com.ikraybill.discordbot.commands.SubCommandSet
import java.io.File
import javax.rmi.CORBA.Util
import kotlin.random.Random

val commands = mutableListOf(
    Command("hello") {
        message.channel.sendMessage("Hello, ${message.author}")
    },

    Command("cute") {
        message.channel.sendMessage("Very cute!")
        message.channel.sendMessage("Just like Miku")
    },

    SubCommandSet("joke", "Possible jokes").apply {
        for ((name, joke) in Utility.getJSON(getFile("jokes.json")).toMap()) {
            val jokeParts = joke as ArrayList<*>
            addCommand(Command(name) {
                message.channel.sendMessage(jokeParts[0] as String)
                Thread.sleep(2000)
                message.channel.sendMessage(jokeParts[1] as String)
            })
        }
    },

    SubCommandSet("quote", "Possible quote authors", "quote author").apply {
        for ((name, value) in Utility.getJSON(getFile("quotes.json")).toMap()) {
            val quotes = value as ArrayList<*>
            addCommand(Command(name, "[index]") {
                val arg = it.getOrNull(0)
                if (arg != null) {
                    val index = arg.toIntOrNull()
                    when {
                        index != null -> message.channel.sendMessage(quotes[index - 1] as String)
                        arg == "help" -> message.channel.sendMessage("$name has ${quotes.size} quotes")
                        else -> message.channel.sendMessage("Not a valid index! Try ${message.content.removeSuffix(arg)}help")
                    }
                }
                else
                    message.channel.sendMessage("\"" + quotes.random() as String + "\"")
            })
        }
    },

    Command("daniel") {
        val files = Utility.getJSON(getFile("daniel.json")).toMap().values
        message.channel.sendFile(Utility.getFile(files.random() as String))
    },

    Command("god") {
        val words = Utility.getFile("words.txt")?.readLines()
        val numWords = Random.nextInt(10, 100)

        var string = "God says..."
        for (i in 0..numWords) string += " ${words?.random()}"
        message.channel.sendMessage(string)
    }

)
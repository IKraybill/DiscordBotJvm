package com.ikraybill.discordbot

import com.ikraybill.discordbot.commands.CommandSet
import com.ikraybill.discordbot.commands.ICommandSet
import com.ikraybill.discordbot.commands.TextCommand
import com.ikraybill.discordbot.voiceCommands.VoiceCommand
import com.ikraybill.discordbot.voiceCommands.VoiceICommandSet
import sx.blah.discord.api.events.Event
import sx.blah.discord.api.events.IListener
import sx.blah.discord.handle.impl.events.ReadyEvent
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent

class DiscordBot: IListener<Event>{
    override fun handle(event: Event?) {
        if (event is ReadyEvent){
            println("Logged in!")

        } else if (event is MessageReceivedEvent){
            val message = event.message
            ICommandSet.message = message
            if (message.content.startsWith(Reference.PREFIX)) {
                //val baseCommands = CommandSet(Reference.PREFIX, message.content.split(" "))
                //baseCommands.addCommand(TextCommand("hello", "Hello, ${message.author}"))
                val voiceCommands = VoiceICommandSet("music")
                voiceCommands.addCommand(VoiceCommand("join") {
                    if (message.author.voiceStates.size() < 1)
                        message.channel.sendMessage("Not in a voice channel!")
                })
                baseCommands.addCommand(voiceCommands)
                baseCommands.genHelpCommand()
                baseCommands.parseCommands()
            }
        }
    }
}
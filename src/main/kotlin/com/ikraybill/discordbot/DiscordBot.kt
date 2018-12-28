package com.ikraybill.discordbot

import com.ikraybill.discordbot.Reference.client
import com.ikraybill.discordbot.commands.CommandSet
import sx.blah.discord.api.events.Event
import sx.blah.discord.api.events.IListener
import sx.blah.discord.handle.impl.events.ReadyEvent
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent
import sx.blah.discord.handle.obj.ActivityType
import sx.blah.discord.handle.obj.IMessage
import sx.blah.discord.handle.obj.StatusType

class DiscordBot: IListener<Event>{

    companion object {
        lateinit var message: IMessage
    }

    override fun handle(event: Event?) {
        if (event is ReadyEvent){
            println("Logged in!")

            client.changePresence(StatusType.ONLINE, ActivityType.PLAYING, Reference.PREFIX + "help")
        } else if (event is MessageReceivedEvent){
            message = event.message

            if (message.author.isBot) return

            if (message.channel.isPrivate) {
                return
            }

            if (message.content.startsWith(Reference.PREFIX)) {
                val params = message.content.split(" ")
                val baseCommandSet = CommandSet(params)
                baseCommandSet.addCommand(baseCommandSet.Command("test") {
                    message.channel.sendMessage("Hello faggot")
                })
                baseCommandSet.parseCommands()
            } else if (message.content.indexOf("<@"+client.applicationClientID) == 0 || message.content.indexOf("<@!"+ client.applicationClientID) == 0) { // Catch @Mentions
                message.channel.sendMessage("Use `${Reference.PREFIX}` to interact with me.") //help people learn your prefix
            }
        }
    }
}
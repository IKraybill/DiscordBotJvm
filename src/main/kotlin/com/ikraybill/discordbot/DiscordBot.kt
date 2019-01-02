package com.ikraybill.discordbot

import com.ikraybill.discordbot.Reference.client
import com.ikraybill.discordbot.commands.Command
import com.ikraybill.discordbot.commands.CommandSet
import com.ikraybill.discordbot.commands.SubCommandSet
import com.ikraybill.discordbot.init.commands
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
        lateinit var baseCommandSet: CommandSet
        lateinit var voiceCommandSet: SubCommandSet
    }

    override fun handle(event: Event?) {
        if (event is ReadyEvent){
            println("Logged in!")

            baseCommandSet = CommandSet("command", "Possible commands", commands)
            voiceCommandSet = SubCommandSet("music",  "Possible music commands", "music command")

            client.changePresence(StatusType.ONLINE, ActivityType.PLAYING, "${Reference.PREFIX}help")
        } else if (event is MessageReceivedEvent){
            message = event.message

            //Don't respond to bots
            if (message.author.isBot) return

            //Don't respond to DMs
            if (message.channel.isPrivate) return

            //Detect prefix and run command
            if (message.content.startsWith(Reference.PREFIX)) {
                val params = message.content.replaceFirst(Reference.PREFIX, "").split(" ")

                baseCommandSet.addCommand(voiceCommandSet)
                baseCommandSet.parseCommand(params)
            }

            //Detect @mentions
            else if (message.content.indexOf("<@"+client.applicationClientID) == 0 || message.content.indexOf("<@!"+ client.applicationClientID) == 0) {
                message.channel.sendMessage("Use `${Reference.PREFIX}` to interact with me.")
            }
        }
    }
}
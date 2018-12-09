package com.ikraybill.discordbot

import com.ikraybill.discordbot.commands.BaseCommandSet
import com.ikraybill.discordbot.commands.CommandSet
import com.ikraybill.discordbot.commands.TextCommand
import com.ikraybill.discordbot.voiceCommands.VoiceCommand
import com.ikraybill.discordbot.voiceCommands.VoiceCommandSet
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
            CommandSet.message = message
            if (message.content.startsWith(Reference.PREFIX)) {
                val baseCommands = BaseCommandSet(Reference.PREFIX, message.content.split(" "))
                baseCommands.addCommand(TextCommand("hello", "Hello, ${message.author}"))
                val voiceCommands = VoiceCommandSet("music")
                voiceCommands.addCommand(VoiceCommand("join"))
                baseCommands.addCommand(voiceCommands)
                baseCommands.genHelpCommand()
                baseCommands.parseCommands()
            }
        }
    }
}
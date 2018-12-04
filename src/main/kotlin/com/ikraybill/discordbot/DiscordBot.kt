package com.ikraybill.discordbot

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
            val content = message.content
            if (content.startsWith(Reference.PREFIX)) {
                message.channel.sendMessage("Hello from Kotlin/jvm!")
            }
        }
    }
}
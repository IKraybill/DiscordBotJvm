package com.ikraybill.discordbot

import com.ikraybill.discordbot.Reference.TOKEN
import com.ikraybill.discordbot.Reference.client
import sx.blah.discord.api.ClientBuilder

object Main {
    @JvmStatic
    fun main(args: Array<String>){
        println("Logging in...")
        client = ClientBuilder().withToken(TOKEN).build()
        client.dispatcher.registerListener(DiscordBot())
        client.login()
    }
}
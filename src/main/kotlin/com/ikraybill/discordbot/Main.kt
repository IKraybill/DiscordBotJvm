package com.ikraybill.discordbot

import com.ikraybill.discordbot.Reference.TOKEN
import sx.blah.discord.api.ClientBuilder

object Main {
    @JvmStatic
    fun main(args: Array<String>){
        println("Logging in...")
        val client = ClientBuilder().withToken(TOKEN).build()
        client.dispatcher.registerListener(DiscordBot())
        client.login()
    }
}
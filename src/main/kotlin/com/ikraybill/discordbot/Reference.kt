package com.ikraybill.discordbot

import sx.blah.discord.api.IDiscordClient

object Reference {
    var config = Utility.getJSON("config.json")
    val TOKEN = config.get("token") as String
    val PREFIX = config.get("prefix") as String
    lateinit var client: IDiscordClient
}
package com.ikraybill.discordbot

import sx.blah.discord.api.IDiscordClient
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

object Reference {
    var config = try {
        File("config.json").asJSON()
    } catch (e: FileNotFoundException) {
        println("No config.json supplied! Exiting...")
        exitProcess(1)
    }
    val TOKEN = config.get("token") as String
    val PREFIX = config.get("prefix") as String
    lateinit var client: IDiscordClient
}
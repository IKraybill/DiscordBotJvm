package com.ikraybill.discordbot

import sx.blah.discord.api.IDiscordClient
import java.io.File
import java.io.FileNotFoundException
import java.lang.Exception
import kotlin.system.exitProcess

object Reference {
    var config = try {
        Utility.getJSON(File("config.json"))
    } catch (e: FileNotFoundException) {
        println("No config.json supplied! Exiting...")
        exitProcess(1)
    }
    val TOKEN = config.get("token") as String
    val PREFIX = config.get("prefix") as String
    lateinit var client: IDiscordClient
}
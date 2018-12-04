package com.ikraybill.discordbot

object Reference {
    var config = Utility.getJSON("config.json")
    val TOKEN = config.get("token") as String
    val PREFIX = config.get("prefix") as String
}
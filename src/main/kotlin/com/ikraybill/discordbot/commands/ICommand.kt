package com.ikraybill.discordbot.commands

interface ICommand {
    val name: String
    var parent: CommandSet?
}
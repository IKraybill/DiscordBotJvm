package com.ikraybill.discordbot.commands

interface ICommand {
    val name: String
    val argHelp: String?
    val task: (args: List<String>) -> Unit
    val indexed: Boolean
}
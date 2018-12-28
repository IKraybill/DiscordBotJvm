package com.ikraybill.discordbot.commands

interface ICommand {
    val name: String
    val task: () -> Any
    val indexed: Boolean
}
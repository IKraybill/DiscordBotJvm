package com.ikraybill.discordbot.commands

interface ICommandSet{

    var prefix: String
    val helpBase: String
    val helpText: String
    val commandIdentifier: String

    val commands: List<ICommand>

    fun parseCommand(params: List<String>)

    fun addCommand(command: ICommand)
}
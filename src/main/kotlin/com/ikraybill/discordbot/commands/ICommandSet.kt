package com.ikraybill.discordbot.commands

import sx.blah.discord.handle.obj.IMessage

interface ICommandSet{

    var params: List<String>
    var cmd: String
    var args: List<String>
    var prefix: String
    val helpBase: String

    var helpText: String

    val commands: MutableList<ICommand>
}
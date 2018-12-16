package com.ikraybill.discordbot.commands

import sx.blah.discord.handle.obj.IMessage

interface ICommandSet : ICommand{

    var params: List<String>
    var cmd: String
    var args: List<String>
    var prefix: String
    val helpBase: String

    var helpText: String

    private val commands: MutableList<ICommand>

    companion object {
        lateinit var message: IMessage
    }

    fun parseCommands(){
        for (command in commands)
            if (cmd.toLowerCase() == command.name){
                if (command is Command && command.runnable){
                    command.task()
                } else if (command is ICommandSet){
                    command.parseCommands()
                }
            }
    }

    fun addCommand(command: ICommand){
        command.parent = this
        if (!(command is Command && !command.indexed)){
            helpText += (if (helpText.isEmpty()) "" else ", ") + command.name
        }
        commands.add(command)
    }

    fun genHelpCommand(){
        addCommand(TextCommand("help", helpBase + helpText))
    }
}
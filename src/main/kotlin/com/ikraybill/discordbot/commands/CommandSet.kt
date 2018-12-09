package com.ikraybill.discordbot.commands

import sx.blah.discord.handle.obj.IMessage

abstract class CommandSet(val name: String){

    abstract var params: List<String>
    abstract var cmd: String
    abstract var args: List<String>
    abstract var prefix: String
    abstract val helpBase: String

    var helpText = ""

    private val commands: MutableList<ICommand> = mutableListOf()
    private val subCommandSets :MutableList<SubCommandSet> = mutableListOf()

    companion object {
        lateinit var message: IMessage
    }

    fun parseCommands(){
        for (command in commands)
            if (cmd.toLowerCase() == command.name){
                if (command is Command && command.runnable){
                    command.task()
                } else if (command is CommandSet){
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
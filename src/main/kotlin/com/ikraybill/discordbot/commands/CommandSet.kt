package com.ikraybill.discordbot.commands

import com.ikraybill.discordbot.DiscordBot.Companion.message
import com.ikraybill.discordbot.Reference

class CommandSet(override var params: List<String>, override val commands: MutableList<ICommand> = mutableListOf()): ICommandSet {
    override var helpText: String
        get() = helpBase + commands.filter { it.indexed }.joinToString { it.name }
        set(value) {}
    override var helpBase: String = "Possible commands: "
    override var prefix = Reference.PREFIX
    override var cmd = params[0].replaceFirst(prefix, "")
    override var args = if (params.size > 1) params.slice(1..params.size) else listOf()

    inner class Command (override val name: String,
                         override var indexed: Boolean = true,
                         override val task: (() -> Any) = { println("Error, no task specified") }
                         ): ICommand
    {
        val args = this@CommandSet.args
    }

    init {
        addCommand(Command("help", false) {
            message.channel.sendMessage(helpText)
        })
    }

    fun parseCommands(){
        for (command in commands)
            if (cmd.toLowerCase() == command.name){
                if (command is Command){
                    command.task()
                }
//                else if (command is ICommandSet){
//                    command.parseCommands()
//                }
            }
    }

    fun addCommand(command: ICommand){
        commands.add(command)
    }
}
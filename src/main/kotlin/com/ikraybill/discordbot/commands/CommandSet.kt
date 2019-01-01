package com.ikraybill.discordbot.commands

import com.ikraybill.discordbot.DiscordBot.Companion.message
import com.ikraybill.discordbot.Reference

class CommandSet(override val commandIdentifier: String, override val helpBase: String, override val commands: MutableList<ICommand> = mutableListOf()): ICommandSet {
    override val helpText: String
        get() = helpBase + ": " + commands.filter { it.indexed }.joinToString { it.name + if (it.argHelp != null) " ${it.argHelp}" else "" }
    override var prefix = Reference.PREFIX

    init {
        addCommand(Command("help", indexed = false) {
            message.channel.sendMessage(helpText)
        })
    }

    override fun parseCommand(params: List<String>){
        val cmd = params.getOrElse(0) {""}.replaceFirst(prefix, "")
        val args = if (params.size > 1) params.slice(1 until params.size) else listOf()
        if (cmd.isEmpty()){
            message.channel.sendMessage("No $commandIdentifier specified, silly!")
        }

        for (command in commands) {
            if (cmd.toLowerCase() == command.name) {
                command.task(args)
                return
            }
        }
        message.channel.sendMessage("Unknown $commandIdentifier, silly! Try " + message.content.removeSuffix(cmd) + "help")
    }

    override fun addCommand(command: ICommand){
        commands.add(command)
    }
}
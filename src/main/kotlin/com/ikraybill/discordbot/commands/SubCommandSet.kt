package com.ikraybill.discordbot.commands

class SubCommandSet(override val name: String,
                    override val helpBase: String,
                    override val commandIdentifier: String = name,
                    var commandSetDelegate: CommandSet = CommandSet(commandIdentifier, helpBase)
): ICommandSet by commandSetDelegate, ICommand {

    override val argHelp: String?
        get() = "<$commandIdentifier>"

    override val indexed: Boolean = true

    override val task: (args: List<String>) -> Unit = {parseCommand(it)}
}
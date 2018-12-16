package com.ikraybill.discordbot.commands

open class Command(override val name: String, open var task: (() -> Unit) = { println("Error, no task specified") },
                   var indexed: Boolean = true, var runnable: Boolean = true): ICommand {
    override var parent: ICommandSet? = null
}

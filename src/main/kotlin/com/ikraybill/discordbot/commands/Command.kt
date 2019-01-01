package com.ikraybill.discordbot.commands

class Command (override val name: String,
               override val argHelp: String? = null,
               override var indexed: Boolean = true,
               override val task: ((args: List<String>) -> Unit)): ICommand
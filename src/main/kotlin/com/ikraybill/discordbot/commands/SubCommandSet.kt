package com.ikraybill.discordbot.commands

abstract class SubCommandSet(name: String): CommandSet(name), ICommand  {
    override var parent: CommandSet? = null
        set(value) {
            field = value
            params = parent!!.args
            cmd = if (params.isNotEmpty()) params[0] else "none"
            args = if (params.size > 1) params.slice(1..params.size) else listOf()
        }
}
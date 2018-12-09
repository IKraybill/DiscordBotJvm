package com.ikraybill.discordbot.commands

import com.ikraybill.discordbot.Reference

class BaseCommandSet(name: String, override var params: List<String>): CommandSet(name) {
    override var helpBase: String = "Possible commands: "
    override var prefix = Reference.PREFIX
    override var cmd = params[0].replaceFirst(prefix, "")
    override var args = if (params.size > 1) params.slice(1..params.size) else listOf()

    init {
        addCommand(TextCommand("default", "Unknown command. Type " + this.prefix + "help for more info", false, false))
    }
}
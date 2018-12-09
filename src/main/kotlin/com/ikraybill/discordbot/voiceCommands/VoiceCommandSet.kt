package com.ikraybill.discordbot.voiceCommands

import com.ikraybill.discordbot.Reference
import com.ikraybill.discordbot.commands.CommandSet
import com.ikraybill.discordbot.commands.SubCommandSet
import com.ikraybill.discordbot.commands.TextCommand

class VoiceCommandSet(name: String): SubCommandSet(name) {
    override var helpBase: String = "Possible voice commands: "
    override lateinit var params: List<String>
    override lateinit var cmd: String
    override lateinit var args: List<String>
    override lateinit var prefix: String
}
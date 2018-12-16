package com.ikraybill.discordbot.voiceCommands

import com.ikraybill.discordbot.commands.SubICommandSet

class VoiceICommandSet(name: String): SubICommandSet(name) {
    override var helpBase: String = "Possible voice commands: "
    override lateinit var params: List<String>
    override lateinit var cmd: String
    override lateinit var args: List<String>
    override lateinit var prefix: String
}
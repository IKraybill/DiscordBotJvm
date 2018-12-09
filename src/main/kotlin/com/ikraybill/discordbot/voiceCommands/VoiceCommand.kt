package com.ikraybill.discordbot.voiceCommands

import com.ikraybill.discordbot.commands.Command

class VoiceCommand(name: String, task: (() -> Unit) = { println("Error, no task specified") }): Command(name, task) {

}
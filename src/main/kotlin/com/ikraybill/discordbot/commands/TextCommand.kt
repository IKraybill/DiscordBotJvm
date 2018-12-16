package com.ikraybill.discordbot.commands

class TextCommand(name: String, private val text: String, indexed: Boolean = true,
                  runnable: Boolean = true): Command(name, indexed = indexed, runnable = runnable){
    override var task: () -> Unit = {ICommandSet.message.channel.sendMessage(text)}
}
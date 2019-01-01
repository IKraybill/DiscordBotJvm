//package com.ikraybill.discordbot.voiceCommands
//
//import com.ikraybill.discordbot.commands.CommandSet
//import com.ikraybill.discordbot.commands.ICommand
//import com.ikraybill.discordbot.commands.ICommandSet
//
//class VoiceCommandSet(override val name: String,
//                      override var params: List<String>,
//                      override val commands: MutableList<ICommand> = mutableListOf(),
//                      var commandSetDelegate: CommandSet = CommandSet(params, name)
//): ICommandSet by commandSetDelegate, ICommand {
//    override val helpBase: String
//        get() = "Possible voice commands: "
//
//    override val indexed: Boolean = true
//
////    override fun parseCommand() = commandSetDelegate.parseCommand()
//
//    override val task: () -> Any
//        get() = {this.parseCommand()}
//
//}
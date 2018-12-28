//package com.ikraybill.discordbot.commands
//
//abstract class SubCommandSet(name: String): ICommandSet(name), ICommand  {
//    override var parent: ICommandSet? = null
//        set(value) {
//            field = value
//            params = field!!.args
//            cmd = if (params.isNotEmpty()) params[0] else "none"
//            args = if (params.size > 1) params.slice(1..params.size) else listOf()
//            prefix = field!!.prefix + " "
//        }
//
//    init {
//        addCommand(TextCommand("none", "Unknown command. Type " + this.parent?.prefix + "help for more info", false, false))
//    }
//}
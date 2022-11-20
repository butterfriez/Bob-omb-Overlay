package com.butter.commands

import BombOmb
import com.butter.config.Config
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText
class ExampleCommand : CommandBase() {
    override fun getCommandName() = "examplemod"

    override fun getCommandAliases() = listOf("example")

    override fun getCommandUsage(sender: ICommandSender?) = "/$commandName"

    override fun getRequiredPermissionLevel() = 0

    override fun processCommand(sender: ICommandSender?, args: Array<out String>?) {
        sender?.addChatMessage(ChatComponentText("Example command run!"))
        BombOmb.currentGui = Config.gui()
    }
}
package com.butter.commands

import BombOmb
import com.butter.gui.MainGui
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender

class MainCommand : CommandBase() {
    override fun getCommandName() = "bobomb"

    override fun getCommandAliases() = listOf("bo")

    override fun getCommandUsage(sender: ICommandSender?) = "/$commandName"

    override fun getRequiredPermissionLevel() = 0

    override fun processCommand(sender: ICommandSender?, args: Array<out String>?) {
        BombOmb.currentGui = MainGui()
    }
}
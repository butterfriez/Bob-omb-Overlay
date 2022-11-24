package com.butter.gui

import BombOmb.Companion.persistentData
import com.butter.gui.components.SimpleSlider
import gg.essential.api.EssentialAPI
import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.RelativeConstraint
import gg.essential.elementa.constraints.SiblingConstraint
import gg.essential.elementa.dsl.*
import net.minecraft.client.Minecraft

class EditGui : WindowScreen(ElementaVersion.V1, newGuiScale = EssentialAPI.getGuiUtil().getGuiScale()){
    private val Text: UIText =
        UIText("Overlay Edit", shadow = false).childOf(window).constrain {
            x = CenterConstraint()
            y = RelativeConstraint(0.075f)
            textScale = basicTextScaleConstraint { window.getHeight() / 90 }
        }
    init {
        SimpleSlider(defaultI = 5).childOf(window).constrain {
            x = CenterConstraint()
            y = SiblingConstraint() + RelativeConstraint(0.075f)
            width = 200.pixels()
            height = 20.pixels()
        }
    }

    private val BlockOverlay:UIBlock = UIBlock(persistentData.BlockColor).constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        width = 50.pixels()
        height = 50.pixels()
    } childOf window
    override fun setWorldAndResolution(mc: Minecraft, width: Int, height: Int) {
        window.onWindowResize()
        Text.constrain {
            textScale = basicTextScaleConstraint { window.getHeight() / 90 }
        }
        super.setWorldAndResolution(mc, width, height)
    }
}
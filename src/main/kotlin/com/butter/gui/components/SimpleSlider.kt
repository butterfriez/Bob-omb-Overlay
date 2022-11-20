package com.butter.gui.components

import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.dsl.childOf
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.toConstraint
import java.awt.Color

class SimpleSlider @JvmOverloads constructor(val t: String, val h: Boolean = false, val w: Boolean = false):
        UIBlock(Color(0, 0, 0, 80)) {
            val text: UIText = UIText(t).constrain {
                x = CenterConstraint()
                y = CenterConstraint()
                color = Color(14737632).toConstraint()
            } childOf this

            init {

            }
        }
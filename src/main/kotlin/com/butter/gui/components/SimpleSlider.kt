package com.butter.gui.components

import com.butter.utils.skytils.SmartFontRenderer
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.RelativeConstraint
import gg.essential.elementa.constraints.animation.Animations
import gg.essential.elementa.dsl.*
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import org.lwjgl.input.Keyboard
import java.awt.Color

class SimpleSlider @JvmOverloads constructor(var minI: Int = 0, var maxI: Int = 10, var defaultI: Int,val t: String = "Value: ",val h: Boolean = false, val w: Boolean = false):
        UIBlock(Color(0, 0, 0, 80)) {
            private var SmartFontRenderer:SmartFontRenderer = SmartFontRenderer()
            private var isFocused:Boolean = false

            private val slider:UIBlock = UIBlock(Color.GREEN).constrain {
                x = CenterConstraint()
                y = CenterConstraint()
                width = (RelativeConstraint() - 10.pixels())
                height = (RelativeConstraint() - 10.pixels())
            } childOf this

            //Value text above slider.
            private val uiText:UIText = UIText(t + defaultI).constrain {
                x = CenterConstraint()
                y = (slider.getHeight() + 15).pixels()
            } childOf this

            private val sliderBlock:UIBlock = UIBlock(Color.WHITE).constrain {
                x = CenterConstraint()
                y = CenterConstraint()
                width = (slider.constraints.width / 2)
                height = (slider.constraints.height)
            } childOf slider
            init {
                this
                    .constrain {
                        width = if (w) {
                            RelativeConstraint()
                        } else {
                            (slider.getWidth() + 40).pixels()
                        }
                        height = if (h) {
                            RelativeConstraint()
                        } else {
                            (slider.getHeight() + 10).pixels()
                        }
                    }
                    .onMouseEnter {
                        animate {
                            setColorAnimation(
                                Animations.OUT_EXP,
                                0.5f,
                                Color(255, 255, 255, 80).toConstraint(),
                                0f
                            )
                        }
                    }.onMouseLeave {
                        animate {
                            setColorAnimation(
                                Animations.OUT_EXP,
                                0.5f,
                                Color(0, 0, 0, 80).toConstraint()
                            )
                        }
                    }.onMouseClick {
                        isFocused = !isFocused
                        if(isFocused) {
                            sliderBlock.constraints.color = Color.BLACK.toConstraint()
                        } else {
                            sliderBlock.constraints.color = Color.WHITE.toConstraint()
                        }
                    }.onKeyType { typedChar, keyCode ->
                        if(isFocused) return@onKeyType
                        if(keyCode == Keyboard.KEY_LEFT) {
                            sliderBlock.constraints.x -= 1.pixels()
                            defaultI--
                        } else if(keyCode == Keyboard.KEY_RIGHT) {
                            sliderBlock.constraints.x += 1.pixels()
                            defaultI++
                        }
                    }

            }

        @SubscribeEvent
        fun tickEvent(e: TickEvent) {
            if(maxI < defaultI) {
                defaultI = maxI
            }
            if(minI > defaultI) {
                defaultI = minI
            }
            uiText.setText(t + defaultI)
        }
}


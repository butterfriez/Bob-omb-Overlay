package com.butter.gui.components

import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.RelativeConstraint
import gg.essential.elementa.constraints.animation.Animations
import gg.essential.elementa.dsl.*
import gg.essential.elementa.dsl.minus
import java.awt.Color

class SimpleSlider @JvmOverloads constructor(val h: Boolean = false, val w: Boolean = false,  component: UIBlock):
        UIBlock(Color(0, 0, 0, 80)) {
            private val slider:UIBlock = UIBlock(Color.GREEN).constrain {
                x = CenterConstraint()
                y = CenterConstraint()
                width = (RelativeConstraint() - 10.pixels())
                height = (RelativeConstraint() - 10.pixels())
            } childOf this
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
                    }
            }
        }
/**
 * @author Skytils - Hypixel Skyblock Quality of Life Mod (https://github.com/Skytils/SkytilsMod/blob/1.x/src/main/kotlin/skytils/skytilsmod/gui/components/SimpleButton.kt)
 */
package com.butter.gui

import BombOmb
import com.butter.config.Config
import com.butter.gui.components.SimpleButton
import gg.essential.api.EssentialAPI
import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.RainbowColorConstraint
import gg.essential.elementa.constraints.RelativeConstraint
import gg.essential.elementa.constraints.SiblingConstraint
import gg.essential.elementa.constraints.animation.Animations
import gg.essential.elementa.dsl.*
import net.minecraft.client.Minecraft


class MainGui :
    WindowScreen(ElementaVersion.V1, newGuiScale = EssentialAPI.getGuiUtil().getGuiScale())
    {
        private val bobOmbText: UIText =
            UIText("Bob-Omb", shadow = false).childOf(window).constrain {
                x = CenterConstraint()
                y = RelativeConstraint(0.075f)
                textScale = basicTextScaleConstraint { window.getHeight() / 50 }
            }

        init {
            SimpleButton("Config").childOf(window).constrain {
                x = CenterConstraint()
                y = SiblingConstraint() + RelativeConstraint(0.075f)
                width = 200.pixels()
                height = 20.pixels()
            }.onMouseClick {
                BombOmb.currentGui = Config.gui()
            }
            SimpleButton("Edit Overlay").childOf(window).constrain {
                x = CenterConstraint()
                y = SiblingConstraint() + 2.pixels()
                width = 200.pixels()
                height = 20.pixels()
            }.onMouseClick {
                BombOmb.currentGui = EditGui()
            }
            animate()
        }

        private fun animate() {
            bobOmbText.animate {
                setColorAnimation(Animations.IN_OUT_SIN, 1f, RainbowColorConstraint())
                    .onComplete {
                        animate()
                    }
            }
        }

        override fun setWorldAndResolution(mc: Minecraft, width: Int, height: Int) {
            window.onWindowResize()
            bobOmbText.constrain {
                textScale = basicTextScaleConstraint { window.getHeight() / 40 }
            }
            super.setWorldAndResolution(mc, width, height)
        }
    }
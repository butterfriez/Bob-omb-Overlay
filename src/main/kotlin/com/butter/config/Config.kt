package com.butter.config

import gg.essential.vigilance.Vigilant
import java.io.File


object Config : Vigilant(
    File(BombOmb.configDirectory, "config.toml"),
    BombOmb.metadata.name
) {
    var bobOmbOverlay = false

    init {
        category("Main") {
            switch(
                ::bobOmbOverlay,
                name = "Bob-Omb Render-Overlay",
                description = "Renders block highlights."
            )
        }
    }
}


/** EXAMPLE CONFIG
 * category("One category") {
 * switch(
 * ::demoSwitch,
 * name = "Switch",
 * description = "This is a switch"
 * )
 * subcategory("An additional category") {
 * selector(
 * ::demoSelector,
 * name = "Selector",
 * description = "This is a selector",
 * options = listOf("Option 1", "Option 2", "Option 3")
 * )
 * color(
 * ::demoColor,
 * name = "Color",
 * description = "This sets a color"
 * )
 * }
 * }
 */
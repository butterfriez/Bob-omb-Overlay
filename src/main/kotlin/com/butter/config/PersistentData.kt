package com.butter.config

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import java.awt.Color

@Serializable
data class PersistentData(
    @Contextual
    val BlockColor: Color = Color.BLUE
) {

    fun save() {
        configFile.writeText(Json.encodeToString(this))
    }

    companion object {
        private val configFile: File = File(BombOmb.configDirectory,"data.json")

        fun load(): PersistentData {
            val data = if (!configFile.exists()) {
                configFile.createNewFile()
                PersistentData()
            } else configFile.runCatching {
                Json.decodeFromString<PersistentData>(this.readText())
            }.getOrNull() ?: PersistentData()
            return data.apply {
                this.save()
            }
        }
    }
}
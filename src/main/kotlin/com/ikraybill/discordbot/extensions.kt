package com.ikraybill.discordbot

import org.json.JSONObject
import org.json.JSONTokener
import java.io.File

fun File.asJSON(): JSONObject {
    return JSONObject(JSONTokener(this.inputStream()))
}
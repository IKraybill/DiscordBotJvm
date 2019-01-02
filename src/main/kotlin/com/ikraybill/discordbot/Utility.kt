package com.ikraybill.discordbot

import org.json.JSONObject
import org.json.JSONTokener
import java.io.File
import java.io.InputStream

object Utility {
    fun getFile(fileName: String): File {
        val classLoader = javaClass.classLoader
        return File(classLoader.getResource(fileName).toURI())
    }
}
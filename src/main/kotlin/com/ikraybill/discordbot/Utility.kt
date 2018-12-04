package com.ikraybill.discordbot

import org.json.JSONObject
import org.json.JSONTokener
import java.io.InputStream

object Utility {
    fun getFile(fileName: String): InputStream {
        val classLoader = Thread.currentThread().contextClassLoader
        return classLoader.getResourceAsStream(fileName)
    }

    fun getJSON(fileName: String): JSONObject{
        val JSONFile = JSONTokener(getFile(fileName))
        return JSONObject(JSONFile)
    }
}
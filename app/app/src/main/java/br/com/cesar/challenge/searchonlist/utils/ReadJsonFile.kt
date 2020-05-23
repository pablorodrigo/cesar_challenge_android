package br.com.cesar.challenge.searchonlist.utils

import android.content.Context
import java.io.IOException

/**
 * class to read a json file
 */
object ReadJsonFile {

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}
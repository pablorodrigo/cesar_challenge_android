package br.com.cesar.challenge.searchonlist.model.entity

import android.content.Context
import br.com.cesar.challenge.searchonlist.utils.ReadJsonFile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Product(val title: String, val price: Double) {

    companion object {
        fun listAll(context: Context): List<Product> {

            val jsonFileString =
                ReadJsonFile.getJsonDataFromAsset(context, "products.json")

            val listPersonType = object : TypeToken<List<Product>>() {}.type

            return Gson().fromJson(jsonFileString, listPersonType);
        }
    }

}
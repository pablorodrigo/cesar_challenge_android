package br.com.cesar.challenge.searchonlist.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import br.com.cesar.challenge.searchonlist.R
import br.com.cesar.challenge.searchonlist.model.entity.Product
import br.com.cesar.challenge.searchonlist.utils.ReadJsonFile.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var products: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        products = Product.listAll(this)

        products.forEach {
            Log.d("data", it.title)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        return super.onCreateOptionsMenu(menu)
    }
}

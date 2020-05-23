package br.com.cesar.challenge.searchonlist.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cesar.challenge.searchonlist.R
import br.com.cesar.challenge.searchonlist.model.entity.Product
import br.com.cesar.challenge.searchonlist.utils.ReadJsonFile.getJsonDataFromAsset
import br.com.cesar.challenge.searchonlist.view.adapter.ProductsAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var products: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configLayouts()

        products = Product.listAll(this)

        recycler_products.adapter = ProductsAdapter(this, products);

    }

    private fun configLayouts(){
        // config recycler
        recycler_products.let {
            it.layoutManager = LinearLayoutManager(this)
            it.itemAnimator = DefaultItemAnimator()
            it.setHasFixedSize(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        return super.onCreateOptionsMenu(menu)
    }
}

package br.com.cesar.challenge.searchonlist.view.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cesar.challenge.searchonlist.R
import br.com.cesar.challenge.searchonlist.model.entity.Product
import br.com.cesar.challenge.searchonlist.view.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var products: List<Product>
    private lateinit var searchView: SearchView
    private lateinit var adapterProducts: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        products = Product.listAll(this)
        adapterProducts = ProductsAdapter(this, products);

        configLayouts()

        recycler_products.adapter = adapterProducts

    }

    private fun configLayouts() {
        // config recycler
        recycler_products.let {
            it.layoutManager = LinearLayoutManager(this)
            it.itemAnimator = DefaultItemAnimator()
            it.setHasFixedSize(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        configSearchMenu(menu)

        return super.onCreateOptionsMenu(menu)
    }

    private fun configSearchMenu(menu: Menu) {
        val mSearchViewItem = menu.findItem(R.id.menu_item_search)
        searchView = mSearchViewItem.actionView as SearchView

        //depending on what the user type it will filter the list
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newTextToFilter: String): Boolean {

                adapterProducts.filter(newTextToFilter)

                return true


            }
        })
    }



}

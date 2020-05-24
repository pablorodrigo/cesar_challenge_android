package br.com.cesar.challenge.searchonlist.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cesar.challenge.searchonlist.R
import br.com.cesar.challenge.searchonlist.model.entity.Product
import br.com.cesar.challenge.searchonlist.utils.PartialPermutation
import br.com.cesar.challenge.searchonlist.utils.Typos
import kotlinx.android.synthetic.main.adapter_products.view.*
import java.util.*

class ProductsAdapter(private val context: Context, private val listOfProducts: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    private var listOfProductsFilter: List<Product>

    init {
        this.listOfProductsFilter = listOfProducts
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_products, viewGroup, false)
        return ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.listOfProductsFilter.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = listOfProductsFilter[position]

        val view = holder.itemView

        with(view) {
            tv_product_name.text = product.title
        }

    }

    /**
     * filter list of products
     */
    fun filter(text: String) {

        when {
            text.isEmpty() -> {

                listOfProductsFilter = listOfProducts

            }
            else -> {

                val listFiltered = ArrayList<Product>()

                for (product in listOfProducts) {
                    if (validateWord(
                            product.title.toLowerCase(Locale.getDefault()),
                            text.toLowerCase(Locale.getDefault())
                        )
                    ) {

                        listFiltered.add(product)

                    }
                }

                listOfProductsFilter = listFiltered
            }
        }
        notifyDataSetChanged()
    }


    private fun validateWord(query: String, wordCheck: String): Boolean {

        val sequenceWord = query.toLowerCase(Locale.getDefault())
        val word = wordCheck.toLowerCase(Locale.getDefault())

        if (sequenceWord == word || sequenceWord.contains(word)) return true

        var count = 0
        if (PartialPermutation.checkIfIs(sequenceWord, word)) {
            count++
        }
        if (Typos.checkIfIsTypos(sequenceWord, word)) {
            count++
        }

        return count == 1

    }


    class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view)

}
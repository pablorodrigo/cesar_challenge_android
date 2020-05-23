package br.com.cesar.challenge.searchonlist.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cesar.challenge.searchonlist.R
import br.com.cesar.challenge.searchonlist.model.entity.Product
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
                    if (product.title.toLowerCase(Locale.getDefault())
                            .contains(text.toLowerCase(Locale.getDefault()))
                    ) {

                        listFiltered.add(product)

                    }
                }

                listOfProductsFilter = listFiltered
            }
        }
        notifyDataSetChanged()
    }


    class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view)

}
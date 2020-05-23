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

class ProductsAdapter(private val context: Context, private val listOfProducts: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_products, viewGroup, false)
        return ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.listOfProducts.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {

        Log.d("adapter",listOfProducts[position].title)
        val product = listOfProducts[position]

        val view = holder.itemView

        with(view) {
            tv_product_name.text = product.title
        }

    }


    class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view)

}
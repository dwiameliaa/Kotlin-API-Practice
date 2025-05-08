package com.example.markaslistview

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductsAdapter(val product: List<ProductsItem>): RecyclerView.Adapter<ProductsAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item = product[position]
        holder.initView(item)
    }

    var onItemClick: ((ProductsItem) -> Unit)? = null

    override fun getItemCount(): Int = product.size

    inner class ItemViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvCategory = view.findViewById<TextView>(R.id.tv_category)
        val ivProducts = view.findViewById<ImageView>(R.id.iv_product)

        fun initView(product: ProductsItem){
            tvTitle.text = product.title
            tvCategory.text = product.category

            val imageURL = product.images.first()
            Glide.with(ivProducts).load(imageURL).into(ivProducts)

            itemView.setOnClickListener { onItemClick?.invoke(product) }

        }

    }
}
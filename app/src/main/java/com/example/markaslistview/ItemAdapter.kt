package com.example.markaslistview

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val quotes: List<QuotesItem>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_holder,parent,false))
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item = quotes[position]
        holder.initView(item)
    }

    var onItemClick: ((QuotesItem) -> Unit)? = null

    override fun getItemCount(): Int = quotes.size

    inner class ItemViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val tvAuthor = view.findViewById<TextView>(R.id.tv_author)
        val tvQuote = view.findViewById<TextView>(R.id.tv_quote)

        fun initView(quote: QuotesItem){
            tvAuthor.text = quote.author
            tvQuote.text = quote.quote

            itemView.setOnClickListener { onItemClick?.invoke(quote) }

        }

    }
}
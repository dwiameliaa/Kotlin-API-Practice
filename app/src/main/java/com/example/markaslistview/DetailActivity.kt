package com.example.markaslistview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvCategory = findViewById<TextView>(R.id.tv_category)
        val tvDescription = findViewById<TextView>(R.id.tv_description)
        val ivProduct = findViewById<ImageView>(R.id.iv_product)

        val productData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("product", ProductsItem::class.java)
        } else{
            intent.getParcelableExtra("product")
        }

        productData?.let {
            tvTitle.text = productData.title
            tvCategory.text = productData.category
            tvDescription.text = productData.description

            val imageURL = productData.images.first()
            Glide.with(ivProduct).load(imageURL).into(ivProduct)
        }
    }
}
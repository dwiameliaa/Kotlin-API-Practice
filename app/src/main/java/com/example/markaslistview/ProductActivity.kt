package com.example.markaslistview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markaslistview.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiservice = retrofit.create(ApiService::class.java)

        apiservice.getProducts().enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    val products = body?.products.orEmpty()

                    val adapter = ProductsAdapter(products)
                    val RecyclerViewExample = findViewById<RecyclerView>(R.id.rv_products)
                    RecyclerViewExample.layoutManager = GridLayoutManager(this@ProductActivity, 2)
                    RecyclerViewExample.adapter = adapter

                    adapter.onItemClick = {product ->
                        val intent = Intent(this@ProductActivity, DetailActivity::class.java)
                        intent.putExtra("product", product)
                        startActivity(intent)
                    }
                } else{
                    Toast.makeText(this@ProductActivity, response.message(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                call: Call<ProductsResponse?>,
                throwable: Throwable
            ) {
                Toast.makeText(this@ProductActivity, throwable.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
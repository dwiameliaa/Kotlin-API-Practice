package com.example.markaslistview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = assets.open("todos-simple.json").bufferedReader().use { it.readText() }
        val data = Gson().fromJson(json, Todo::class.java)

        Log.i("JSONDATA", "$data")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//        https://dummyjson.com/quotes
//        yang quotes itu endpoint nya

        val apiservice = retrofit.create(ApiService::class.java)

//        val call = apiservice.getQuotes()
//        call

        apiservice.getQuotes().enqueue(object : Callback<QuotesResponse> {
            override fun onResponse(
                call: Call<QuotesResponse?>,
                response: Response<QuotesResponse?>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    val quotes = body?.quotes.orEmpty()
//                    tanda tanya disini berarti bahwa jika quotes ini akan terisi jika body nya tidak null

//                    Log.i("GET_QUOTES", "$quotes")
                    val adapter = ItemAdapter(quotes)
                    val RecyclerViewExample = findViewById<RecyclerView>(R.id.rv_quote)
                    RecyclerViewExample.layoutManager = LinearLayoutManager(this@MainActivity)
                    RecyclerViewExample.adapter = adapter

                    adapter.onItemClick = {quotesItem ->
                        Toast.makeText(this@MainActivity, "Quotes: ${quotesItem.quote}"
                        , Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Log.e("GET_QUOTES", response.message())
                }
            }

            //            onfailure itu error2 ketika mau ke backend nya
//            Error saat mencoba menghubungi backend, sebelum mendapatkan respon
            override fun onFailure(
                call: Call<QuotesResponse?>,
                throwable: Throwable
            ) {
                Log.e("GET_QUOTES", throwable.message.toString())
            }

        })

    }
}
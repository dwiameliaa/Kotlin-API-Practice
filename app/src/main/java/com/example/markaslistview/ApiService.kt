package com.example.markaslistview

import retrofit2.Call
//import retrofit2.http.Body
import retrofit2.http.GET
//import retrofit2.http.POST

interface ApiService {
    @GET("quotes")
    fun getQuotes(): Call<QuotesResponse>

    @GET("products")
    fun getProducts(): Call<ProductsResponse>

//    @POST("quotes")
//    fun postQuotes(
//        @Body quotesItem: QuotesItem
//    ): Call<QuotesResponse>
}
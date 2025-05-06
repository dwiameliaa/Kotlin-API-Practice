package com.example.markaslistview

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class QuotesResponse(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("skip")
	val skip: Int,

	@field:SerializedName("quotes")
	val quotes: List<QuotesItem>
) : Parcelable

@Parcelize
data class QuotesItem(

	@field:SerializedName("quote")
	val quote: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("id")
	val id: Int
) : Parcelable

package com.example.markaslistview

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ProductsResponse(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("skip")
	val skip: Int,

	@field:SerializedName("products")
	val products: List<ProductsItem>
) : Parcelable

@Parcelize
data class ProductsItem(

	@field:SerializedName("images")
	val images: List<String>,

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("minimumOrderQuantity")
	val minimumOrderQuantity: Int,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("returnPolicy")
	val returnPolicy: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("weight")
	val weight: Int,

	@field:SerializedName("warrantyInformation")
	val warrantyInformation: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("tags")
	val tags: List<String>,

	@field:SerializedName("discountPercentage")
	val discountPercentage: Double,

	@field:SerializedName("reviews")
	val reviews: List<ReviewsItem>,

	@field:SerializedName("price")
	val price: Double,

	@field:SerializedName("meta")
	val meta: Meta,

	@field:SerializedName("shippingInformation")
	val shippingInformation: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("availabilityStatus")
	val availabilityStatus: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("stock")
	val stock: Int,

	@field:SerializedName("sku")
	val sku: String,

	@field:SerializedName("dimensions")
	val dimensions: Dimensions,

	@field:SerializedName("brand")
	val brand: String?
) : Parcelable

@Parcelize
data class Dimensions(

	@field:SerializedName("depth")
	val depth: Double,

	@field:SerializedName("width")
	val width: Double,

	@field:SerializedName("height")
	val height: Double
) : Parcelable

@Parcelize
data class Meta(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("qrCode")
	val qrCode: String,

	@field:SerializedName("barcode")
	val barcode: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
) : Parcelable

@Parcelize
data class ReviewsItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("reviewerName")
	val reviewerName: String,

	@field:SerializedName("reviewerEmail")
	val reviewerEmail: String,

	@field:SerializedName("rating")
	val rating: Int,

	@field:SerializedName("comment")
	val comment: String
) : Parcelable

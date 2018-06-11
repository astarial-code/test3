package com.shopapp.gateway.entity

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@SuppressLint("ParcelCreator") //https://youtrack.jetbrains.com/issue/KT-19300
@Parcelize
data class ProductVariant(
    val id: String,
    val title: String,
    val price: BigDecimal,
    val isAvailable: Boolean,
    val selectedOptions: List<VariantOption>,
    val image: Image? = null,
    val productImage: Image? = null,
    val productId: String
) : Parcelable

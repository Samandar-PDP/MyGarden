package com.example.sharedelement.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    @DrawableRes val icon: Int,
    val name: String,
    val plantedDate: String,
    val description: String
): Parcelable
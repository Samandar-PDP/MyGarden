package com.example.sharedelement.model

import androidx.annotation.DrawableRes

data class Plant(
    @DrawableRes val icon: Int,
    val name: String,
    val plantedDate: String,
    val description: String
)
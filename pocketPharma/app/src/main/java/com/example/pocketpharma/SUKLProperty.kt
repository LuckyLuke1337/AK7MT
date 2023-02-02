package com.example.pocketpharma

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class SUKLProperty(
    val data: Array<returnData>
)

data class returnData(
    val id: String = "",
    val KOD_LATKY: String ="",
    val NAZEV_INN: String="",
    val NAZEV_EN: String="",
    val NAZEV: String=""
)
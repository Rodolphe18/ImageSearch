package com.example.imagesearch.network.model

import com.example.imagesearch.network.model.Hit

data class PixabayResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)
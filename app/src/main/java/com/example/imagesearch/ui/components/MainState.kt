package com.example.imagesearch.ui.components

import com.example.imagesearch.network.model.Hit

data class MainState(
    val isLoading: Boolean=false,
    val data:List<Hit>  = emptyList(),
    val error:String= ""
)

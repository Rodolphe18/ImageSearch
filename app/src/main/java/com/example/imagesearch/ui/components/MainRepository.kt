package com.example.imagesearch.ui.components

import com.example.imagesearch.network.model.ApiService
import com.example.imagesearch.network.model.PixabayResponse
import com.example.imagesearch.util.Constant
import com.example.imagesearch.util.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQueryItems(q: String): Resource<PixabayResponse>{
      return try {
            val apiRequestResult = apiService.getQueryImages(query = q, apiKey = Constant.API_KEY, imageType = "photo" )
            Resource.Success(data = apiRequestResult)
        } catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

}
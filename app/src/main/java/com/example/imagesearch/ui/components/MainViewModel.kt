package com.example.imagesearch.ui.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearch.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    val list: MutableState<MainState> = mutableStateOf(MainState())

    fun getImageList(q:String)=viewModelScope.launch {
        list.value = MainState(isLoading = true)
        try {
            val apiResult = mainRepository.getQueryItems(q)
            when(apiResult) {
                is Resource.Error -> {
                    list.value = MainState(error = "ERRROR")
                }
                is Resource.Success -> {
                    apiResult.data?.hits?.let {
                        list.value = MainState(data = it)
                    }
                }
            }
        }
        catch (e:Exception)
        {
            list.value = MainState(error = "ERROR")
        }

    }

}
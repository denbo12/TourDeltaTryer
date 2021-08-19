package com.denbofa.tourdelta.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denbofa.tourdelta.API.RetrofitProvider
import com.denbofa.tourdelta.model.SiteModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val items: MutableLiveData<List<SiteModel>> = MutableLiveData()

    fun getAllPhotos(){

        CoroutineScope(Dispatchers.IO).launch {
            val photos: List<SiteModel> = RetrofitProvider.service.getAllPhotos()
            items.postValue(photos)
        }
    }
}
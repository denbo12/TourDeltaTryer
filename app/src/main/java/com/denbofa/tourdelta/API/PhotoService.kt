package com.denbofa.tourdelta.API

import com.denbofa.tourdelta.model.SiteModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoService {
    @GET("photos")
    suspend fun  getAllPhotos(): List<SiteModel>
}
package com.example.mindvalley.api

import com.example.mindvalley.model.CategoryBO
import com.example.mindvalley.model.WebResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoints {

    @GET("A0CgArX3")
    fun getCategories(): Call<WebResponse<List<CategoryBO>>>
}
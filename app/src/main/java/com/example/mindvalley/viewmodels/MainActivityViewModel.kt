package com.example.mindvalley.viewmodels

import com.example.mindvalley.api.ApiEndPoints
import com.example.mindvalley.common.BaseViewModel
import com.example.mindvalley.model.CategoryBO
import com.example.mindvalley.model.WebResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(val apiEndPoints: ApiEndPoints) :BaseViewModel(){

    fun fetchCategories(){
        apiEndPoints.getCategories().enqueue(object : Callback<WebResponse<List<CategoryBO>>> {
            override fun onFailure(call: Call<WebResponse<List<CategoryBO>>>, t: Throwable) {
                if(call.isCanceled){

                }
            }

            override fun onResponse(
                call: Call<WebResponse<List<CategoryBO>>>,
                response: Response<WebResponse<List<CategoryBO>>>
            ) {
                if(response.isSuccessful){

                }
            }
        })
    }
}
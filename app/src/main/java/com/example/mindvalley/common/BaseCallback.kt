package com.example.mindvalley.common

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseCallback<T> : Callback<T>{

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.isSuccessful){
            if(response.body() != null){

            }
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        if(call.isCanceled){

        }
    }

}
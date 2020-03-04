package com.example.mindvalley.common

import com.example.mindvalley.model.WebResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiHandler<T> {

    fun callGenericHit(apiCall: Call<WebResponse<T>>,data: (mType: T) -> Unit)  {
        /*apiCall.enqueue(object : BaseCallback<WebResponse<T>>() {
            override fun onResponse(
                call: Call<WebResponse<T>>,
                response: Response<WebResponse<T>>
            ) {
                super.onResponse(call, response)
            }

            override fun onFailure(call: Call<WebResponse<T>>, t: Throwable) {
                super.onFailure(call, t)
            }
        })*/
        apiCall.enqueue(object :Callback<WebResponse<T>>{
            override fun onResponse(
                call: Call<WebResponse<T>>,
                response: Response<WebResponse<T>>
            ) {
                if(response.isSuccessful){
                    if(response.body() != null)
                        data.invoke((response.body()!!.payload))
                }
            }

            override fun onFailure(call: Call<WebResponse<T>>, t: Throwable) {
                if(call.isCanceled){

                }
            }
        })
    }
}
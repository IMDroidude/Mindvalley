package com.example.mindvalley.model

import com.google.gson.annotations.SerializedName

class GenericResponse<T>{
    @SerializedName("data")
    var data: T? = null
}
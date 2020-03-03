package com.example.mindvalley.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(@SerializedName("datat") val result: WebResponse<T>? = null)
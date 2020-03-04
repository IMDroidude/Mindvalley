package com.example.mindvalley.model

import com.google.gson.annotations.SerializedName

data class WebResponse<T>(@SerializedName("data")val payload: T)


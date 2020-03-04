package com.example.mindvalley.model.categories

import com.google.gson.annotations.SerializedName

data class CategoryPayload(@SerializedName("categories") val categories:List<CategoryBO>){

    companion object {
        fun empty() = CategoryPayload(ArrayList<CategoryBO>())
    }
}
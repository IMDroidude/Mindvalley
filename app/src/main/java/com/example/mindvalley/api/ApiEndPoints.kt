package com.example.mindvalley.api

import com.example.mindvalley.model.categories.CategoryPayload
import com.example.mindvalley.model.GenericResponse
import com.example.mindvalley.model.WebResponse
import com.example.mindvalley.model.channels.ChannelPayload
import com.example.mindvalley.model.episode.EpisodePayload
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoints {

    companion object {
        private const val CATEGORIES = "A0CgArX3"
        private const val EPISODES = "z5AExTtw"
        private const val CHANNELS = "Xt12uVhM"
    }

    @GET(CATEGORIES)
    fun getCategories(): Call<WebResponse<CategoryPayload>>

    @GET(EPISODES)
    fun getNewEpisodes(): Call<WebResponse<EpisodePayload>>

    @GET(CHANNELS)
    fun getChannels() : Call<WebResponse<ChannelPayload>>
}
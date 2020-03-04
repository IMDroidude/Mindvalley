package com.example.mindvalley.model.episode

import com.google.gson.annotations.SerializedName

data class EpisodePayload(@SerializedName("media") val media:List<EpisodeBO>)
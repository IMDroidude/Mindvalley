package com.example.mindvalley.model.channels

import com.google.gson.annotations.SerializedName

data class ChannelPayload(@SerializedName("channels")val payload:List<ChannelBO>)
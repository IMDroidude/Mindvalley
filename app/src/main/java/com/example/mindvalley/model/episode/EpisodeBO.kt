package com.example.mindvalley.model.episode

import com.example.mindvalley.model.channels.ChannelBO

data class EpisodeBO(val type:String,val title:String,val coverAsset:CovertAssetBO,val channel: ChannelLinkBO)
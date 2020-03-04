package com.example.mindvalley.model.channels

import com.example.mindvalley.model.episode.CovertAssetBO

data class ChannelBO(val title:String,val series:List<SeriesBO>,val mediaCount:Int,val latestMedia:List<MediaBO>,
                     val id:String,val iconAsset:IconAssetBO?,val coverAsset:CovertAssetBO)
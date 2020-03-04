package com.example.mindvalley.api

import android.content.Context
import com.example.mindvalley.extensions.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting
}
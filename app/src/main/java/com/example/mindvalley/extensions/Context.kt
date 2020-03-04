package com.example.mindvalley.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

//https://stackoverflow.com/questions/32547006/connectivitymanager-getnetworkinfoint-deprecated
val Context.networkInfo: NetworkInfo? get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
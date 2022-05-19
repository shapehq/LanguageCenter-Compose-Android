package com.novasa.languagecenter.languagecenterliabary_features.use_cases

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.novasa.languagecenter.languagecenterliabary_features.provider.LCContextProviderImpl

@RequiresApi(Build.VERSION_CODES.M)
fun hasInternet(): Boolean {
    val context =  LCContextProviderImpl().context

    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (connectivityManager != null) {
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
            return true
        }
    }
    return false
}
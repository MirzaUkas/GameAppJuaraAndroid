package com.mirz.gameapp.utils

import com.mirz.gameapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("key", BuildConfig.API_KEY).build()
        request = request.newBuilder().url(url).build();
        return chain.proceed(request)
    }
}
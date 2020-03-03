package com.example.mindvalley.di

import com.example.mindvalley.api.ApiEndPoints
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class WebServiceModule  {

    @Provides
    fun provideApiEndpoints(mRetrofit: Retrofit): ApiEndPoints = mRetrofit.create(ApiEndPoints::class.java)
}

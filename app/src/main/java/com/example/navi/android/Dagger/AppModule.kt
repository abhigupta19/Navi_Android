package com.example.navi.android.Dagger

import com.example.navi.android.Network.ApiService
import com.example.navi.android.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
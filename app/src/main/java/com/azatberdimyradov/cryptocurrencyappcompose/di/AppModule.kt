package com.azatberdimyradov.cryptocurrencyappcompose.di

import com.azatberdimyradov.cryptocurrencyappcompose.common.Constants
import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.CoinPaprikaApi
import com.azatberdimyradov.cryptocurrencyappcompose.data.repository.CoinRepositoryImpl
import com.azatberdimyradov.cryptocurrencyappcompose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}
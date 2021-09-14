package com.azatberdimyradov.cryptocurrencyappcompose.data.repository

import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.CoinPaprikaApi
import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.dto.CoinDetailsDto
import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.dto.CoinDto
import com.azatberdimyradov.cryptocurrencyappcompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId = coinId)
    }
}
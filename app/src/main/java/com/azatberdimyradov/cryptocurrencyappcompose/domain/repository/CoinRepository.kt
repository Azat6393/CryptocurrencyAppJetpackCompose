package com.azatberdimyradov.cryptocurrencyappcompose.domain.repository

import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.dto.CoinDetailsDto
import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}
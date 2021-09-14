package com.azatberdimyradov.cryptocurrencyappcompose.presentation.coin_detail

import com.azatberdimyradov.cryptocurrencyappcompose.domain.model.Coin
import com.azatberdimyradov.cryptocurrencyappcompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

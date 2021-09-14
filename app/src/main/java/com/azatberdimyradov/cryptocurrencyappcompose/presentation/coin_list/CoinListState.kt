package com.azatberdimyradov.cryptocurrencyappcompose.presentation.coin_list

import com.azatberdimyradov.cryptocurrencyappcompose.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

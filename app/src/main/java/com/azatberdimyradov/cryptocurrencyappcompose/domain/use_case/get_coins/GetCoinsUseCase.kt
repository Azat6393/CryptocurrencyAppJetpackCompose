package com.azatberdimyradov.cryptocurrencyappcompose.domain.use_case.get_coins

import com.azatberdimyradov.cryptocurrencyappcompose.common.Resource
import com.azatberdimyradov.cryptocurrencyappcompose.data.remote.dto.toCoin
import com.azatberdimyradov.cryptocurrencyappcompose.domain.model.Coin
import com.azatberdimyradov.cryptocurrencyappcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your network connection"))
        }
    }
}
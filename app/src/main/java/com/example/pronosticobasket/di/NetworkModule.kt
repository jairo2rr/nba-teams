package com.example.pronosticobasket.di

import com.example.pronosticobasket.core.RetrofitHelper
import com.example.pronosticobasket.data.BasketRepository
import com.example.pronosticobasket.data.network.BasketApiClient
import com.example.pronosticobasket.data.network.BasketService
import com.example.pronosticobasket.domain.GetAllTeams
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return RetrofitHelper.getRetrofit()
    }

    @Provides
    @Singleton
    fun provideBasketApiClient(retrofit: Retrofit):BasketApiClient{
        return retrofit.create(BasketApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideBasketService(api:BasketApiClient):BasketService{
        return BasketService(api)
    }

    @Provides
    @Singleton
    fun provideGetAllTeams(repository: BasketRepository):GetAllTeams{
        return GetAllTeams(repository)
    }


}
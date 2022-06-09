package com.joncabdev.jettriviatheme.di

import com.google.gson.Gson
import com.joncabdev.jettriviatheme.model.Question
import com.joncabdev.jettriviatheme.network.QuestionApi
import com.joncabdev.jettriviatheme.repository.QuestionRepository
import com.joncabdev.jettriviatheme.util.Constants
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


    @Singleton
    @Provides
    fun provideQuestionRepository(api:QuestionApi) = QuestionRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi():QuestionApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
}
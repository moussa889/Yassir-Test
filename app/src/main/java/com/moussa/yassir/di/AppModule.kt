package com.moussa.yassir.di

import com.moussa.yassir.common.Constants
import com.moussa.yassir.data.remote.MoviesPaprikaApi
import com.moussa.yassir.data.repository.MoviesRepositoryImpl
import com.moussa.yassir.domain.repository.MoviesRepository
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
    fun providePaprikaApi(): MoviesPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesPaprikaApi::class.java)
    }



    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesPaprikaApi): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }
}
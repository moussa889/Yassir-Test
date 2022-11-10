package com.moussa.yassir.data.remote

import com.moussa.yassir.common.Constants.API_KEY
import com.moussa.yassir.data.remote.dto.MovieDto
import com.moussa.yassir.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesPaprikaApi {

    @GET("3/discover/movie?api_key=$API_KEY")
    suspend fun getMovies(): ResponseDto

    @GET("3/movie/{idMovies}?api_key=$API_KEY")
    suspend fun getMovie(@Path("idMovies")idMovies:String): MovieDto

}
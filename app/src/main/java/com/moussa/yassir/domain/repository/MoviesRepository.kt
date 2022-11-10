package com.moussa.yassir.domain.repository

import com.moussa.yassir.data.remote.dto.MovieDto
import com.moussa.yassir.data.remote.dto.ResponseDto

interface MoviesRepository {

    suspend fun getMovies(): ResponseDto

    suspend fun getMovie(idMovies:String): MovieDto
}
package com.moussa.yassir.data.repository

import com.moussa.yassir.data.remote.MoviesPaprikaApi
import com.moussa.yassir.data.remote.dto.MovieDto
import com.moussa.yassir.data.remote.dto.ResponseDto
import com.moussa.yassir.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: MoviesPaprikaApi
) : MoviesRepository {

    override suspend fun getMovies(): ResponseDto {
        return api.getMovies()
    }

    override suspend fun getMovie(idMovies: String): MovieDto {
        return api.getMovie(idMovies)
    }
}
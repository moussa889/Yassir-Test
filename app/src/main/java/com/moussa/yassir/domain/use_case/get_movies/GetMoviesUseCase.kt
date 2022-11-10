package com.moussa.yassir.domain.use_case.get_movies

import com.moussa.yassir.common.Resource
import com.moussa.yassir.data.remote.dto.toMovie
import com.moussa.yassir.domain.model.Movie
import com.moussa.yassir.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading<List<Movie>>())
            val movies = repository.getMovies().results.map { it.toMovie() }
            emit(Resource.Success<List<Movie>>(movies))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Movie>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Movie>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
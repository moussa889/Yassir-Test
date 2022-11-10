package com.moussa.yassir.domain.use_case.get_movie_details

import com.moussa.yassir.common.Resource
import com.moussa.yassir.data.remote.dto.toMovie
import com.moussa.yassir.domain.model.Movie
import com.moussa.yassir.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(IDMovies:String): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading<Movie>())
            val movie = repository.getMovie(IDMovies).toMovie()
            emit(Resource.Success<Movie>(movie))
        } catch(e: HttpException) {
            emit(Resource.Error<Movie>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<Movie>("Couldn't reach server. Check your internet connection."))
        }
    }
}
package com.moussa.yassir.presentation.movie_list

import com.moussa.yassir.domain.model.Movie


data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)

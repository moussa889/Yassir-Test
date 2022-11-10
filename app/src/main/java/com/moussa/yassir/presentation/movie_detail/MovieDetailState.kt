package com.moussa.yassir.presentation.movie_detail

import com.moussa.yassir.domain.model.Movie


data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: Movie? = null,
    val error: String = ""
)

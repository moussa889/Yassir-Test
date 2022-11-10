package com.moussa.yassir.data.remote.dto


data class ResponseDto (
    val page : Int,
    val results : List<MovieDto>,
    val total_pages : Int,
    val total_results : Int
)


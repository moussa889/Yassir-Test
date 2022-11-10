package com.moussa.yassir.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moussa.yassir.presentation.movie_detail.MovieDetailScreen
import com.moussa.yassir.presentation.movie_list.MovieListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MovieListScreen.route
    ) {
        composable(
            route = Screen.MovieListScreen.route
        ) {
            MovieListScreen(navController)
        }
        composable(
            route = Screen.MovieDetailScreen.route + "/{movieId}"
        ) {
            MovieDetailScreen()
        }

    }
}
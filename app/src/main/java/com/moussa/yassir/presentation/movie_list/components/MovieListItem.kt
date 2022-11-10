package com.moussa.yassir.presentation.movie_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.moussa.yassir.common.Constants
import com.moussa.yassir.domain.model.Movie


@Composable
fun MovieListItem(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = rememberAsyncImagePainter(Constants.IMAGE_BASE_URL+movie.poster_path),
            contentDescription = null,
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Fit,

            )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(movie) }
                .padding(start = 5.dp)

            ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = movie.release_date.substring(0,4),
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}
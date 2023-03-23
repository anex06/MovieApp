package com.myjetpack.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.myjetpack.movieapp.navigation.MovieScreens
import com.myjetpack.movieapp.screens.details.DetailsScreen

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent,
            elevation = 0.dp,
        ) {
            Text(text = "Movie")
        }
    }) {
       MainContent(navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf("Avatar", "Batman", "Superman", "Spiderman", "Avengers", "Ironman")){
    Surface(color = MaterialTheme.colors.background) {

        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn{
                items(movieList){ movie ->
                    MovieRow(movie = movie){
                       navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                    }
                }
            }

        }

    }
}
@Composable
fun MovieRow(movie: String,
             onItemClick: (String)->Unit={}){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(movie)
        }
        .height(height = 130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie icon")
            }
            Text(text = movie)
        }

    }
}

package com.myjetpack.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myjetpack.movieapp.screens.home.HomeScreen
import com.myjetpack.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            //The starting of the navhost which will lead us
            HomeScreen(navController)
        }

        composable(MovieScreens.DetailsScreen.name){
          DetailsScreen(navController = navController)
            
        }
    }
}
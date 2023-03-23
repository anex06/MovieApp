package com.myjetpack.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        //Passing the argument
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})){
            backStackEntry->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
            
        }
    }
}
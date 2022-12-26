package com.example.loginapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loginapplication.composable.*

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.Welcome.route){
        composable(route = Screens.Welcome.route){
            WelcomePage(navController)
        }
        composable(route = Screens.Login.route){
            LoginPage(navController)
        }
        composable(route = Screens.Register.route){
            RegisterPage(navController)
        }
        composable(route = Screens.Menu.route){
            MenuPage(navController)
        }
        composable(route = Screens.Message.route){
            MessagePage(navController)
        }
        composable(route = Screens.Profil.route){
            ProfilPage(navController)
        }
    }
}
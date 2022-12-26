package com.example.loginapplication.navigation

sealed class Screens (val route: String){
    object Welcome: Screens("welcome_page")
    object Login: Screens("Login_page")
    object Register: Screens("Register_page")
    object Menu: Screens("Menu_page")
    object Message: Screens("Message_page")
    object Profil: Screens("Profil_page")
}

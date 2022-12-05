package com.example.loginapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapplication.composable.*
import com.example.loginapplication.ui.theme.LoginApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginApplicationTheme {
                // A surface container using the 'background' color from the theme
                Login()
            }
        }
    }

    @Composable
    fun Login(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { RegisterPage(navController = navController) })
            composable("menu_page", content = { MenuPage(navController = navController) })
            composable("message_page", content = { MessagePage(navController = navController) })
            composable("profil_page", content = { ProfilPage(navController = navController) })
        })
    }
}
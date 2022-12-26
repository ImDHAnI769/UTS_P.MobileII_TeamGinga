package com.example.loginapplication.composable

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.loginapplication.navigation.Screens

@Composable
fun MessagePage(navController: NavController){
    var bottomState by remember {
        mutableStateOf("Message")
    }
    val mUrl = "https://wa.me/+6282372956559"
    Scaffold(
        content = {
            AndroidView(factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(mUrl)
                }
            }, update = {
                it.loadUrl(mUrl)
            })
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFFFFC107),
                contentColor = Color.White,
            ) {
                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = {
                        navController.navigate(Screens.Menu.route)
                    },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") }
                )
                BottomNavigationItem(
                    selected = bottomState == "Message",
                    onClick = {
                        navController.navigate(Screens.Message.route)
                    },
                    label = { Text(text = "Message") },
                    icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Message") }
                )
                BottomNavigationItem(
                    selected = bottomState == "Saya",
                    onClick = {
                        navController.navigate(Screens.Profil.route)
                    },
                    label = { Text(text = "Saya") },
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Saya") }
                )
            }
        }
    )
}
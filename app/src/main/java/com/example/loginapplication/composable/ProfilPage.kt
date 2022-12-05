package com.example.loginapplication.composable

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfilPage(navController: NavController){
    var bottomState by remember {
        mutableStateOf("Account")
    }
    val context = LocalContext.current

    Scaffold(
        content = {
            Box(modifier = Modifier.padding(20.dp,0.dp, 20.dp, 0.dp)){
                Button(
                    onClick = {
                        FirebaseAuth.getInstance().signOut()
                        Log.d(ContentValues.TAG, "The user has succesfully logout")
                        Toast.makeText(context,"LogOut Successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate("login_page"){
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "SignOut",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFFFFC107),
                contentColor = Color.White,
            ) {
                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = {
                        navController.navigate("menu_page"){
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") }
                )
                BottomNavigationItem(
                    selected = bottomState == "Message",
                    onClick = {
                        navController.navigate("message_page"){
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    },
                    label = { Text(text = "Message") },
                    icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Message") }
                )
                BottomNavigationItem(
                    selected = bottomState == "Account",
                    onClick = {
                        navController.navigate("profil_page"){
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    },
                    label = { Text(text = "Account") },
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account") }
                )
            }
        }
    )
}
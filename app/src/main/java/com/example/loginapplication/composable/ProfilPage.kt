package com.example.loginapplication.composable

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapplication.navigation.Screens
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfilPage(navController: NavController){
    var bottomState by remember {
        mutableStateOf("Saya")
    }
    val context = LocalContext.current

    Scaffold(
        content = {
            Card(
                elevation = 8.dp,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {

                Row(modifier= Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp)
                    .border(width = 1.dp, color = Color.Blue)
                    .padding(12.dp)

                ) {
                    Image(
                        painter = painterResource(id = com.example.loginapplication.R.drawable.icons8_user_100),
                        contentDescription = "",
                        contentScale= ContentScale.Crop,
                        modifier= Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                    Column() {
                        Text(text = "Pengguna")
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Box(modifier = Modifier.padding(20.dp,0.dp, 20.dp, 0.dp)){
                Button(
                    onClick = {
                        FirebaseAuth.getInstance().signOut()
                        Log.d(ContentValues.TAG, "The user has succesfully logout")
                        Toast.makeText(context,"LogOut Successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screens.Login.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Sign out",
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
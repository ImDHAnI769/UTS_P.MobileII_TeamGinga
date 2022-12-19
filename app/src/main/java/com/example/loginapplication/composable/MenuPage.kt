package com.example.loginapplication.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MenuPage(navController: NavController){
    var bottomState by remember {
        mutableStateOf("Home")
    }
    //val fabShape = RoundedCornerShape(50)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Keripik IBUMM")},
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                },
                backgroundColor = Color(0xFFFFC107),
                contentColor = Color.White,
                elevation = 8.dp,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notification")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shopping")
                    }
                }
            )
        },
        content = {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding()
                    .scrollable(scrollState, orientation = Orientation.Vertical)
            ) {
                repeat(100) {
                    Card(
                        backgroundColor = Color(0xFFFFC107),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    }
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
                    label = { Text(text = "Home")},
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home")}
                )
                BottomNavigationItem(
                    selected = bottomState == "Message",
                    onClick = {
                        navController.navigate("message_page"){
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    },
                    label = { Text(text = "Message")},
                    icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Message")}
                )
                BottomNavigationItem(
                    selected = bottomState == "Account",
                    onClick = {
                        navController.navigate("profil_page"){
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    },
                    label = { Text(text = "Account")},
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account")}
                )
            }
        }
    )
}

@Composable
fun SearchAppBar() {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.White.copy(
                    alpha = ContentAlpha.medium
                )
            )
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close Icon",
                    tint = Color.White
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White.copy(
                alpha = ContentAlpha.medium
            ),
            focusedBorderColor = Color.White,
            cursorColor = Color.White
        ),
        placeholder = {
            Text(
                text = "Search....",
                color = Color.White.copy(alpha = ContentAlpha.medium),
                fontFamily = FontFamily.SansSerif
            )
        }
    )
}
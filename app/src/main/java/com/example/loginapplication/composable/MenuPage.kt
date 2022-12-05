package com.example.loginapplication.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MenuPage(navController: NavController){
    var bottomState by remember {
        mutableStateOf("Home")
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Top App Bar")},
                navigationIcon = {
                    IconButton(onClick = {}) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                    //.verticalScroll(rememberScrollableState(consumeScrollDelta = )),
                verticalArrangement = Arrangement.spacedBy(26.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    elevation = 20.dp
                ) {
                    Surface(
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .height(210.dp)
                            .padding(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(24.dp),
                                    modifier = Modifier.wrapContentSize(),
                                    color = Color(0xFFFF9800)
                                ) {
                                    Text(
                                        text = "New release",
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.h1,
                                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "Keripik Pisang 'Original'",
                                    fontSize = 24.sp,
                                    style = MaterialTheme.typography.h1,
                                    fontWeight = FontWeight.SemiBold
                                )

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(text = "Harga : 30K")

                                Spacer(modifier = Modifier.height(2.dp))

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "4.0",
                                        fontSize =  14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = MaterialTheme.typography.h1
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))

                                    Icon(painter = painterResource(id = com.example.loginapplication.R.drawable.ic_baseline_star_24),
                                        tint = Color(0xFFFFC107),
                                        contentDescription = null
                                    )
                                    Icon(painter = painterResource(id = com.example.loginapplication.R.drawable.ic_baseline_star_24),
                                        tint = Color(0xFFFFC107),
                                        contentDescription = null
                                    )
                                    Icon(painter = painterResource(id = com.example.loginapplication.R.drawable.ic_baseline_star_24),
                                        tint = Color(0xFFFFC107),
                                        contentDescription = null
                                    )
                                    Icon(painter = painterResource(id = com.example.loginapplication.R.drawable.ic_baseline_star_24),
                                        tint = Color(0xFFFFC107),
                                        contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))

                                OutlinedButton(
                                    shape = RoundedCornerShape(24.dp),
                                    modifier = Modifier.wrapContentSize(),
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.Black,
                                        backgroundColor = Color.White
                                    ),
                                    onClick = { /*TODO*/ }
                                ) {
                                    Text(
                                        text = "Beli",
                                        fontSize =  16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = MaterialTheme.typography.h1,
                                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                                    )
                                }
                            }

                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.size(width = 100.dp, height = 140.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = com.example.loginapplication.R.drawable.img_20221007_wa0008),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = null
                                )
                            }
                        }
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


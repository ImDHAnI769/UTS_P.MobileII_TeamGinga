package com.example.loginapplication.composable

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.loginapplication.navigation.Screens

@Composable
fun MenuPage(navController: NavController){
    var bottomState by remember {
        mutableStateOf("Home")
    }

    Scaffold(
        content = {
            val scrollState = rememberScrollState()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                elevation = 10.dp
            ) {
                Surface(
                    color = MaterialTheme.colors.primaryVariant,
                    modifier = Modifier
                        .height(210.dp)
                        .padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
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
                                color = Color(0xFFD1D5E1)
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
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.Black,
                                    backgroundColor = Color.White
                                ),
                                onClick = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp, top = 10.dp)
                            ) {
                                Text(
                                    text = "Beli",
                                    fontSize =  80.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.h2
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
                    label = { Text(text = "Home")},
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home")}
                )
                BottomNavigationItem(
                    selected = bottomState == "Pesan",
                    onClick = {
                        navController.navigate(Screens.Message.route)
                    },
                    label = { Text(text = "Pesan")},
                    icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Pesan")}
                )
                BottomNavigationItem(
                    selected = bottomState == "Saya",
                    onClick = {
                        navController.navigate(Screens.Profil.route)
                    },
                    label = { Text(text = "Saya")},
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Saya")}
                )
            }
        }
    )
}
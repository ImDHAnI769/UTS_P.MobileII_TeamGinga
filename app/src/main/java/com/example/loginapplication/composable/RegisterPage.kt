package com.example.loginapplication.composable

import android.content.ContentValues
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun RegisterPage(navController: NavController){
    val MyCustomTypography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
    )
    val focusManager = LocalFocusManager.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf {
        password.length > 7
    }

    val isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()
        .padding(bottom = 130.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {

        MaterialTheme(typography = MyCustomTypography) {
            Text(text = "Register",
                style = MaterialTheme.typography.overline,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        MaterialTheme(typography = MyCustomTypography) {
            Text(text = "Please sign in to Register",
                style = MaterialTheme.typography.overline,
                color = Color.DarkGray,
                fontStyle = FontStyle.Normal,
                fontSize = 15.sp,
                modifier = Modifier.padding( bottom = 16.dp)
            )

            Card(modifier = Modifier
                .padding(horizontal = 8.dp),
                shape = MaterialTheme.shapes.large,
                border = BorderStroke(1.dp, color = Color.White)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(all = 10.dp),) {
                    OutlinedTextField(value = email, colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black), onValueChange ={email = it},
                        label = {
                            Text(text = "Email Address",
                                color = Color.Black)
                        },
                        placeholder = {
                            Text(text = "example123@gmail.com",
                                color = Color.DarkGray)
                        },
                        singleLine = true,
                        modifier = Modifier,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        isError = !isEmailValid,
                        trailingIcon = {
                            if (email.isNotBlank()){
                                IconButton(onClick = {email = ""}) {
                                    Icon(  imageVector = Icons.Filled.Clear ,
                                        contentDescription = "Clear Email")

                                }
                            }
                        }
                    )

                    OutlinedTextField(value = password,colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black), onValueChange ={password = it},
                        label = {
                            Text(text = "Password",
                                color = Color.Black)
                        },
                        placeholder = {
                            Text(text = "abc123",
                                color = Color.DarkGray)
                        },
                        singleLine = true,
                        modifier = Modifier,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        isError = !isPasswordValid,
                        trailingIcon = {
                            IconButton(onClick = {isPasswordVisible != isPasswordVisible}) {
                                Icon(  imageVector = if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle Password Visibility")

                            }

                        },
                        visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Button(onClick = {
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                            if (it.isSuccessful) {
                                Log.d(ContentValues.TAG, "The user has succesfully Regsiter")
                                Toast.makeText(context,"Register Successfully",Toast.LENGTH_SHORT).show()
                                navController.navigate("login_page"){
                                    popUpTo = navController.graph.startDestinationId
                                    launchSingleTop = true
                                }
                            } else {
                                it.exception
                                Log.w(ContentValues.TAG, "Sorry! can not register", it.exception)
                                Toast.makeText(context,"Sorry! can not Register, because the Email or Password is no Filled",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                    }) {
                        Text(text = "Register",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,)

                    }

                }

            }
        }
    }
}
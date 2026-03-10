package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun LoginScreen(viewModel:LoginViewModel){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Button(onClick = {
            viewModel.login(email,password)
        }){

            Text("Login")

        }

    }
}
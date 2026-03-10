package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    email: String,
    viewModel: ProfileViewModel = hiltViewModel()
){

    LaunchedEffect(Unit) {

        viewModel.loadUser(email)

    }

    val user = viewModel.user

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Profile")

        Spacer(Modifier.height(16.dp))

        Text("Email: ${user?.email}")

    }

}
package com.zulhija_nanda.product.pokedata.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
){

    val isLoggedIn by viewModel.isLoggedIn.collectAsStateWithLifecycle()

    LaunchedEffect (isLoggedIn){

        Log.d("JOEL", "SplashScreen: $isLoggedIn")

        when(isLoggedIn){
            true -> {
                navController.navigate("main"){
                    popUpTo("splash"){
                        inclusive = true
                    }
                }
            }
            false -> {
                navController.navigate("login"){
                    popUpTo("splash"){
                        inclusive = true
                    }
                }
            }
            null -> {
                // masih loading
            }
        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator()

    }


}
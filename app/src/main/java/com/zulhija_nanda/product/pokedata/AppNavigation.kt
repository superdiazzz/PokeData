package com.zulhija_nanda.product.pokedata

import android.util.Log
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zulhija_nanda.product.pokedata.ui.screen.*

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("login",
            enterTransition = { fadeIn() },
            exitTransition = {
                slideOutHorizontally { -it } + fadeOut()
            }
            ) {
            LoginScreen(navController)
        }

        composable("register",
            enterTransition = {
                slideInHorizontally { it } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { it } + fadeOut()
            }) {
            RegisterScreen(navController)
        }

        composable("main",
            enterTransition = {
                scaleIn(initialScale = 0.9f) + fadeIn()
            },
            exitTransition = {
                fadeOut()
            }) {
            MainScreen(navController)
        }

    }
}
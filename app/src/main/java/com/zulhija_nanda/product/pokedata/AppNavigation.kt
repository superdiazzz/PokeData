package com.zulhija_nanda.product.pokedata

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
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }

        composable("main") {
            MainScreen()
        }

        composable("detail/{name}") { backStackEntry ->

            val name = backStackEntry.arguments?.getString("name") ?: ""

            DetailScreen(name)

        }

    }
}
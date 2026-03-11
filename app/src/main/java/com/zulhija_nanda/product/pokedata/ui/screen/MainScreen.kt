package com.zulhija_nanda.product.pokedata.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zulhija_nanda.product.pokedata.ui.components.BottomTab

@Composable
fun MainScreen(parentNavController: NavHostController){
    val tabs = listOf(
        BottomTab.Home,
        BottomTab.Profile
    )

    val navController = rememberNavController()


    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {

                tabs.forEach { tab ->

                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            navController.navigate(tab.route){
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(tab.title) },
                        icon = { Icon(tab.icon, null) }
                    )
                }
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = BottomTab.Home.route,
            modifier = Modifier.padding(padding)
        ){
            composable(BottomTab.Home.route){
                HomeScreen(parentNavController, navController)
            }
            composable(BottomTab.Profile.route){
                ProfileScreen(email = "test@gmail.com", navController = navController)
            }

            composable("detail/{name}") { backStackEntry ->

                val name = backStackEntry.arguments?.getString("name") ?: ""
                Log.d("JOEL", "AppNavigation: detail name $name")
                DetailScreen(name)
            }
        }
    }

}
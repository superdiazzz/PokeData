package com.zulhija_nanda.product.pokedata.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab (
    val route: String,
    val title: String,
    val icon: ImageVector
){

    object Home: BottomTab(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomTab(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

}
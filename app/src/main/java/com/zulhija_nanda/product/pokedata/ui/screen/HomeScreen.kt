package com.zulhija_nanda.product.pokedata.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.zulhija_nanda.product.pokedata.ui.components.SearchPokemonDialog


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    parentNavController: NavHostController,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
){

    val context = LocalContext.current

    var showSearch by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Daftar Pokemon")
                },
                actions = {

                    IconButton(
                        onClick = { showSearch = true }
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }

                    IconButton(
                        onClick = {
                            viewModel.logout()
                            parentNavController.navigate("login") {
                                popUpTo("main") {
                                    inclusive = true
                                }
                            }
                            Toast.makeText(context, "Sukses logout", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Logout,
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        }
    ) { padding ->
        PokemonListContent(
            navController = navController,
            modifier = Modifier.padding(padding),
            viewModel = viewModel
        )

        if (showSearch) {
            SearchPokemonDialog(
                onDismiss = { showSearch = false },
                onSearch = { name ->
                    navController.navigate("detail/$name")
                    showSearch = false
                }
            )
        }
    }

}

@Composable
private fun PokemonListContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeViewModel
){
    LazyColumn (
        modifier = modifier.fillMaxSize()
    ){
        itemsIndexed(viewModel.pokemonList) {index, pokemon ->

            if(index >= viewModel.pokemonList.size - 2){
                viewModel.loadMore()
            }

            ListItem(
                headlineContent = {
                    Text(pokemon.name)
                },
                modifier = Modifier.clickable {
                    navController.navigate("detail/${pokemon.name}")
                }
            )

            HorizontalDivider()
        }
    }
}
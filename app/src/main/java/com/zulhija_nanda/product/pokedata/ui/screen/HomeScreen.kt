package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
){

    LazyColumn {
        itemsIndexed(viewModel.pokemonList) {index, pokemon ->
            if(index >= viewModel.pokemonList.size - 2){
                viewModel.loadMore()
            }

            Text(
                text = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                        navController.navigate("detail/${pokemon.name}")

                    }
                    .padding(16.dp)
            )
        }
    }

}
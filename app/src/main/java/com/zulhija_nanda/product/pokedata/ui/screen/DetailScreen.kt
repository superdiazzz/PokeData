package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    name: String,
    viewModel: DetailViewModel = hiltViewModel()
){

    LaunchedEffect(Unit) {

        viewModel.loadDetail(name)

    }

    val pokemon = viewModel.pokemon

    if (pokemon == null) {

        CircularProgressIndicator()

    } else {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(Modifier.height(16.dp))

            Text("Abilities:")

            pokemon.abilities.forEach {

                Text("- ${it.ability.name}")

            }
        }
    }
}
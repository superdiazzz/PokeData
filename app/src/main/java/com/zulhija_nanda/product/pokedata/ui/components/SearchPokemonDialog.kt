package com.zulhija_nanda.product.pokedata.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun SearchPokemonDialog( onDismiss: () -> Unit,
                         onSearch: (String) -> Unit
) {

    var query by remember { mutableStateOf("") }

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {
            Text("Search Pokemon")
        },

        text = {

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Pokemon name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

        },

        confirmButton = {

            TextButton(
                onClick = {
                    if (query.isNotBlank()) {
                        onSearch(query.lowercase())
                    }
                }
            ) {
                Text("Search")
            }

        },

        dismissButton = {

            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }

        }

    )

}
package com.zulhija_nanda.product.pokedata.data.remote

data class PokemonDetailResponse(
    val name: String,
    val abilities: List<AbilitySlot>
)

data class AbilitySlot(
    val ability: Ability
)

data class Ability(
    val name: String
)
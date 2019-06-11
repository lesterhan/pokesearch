package com.pokesearch

import org.springframework.stereotype.Component

@Component
class PokemonService(val pokemonRepository: PokemonRepository) {
    private val pokemonTypes = listOf("bug", "dragon", "ice", "fighting", "fire", "flying",
            "grass", "ghost", "ground", "electric", "normal", "poison", "psychic",
            "rock", "water", "dark", "steel", "fairy", "bird", "shadow")

    fun search(searchTerm: String?): String {
        if (pokemonTypes.contains(searchTerm)) {
            return searchByType(searchTerm)
        }

        val resultPokemon = pokemonRepository.findByName(searchTerm)
        return resultPokemon?.toString() ?: "NO RESULTS!"
    }

    private fun searchByType(searchTerm: String?): String {
        val resultPokemon = pokemonRepository.findAllByType(searchTerm)
        val resultPokemonNames = resultPokemon.map { it.name }

        return "${resultPokemon.size} $searchTerm Pokémon\n$resultPokemonNames"
    }
}

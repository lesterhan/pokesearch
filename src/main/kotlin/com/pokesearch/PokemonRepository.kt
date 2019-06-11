package com.pokesearch

import com.data.Pokedex
import com.data.Pokemon
import org.springframework.stereotype.Repository

@Repository
class PokemonRepository {
    fun findByName(searchTerm: String?): Pokemon? {
        val cleanSearchTerm = cleanSearchTerm(searchTerm)
        return Pokedex.data().find { it.name.toLowerCase() == cleanSearchTerm }
    }

    fun findAllByType(searchTerm: String?): List<Pokemon> {
        val cleanSearchTerm = cleanSearchTerm(searchTerm)

        val typeOneOrTypeTwoEquals = { pokemon: Pokemon ->
            pokemon.type1.toLowerCase() == cleanSearchTerm || pokemon.type2.toLowerCase() == cleanSearchTerm
        }

        return Pokedex.data().filter { typeOneOrTypeTwoEquals(it) }
    }

    private fun cleanSearchTerm(searchTerm: String?) = searchTerm?.toLowerCase()?.trim()
}

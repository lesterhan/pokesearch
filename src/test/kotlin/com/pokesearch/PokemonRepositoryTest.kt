package com.pokesearch

import com.data.Pokemon
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

internal class PokemonRepositoryTest {
    val pokemonRepository = PokemonRepository()

    @Test
    fun findByNameShouldReturnOnePokemonWithMatchingName() {
        val pikachu = Pokemon(
                25,"Pikachu","Electric","",
                320,35,55,40,50,
                50,90,1,false
        )

        pokemonRepository.findByName("Pikachu") shouldEqual pikachu
    }

    @Test
    fun findByNameShouldIgnoreCase() {
        val pikachu = Pokemon(
                25,"Pikachu","Electric","",
                320,35,55,40,50,
                50,90,1,false
        )

        pokemonRepository.findByName("pikachu") shouldEqual pikachu
    }

    @Test
    fun findByTypeShouldReturnListOfPokemonWithMatchingType() {
        val resultList = pokemonRepository.findAllByType("electric")
        resultList.size shouldEqual 50
    }
}

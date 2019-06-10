package com.pokesearch

import com.data.Pokemon
import org.amshove.kluent.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PokemonServiceTest {
    private var pokemonRepository = mock(PokemonRepository::class)
    private val pokemonService = PokemonService(pokemonRepository)

    @Test
    fun returnExactPokemonWhenSearchingCorrectName() {
        val searchTerm = "charizard"

        pokemonService.search(searchTerm)

        Verify on pokemonRepository that pokemonRepository.findByName(searchTerm) was called
    }

    @Test
    fun returnNoResultsWhenThereAreNoMatches() {
        val result = pokemonService.search("michael jackson")
        result shouldEqual "NO RESULTS!"
    }

    @Test
    fun whenSearchingATypeReturnNumberOfMatchingTypeAndAllNamesOfTheType() {
        val searchTerm = "fire"
         When calling pokemonRepository.findAllByType(searchTerm) itReturns listOf(
                 Pokemon(1337, "name1", "fire","",1,1,1,1,1,1,1,1, false),
                 Pokemon(1338, "name2", "fire","",1,1,1,1,1,1,1,1, false)
         )
        val result = pokemonService.search(searchTerm)
        result shouldEqual "2 fire Pokémon\n[name1, name2]"
    }
}

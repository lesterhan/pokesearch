package com.pokesearch

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

internal class PokemonServiceTest {
    private var pokemonService = PokemonService()

    @Test
    fun returnExactPokemonWhenSearchingCorrectName() {
        val result = pokemonService.search("pikachu")
        result shouldEqual "Pokemon(id=25, name=Pikachu, type1=Electric, " +
                "type2=, total=320, hp=35, attack=55, defence=40, spAttack=50, " +
                "spDefence=50, speed=90, generation=1, legendary=false)"
    }

    @Test
    fun returnNoResultsWhenThereAreNoMatches() {
        val result = pokemonService.search("michael jackson")
        result shouldEqual "NO RESULTS!"
    }

    @Test
    fun whenSearchingATypeReturnNumberOfMatchingTypeAndAllNamesOfTheType() {
        val result = pokemonService.search("electric")
        result shouldEqual "50 electric Pokémon\n[Pikachu, Raichu, Magnemite, " +
                "Magneton, Voltorb, Electrode, Electabuzz, Jolteon, Zapdos, Chinchou, " +
                "Lanturn, Pichu, Mareep, Flaaffy, Ampharos, AmpharosMega Ampharos, Elekid, " +
                "Raikou, Electrike, Manectric, ManectricMega Manectric, Plusle, Minun, Shinx, " +
                "Luxio, Luxray, Pachirisu, Magnezone, Electivire, Rotom, RotomHeat Rotom, RotomWash " +
                "Rotom, RotomFrost Rotom, RotomFan Rotom, RotomMow Rotom, Blitzle, Zebstrika, Emolga, " +
                "Joltik, Galvantula, Tynamo, Eelektrik, Eelektross, Stunfisk, ThundurusIncarnate Forme, " +
                "ThundurusTherian Forme, Zekrom, Helioptile, Heliolisk, Dedenne]"
    }
}

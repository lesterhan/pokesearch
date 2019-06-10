package com.data

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class Pokedex {
    companion object {
        private var pokemon: List<Pokemon> = emptyList()

        private val POKEMON_ID_INDEX = 0
        private val POKEMON_NAME_INDEX = 1
        private val POKEMON_TYPE1_INDEX = 2
        private val POKEMON_TYPE2_INDEX = 3
        private val POKEMON_TOTAL_INDEX = 4
        private val POKEMON_HP_INDEX = 5
        private val POKEMON_ATTACK_INDEX = 6
        private val POKEMON_DEFENCE_INDEX = 7
        private val POKEMON_SPATTACK_INDEX = 8
        private val POKEMON_SPDEFENCE_INDEX = 9
        private val POKEMON_SPEED_INDEX = 10
        private val POKEMON_GENERATION = 11
        private val POKEMON_LEGENARDY = 12

        fun data (): List<Pokemon> {
            hydrateDataIfEmpty()
            return pokemon
        }

        private fun hydrateDataIfEmpty() {
            if(pokemon.isNotEmpty()) {
                return
            }

            var fileReader: BufferedReader? = null
            val pokemonListFromCsv: MutableList<Pokemon> = mutableListOf<Pokemon>()
            try {
                var line: String?
                fileReader = BufferedReader(FileReader("src/main/kotlin/com/data/pokemon.csv"))
                fileReader.readLine() // Read header

                line = fileReader.readLine()
                while (line != null) {
                    val tokens = line.split(",")
                    if (tokens.isNotEmpty()) {
                        val pokemonFromCsv = Pokemon(
                            tokens[POKEMON_ID_INDEX].toInt(),
                            tokens[POKEMON_NAME_INDEX],
                            tokens[POKEMON_TYPE1_INDEX],
                            tokens[POKEMON_TYPE2_INDEX],
                            tokens[POKEMON_TOTAL_INDEX].toInt(),
                            tokens[POKEMON_HP_INDEX].toInt(),
                            tokens[POKEMON_ATTACK_INDEX].toInt(),
                            tokens[POKEMON_DEFENCE_INDEX].toInt(),
                            tokens[POKEMON_SPATTACK_INDEX].toInt(),
                            tokens[POKEMON_SPDEFENCE_INDEX].toInt(),
                            tokens[POKEMON_SPEED_INDEX].toInt(),
                            tokens[POKEMON_GENERATION].toInt(),
                            tokens[POKEMON_LEGENARDY].toBoolean())
                        pokemonListFromCsv.add(pokemonFromCsv)
                    }
                    line = fileReader.readLine()
                }
                pokemon = pokemonListFromCsv
            } catch (e: Exception) {
                println("Reading CSV Error!")
                e.printStackTrace()
            } finally {
                try {
                    fileReader!!.close()
                } catch (e: IOException) {
                    println("Closing fileReader Error!")
                    e.printStackTrace()
                }
            }
        }
    }
}

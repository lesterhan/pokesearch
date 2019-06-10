package com.pokesearch

fun main() {
    val pokemonService = PokemonService()
    while(true) {
        // pokemon center
        // todo: move search to a repo, Pokedex should only be data
        // todo: a service layer that uses the repo

        // todo: user stories:
        // done: when i search for the exact name of a pokemon, i get all their stats
        // done: when i search for a type of pokemon, say 'fire', i get how many fires types there are and a list of pokemon names of that type
        // todo: when i search for pikachu, say "Pika! Pika! I'm Ryan Reynolds!"
        // todo: when i search for a fire type pokemon, i get a paragraph about what they're strong against
        // todo: when i search for a lengendary, i get a paragraph about which game they're from

        println("Search the Pokédex! Try 'name' or 'type' (ex. 'pikachu' or 'Electric')")
        val searchTerm = readLine()
        println(pokemonService.search(searchTerm))
    }

}

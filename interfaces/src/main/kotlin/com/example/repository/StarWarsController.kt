package com.example.repository

import com.example.domain.Character
import com.example.domain.Episode
import com.example.usercases.StarWarsService

class StarWarsController(private val starWarsService: StarWarsService) {
    fun createNewHuman(name: String, homePlanet: String, height: Double): Character =
        starWarsService.createHuman(name, homePlanet, height)

    fun createNewDroid(name: String, primaryFunction: String): Character =
        starWarsService.createDroid(name, primaryFunction)

    fun deleteCharacter(id: Int): Int =
        starWarsService.deleteCharacter(id)

    fun getAllCharacters(): List<Character> =
        starWarsService.listCharacters()

    fun filterCharactersByEpisode(episode: Episode): List<Character> =
        starWarsService.filterCharactersByEpisode(episode)
}

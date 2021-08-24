package com.example.repository

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Episode
import com.example.domain.Human
import com.example.usercases.StarWarsService

class StarWarsController(private val starWarsService: StarWarsService) {
    fun createNewHuman(name: String, homePlanet: String, height: Double): Character {
        val id = starWarsService.getNewId()
        val human = Human(id, name, listOf(), setOf(), homePlanet, height)
        return starWarsService.createCharacter(human)
    }

    fun createNewDroid(name: String, primaryFunction: String): Character {
        val id = starWarsService.getNewId()
        val droid = Droid(id, name, listOf(), setOf(), primaryFunction)
        return starWarsService.createCharacter(droid)
    }

    fun deleteCharacter(id: Int): Int =
        starWarsService.deleteCharacter(id)

    fun getAllCharacters(): List<Character> =
        starWarsService.listCharacters()

    fun filterCharactersByEpisode(episode: Episode): List<Character> =
        starWarsService.filterCharactersByEpisode(episode)
}

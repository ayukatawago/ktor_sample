package com.example.usercases

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Episode
import com.example.domain.Human

interface StarWarsService {
    fun createHuman(name: String, homePlanet: String, height: Double): Human
    fun createDroid(name: String, primaryFunction: String): Droid
    fun deleteCharacter(id: Int): Int
    fun getCharacterById(id: Int): Character?
    fun listCharacters(): List<Character>
    fun filterCharactersByEpisode(episode: Episode): List<Character>
}

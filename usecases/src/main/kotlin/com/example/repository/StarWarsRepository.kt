package com.example.repository

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Human

interface StarWarsRepository {
    fun addDroid(name: String, primaryFunction: String): Droid
    fun addHuman(name: String, homePlanet: String, height: Double): Human
    fun deleteCharacter(character: Character)
    fun findCharacter(id: Int): Character?
    fun findAllCharacters(): List<Character>
}

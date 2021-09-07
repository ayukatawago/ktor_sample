package com.example.repository

import com.example.domain.Character

interface StarWarsRepository {
    fun getCurrentId(): Int
    fun createCharacter(character: Character): Character
    fun deleteCharacter(character: Character)
    fun findCharacter(id: Int): Character
    fun findAllCharacters(): List<Character>
}

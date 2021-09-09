package com.example.usercases

import com.example.domain.Character
import com.example.domain.Episode

interface StarWarsService {
    fun getNewId(): Int
    fun createCharacter(character: Character): Character
    fun deleteCharacter(id: Int): Int
    fun getCharacterById(id: Int): Character?
    fun listCharacters(): List<Character>
    fun filterCharactersByEpisode(episode: Episode): List<Character>
}

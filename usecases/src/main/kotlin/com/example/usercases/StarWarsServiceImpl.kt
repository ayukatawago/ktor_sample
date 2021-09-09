package com.example.usercases

import com.example.domain.Character
import com.example.domain.Episode
import com.example.repository.StarWarsRepository

class StarWarsServiceImpl(private val repository: StarWarsRepository) : StarWarsService {
    override fun getNewId(): Int =
        repository.getCurrentId() + 1

    override fun createCharacter(character: Character): Character =
        repository.createCharacter(character)

    override fun deleteCharacter(id: Int): Int {
        val character = repository.findCharacter(id)
        character?.let(repository::deleteCharacter)
        return id
    }

    override fun getCharacterById(id: Int): Character? =
        repository.findCharacter(id)

    override fun listCharacters(): List<Character> =
        repository.findAllCharacters()

    override fun filterCharactersByEpisode(episode: Episode): List<Character> =
        repository.findAllCharacters().filter {
            episode in it.appearsIn
        }
}

package com.example.usercases

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Episode
import com.example.domain.Human
import com.example.repository.StarWarsRepository

class StarWarsServiceImpl(private val repository: StarWarsRepository) : StarWarsService {
    override fun createDroid(name: String, primaryFunction: String): Droid =
        repository.addDroid(name, primaryFunction)

    override fun createHuman(name: String, homePlanet: String, height: Double): Human =
        repository.addHuman(name, homePlanet, height)

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

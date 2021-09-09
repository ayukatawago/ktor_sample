package com.example.repository

import com.example.domain.Character

class DummyStarWarsRepositoryImpl : StarWarsRepository {
    private var id: Int = 0

    private val data = mutableListOf<Character>()

    override fun getCurrentId(): Int = id

    override fun createCharacter(character: Character): Character {
        data.add(character)
        id++
        return character
    }

    override fun deleteCharacter(character: Character) {
        val target = data.first { it.id == character.id }
        data.remove(target)
    }

    override fun findCharacter(id: Int): Character? {
        return data.first { it.id == id }
    }

    override fun findAllCharacters(): List<Character> {
        return data.toList()
    }
}

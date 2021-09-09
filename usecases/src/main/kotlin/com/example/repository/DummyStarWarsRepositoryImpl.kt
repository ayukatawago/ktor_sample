package com.example.repository

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Human

class DummyStarWarsRepositoryImpl : StarWarsRepository {
    private var id: Int = 0

    private val data = mutableListOf<Character>()

    override fun addDroid(name: String, primaryFunction: String): Droid =
        Droid(id++, name, listOf(), setOf(), primaryFunction).also {
            data.add(it)
        }

    override fun addHuman(name: String, homePlanet: String, height: Double): Human =
        Human(id++, name, listOf(), setOf(), homePlanet, height).also {
            data.add(it)
        }

    override fun deleteCharacter(character: Character) {
        val target = data.first { it.id == character.id }
        data.remove(target)
    }

    override fun findCharacter(id: Int): Character? {
        return data.firstOrNull { it.id == id }
    }

    override fun findAllCharacters(): List<Character> {
        return data.toList()
    }
}

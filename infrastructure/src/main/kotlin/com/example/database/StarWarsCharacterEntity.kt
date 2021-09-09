package com.example.database

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Human
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class StarWarsCharacterEntity(id: EntityID<Int>) : IntEntity(id) {
    var name by StarWarsCharactersDao.name
    var homePlanet by StarWarsCharactersDao.homePlanet
    var height by StarWarsCharactersDao.height
    var primaryFunction by StarWarsCharactersDao.primaryFunction

    fun getCharacter(): Character =
        if (height < 0) {
            Droid(id.value, name, listOf(), setOf(), primaryFunction)
        } else {
            Human(id.value, name, listOf(), setOf(), homePlanet, height)
        }

    fun setCharacter(character: Character) {
        name = character.name
        when (character) {
            is Droid -> {
                homePlanet = ""
                primaryFunction = character.primaryFunction
                height = -1.0
            }
            is Human -> {
                homePlanet = character.homePlanet
                height = character.height
                primaryFunction = ""
            }
        }
    }

    companion object : IntEntityClass<StarWarsCharacterEntity>(StarWarsCharactersDao)
}

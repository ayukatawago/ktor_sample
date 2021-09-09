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
    var type by StarWarsCharactersDao.type

    fun getCharacter(): Character =
        when (type) {
            CharacterType.DROID -> Droid(id.value, name, listOf(), setOf(), primaryFunction)
            CharacterType.HUMAN -> Human(id.value, name, listOf(), setOf(), homePlanet, height)
        }

    fun setDroid(name: String, primaryFunction: String) {
        this.name = name
        this.primaryFunction = primaryFunction
        this.homePlanet = ""
        this.height = 0.0
        this.type = CharacterType.DROID
    }

    fun setHuman(name: String, homePlanet: String, height: Double) {
        this.name = name
        this.primaryFunction = ""
        this.homePlanet = homePlanet
        this.height = height
        this.type = CharacterType.HUMAN
    }

    companion object : IntEntityClass<StarWarsCharacterEntity>(StarWarsCharactersDao)
}

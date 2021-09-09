package com.example.database

import com.example.domain.Character
import com.example.domain.Droid
import com.example.domain.Human
import com.example.repository.StarWarsRepository
import org.jetbrains.exposed.sql.transactions.transaction

class StarWarsRepositoryImpl: StarWarsRepository {
    override fun addDroid(name: String, primaryFunction: String): Droid =
        transaction {
            val entity = StarWarsCharacterEntity.new {
                setDroid(name, primaryFunction)
            }
            entity.getCharacter() as Droid
        }

    override fun addHuman(name: String, homePlanet: String, height: Double): Human =
        transaction {
            val entity = StarWarsCharacterEntity.new {
                setHuman(name, homePlanet, height)
            }
            entity.getCharacter() as Human
        }

    override fun deleteCharacter(character: Character) {
        transaction {
            val entity = StarWarsCharacterEntity.findById(character.id) ?: return@transaction
            entity.delete()
        }
    }

    override fun findCharacter(id: Int): Character? =
        transaction {
            val entity = StarWarsCharacterEntity.findById(id)
            entity?.getCharacter()
        }

    override fun findAllCharacters(): List<Character> =
        transaction {
            StarWarsCharacterEntity.all().map {
                it.getCharacter()
            }
        }
}

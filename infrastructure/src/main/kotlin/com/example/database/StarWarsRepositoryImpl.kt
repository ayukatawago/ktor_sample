package com.example.database

import com.example.domain.Character
import com.example.repository.StarWarsRepository
import org.jetbrains.exposed.sql.transactions.transaction

class StarWarsRepositoryImpl: StarWarsRepository {
    override fun getCurrentId(): Int {
        return transaction {
            StarWarsCharacterEntity.all()
                .map { it.id.value }
                .lastOrNull() ?: 0
        }
    }

    override fun createCharacter(character: Character): Character {
        return transaction {
            val entity = StarWarsCharacterEntity.new {
                setCharacter(character)
            }
            entity.getCharacter()
        }
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
            val character = entity?.getCharacter()
            entity?.delete()
            character
        }

    override fun findAllCharacters(): List<Character> =
        transaction {
            StarWarsCharacterEntity.all().map {
                it.getCharacter()
            }
        }
}

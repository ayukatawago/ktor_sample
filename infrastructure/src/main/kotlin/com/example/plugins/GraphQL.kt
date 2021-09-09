package com.example.plugins

import com.apurebase.kgraphql.GraphQL
import com.example.database.StarWarsCharactersDao
import com.example.domain.Droid
import com.example.domain.Episode
import com.example.domain.Human
import com.example.repository.StarWarsController
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject

@Suppress("unused")
fun Application.configureGraphQL() {
    val controller by inject<StarWarsController>()

    Database.connect("jdbc:h2:mem:ktor_db;DB_CLOSE_DELAY=-1", "org.h2.Driver")
    transaction {
        SchemaUtils.create(StarWarsCharactersDao)
    }

    install(GraphQL) {
        playground = true
        schema {
            query("hero") {
                resolver { episode: Episode ->
                    controller.filterCharactersByEpisode(episode)
                }
            }
            query("heroes") {
                resolver { -> controller.getAllCharacters() }
            }
            mutation("addHuman") {
                resolver { name: String, homePlanet: String, height: Double ->
                    controller.createNewHuman(name, homePlanet, height)
                }
            }
            mutation("addDroid") {
                resolver { name: String, primaryFunction: String ->
                    controller.createNewDroid(name, primaryFunction)
                }
            }
            mutation("delete") {
                resolver { id: Int ->
                    controller.deleteCharacter(id).toString()
                }
            }
            type<Droid>()
            type<Human>()
            enum<Episode>()
        }
    }
}

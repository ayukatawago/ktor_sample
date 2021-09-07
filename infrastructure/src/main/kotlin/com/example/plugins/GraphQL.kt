package com.example.plugins

import com.apurebase.kgraphql.GraphQL
import com.example.domain.Droid
import com.example.domain.Episode
import com.example.domain.Human
import com.example.repository.DummyStarWarsRepositoryImpl
import com.example.repository.StarWarsController
import com.example.repository.StarWarsRepository
import com.example.usercases.StarWarsService
import com.example.usercases.StarWarsServiceImpl
import io.ktor.application.*

@Suppress("unused")
fun Application.configureGraphQL() {
    val repository: StarWarsRepository = DummyStarWarsRepositoryImpl()
    val service: StarWarsService = StarWarsServiceImpl(repository)
    val controller = StarWarsController(service)

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

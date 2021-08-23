package com.example.plugins

import com.apurebase.kgraphql.GraphQL
import com.example.domain.Droid
import com.example.domain.Episode
import com.example.domain.Human
import io.ktor.application.*

@Suppress("unused")
fun Application.configureGraphQL() {
    install(GraphQL) {
        playground = true
        schema {
            val luke = Human("2000", "Luke Skywalker", emptyList(), Episode.values().toSet(), "Tatooine", 1.72)
            val r2d2 = Droid("2001", "R2-D2", emptyList(), Episode.values().toSet(), "Astromech")
            query("hero") {
                resolver { episode: Episode ->
                    when (episode) {
                        Episode.NEWHOPE, Episode.JEDI -> r2d2
                        Episode.EMPIRE -> luke
                    }
                }
            }
            query("heroes") {
                resolver { -> listOf(luke, r2d2) }
            }
            type<Droid>()
            type<Human>()
            enum<Episode>()
        }
    }
}

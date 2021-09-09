package com.example.database

import org.jetbrains.exposed.dao.id.IntIdTable

object StarWarsCharactersDao: IntIdTable() {
    val name = varchar("name", 20)
    val homePlanet = varchar("homePlanet", 20)
    val height = double("height")
    val primaryFunction = varchar("primaryFunction", 20)
}

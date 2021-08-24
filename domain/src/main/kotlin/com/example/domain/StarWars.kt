package com.example.domain

enum class Episode {
    NEWHOPE,
    EMPIRE,
    JEDI
}

interface Character {
    val id: Int
    val name: String?
    val friends: List<Character>
    val appearsIn: Set<Episode>
}

data class Human(
    override val id: Int,
    override val name: String?,
    override val friends: List<Character>,
    override val appearsIn: Set<Episode>,
    val homePlanet: String,
    val height: Double
) : Character

data class Droid(
    override val id: Int,
    override val name: String?,
    override val friends: List<Character>,
    override val appearsIn: Set<Episode>,
    val primaryFunction: String
) : Character

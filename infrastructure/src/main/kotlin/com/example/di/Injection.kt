package com.example.di

import com.example.database.StarWarsRepositoryImpl
import com.example.repository.StarWarsController
import com.example.repository.StarWarsRepository
import com.example.usercases.StarWarsService
import com.example.usercases.StarWarsServiceImpl
import io.ktor.application.*
import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy
import org.koin.ktor.ext.Koin

@Suppress("unused")
fun Application.inject() {
    install(Koin) {
        val sampleModule = module(createdAtStart = true) {
            singleBy<StarWarsRepository, StarWarsRepositoryImpl>()
            singleBy<StarWarsService, StarWarsServiceImpl>()
            single<StarWarsController>()
        }
        modules(sampleModule)
    }
}

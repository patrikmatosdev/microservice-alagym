package com.microservice.alagym.api.repository

import com.microservice.alagym.api.model.Gym
import org.springframework.data.jpa.repository.JpaRepository

interface GymRepository : JpaRepository<Gym, Long> {
    fun findByDocument(document: String): Gym?
}
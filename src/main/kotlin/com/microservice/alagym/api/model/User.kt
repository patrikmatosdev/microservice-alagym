package com.microservice.alagym.api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val type: String,
    val email: String,
    val city: String,
    val country: String,
    val phone: String,
    val document: String,
    val address: String,
)

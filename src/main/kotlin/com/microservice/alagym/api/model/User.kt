package com.microservice.alagym.api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var type: String,
    var email: String,
    var city: String,
    var country: String,
    var phone: String,
    var document: String,
    var address: String,
)

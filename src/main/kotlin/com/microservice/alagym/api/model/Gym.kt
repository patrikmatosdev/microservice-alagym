package com.microservice.alagym.api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "gyms")
data class Gym(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var name: String,
    var address: String,
    var phone: String,
    var openingHour: String,
    var closingHour: String,
    var image: String,
    var manager: String,

    @Column(unique = true)
    var document: String

)

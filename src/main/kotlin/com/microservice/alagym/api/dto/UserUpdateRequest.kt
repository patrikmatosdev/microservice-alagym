package com.microservice.alagym.api.dto

data class UserUpdateRequest(
    val name: String? = null,
    val type: String? = null,
    val email: String? = null,
    val city: String? = null,
    val country: String? = null,
    val phone: String? = null,
    val document: String? = null,
    val address: String? = null,
)

package com.microservice.alagym.api.dto

import com.microservice.alagym.api.model.User

data class UserResponse(
    val id: Long,
    val name: String,
    val type: String,
    val email: String,
    val city: String,
    val country: String,
    val phone: String,
    val document: String,
    val address: String,
) {
    companion object {
        fun fromEntity(user: User) = UserResponse(
            id = user.id!!,
            name = user.name,
            email = user.email,
            phone = user.phone,
            document = user.document,
            city = user.city,
            type = user.type,
            country = user.country,
            address = user.address,
        )
    }
}

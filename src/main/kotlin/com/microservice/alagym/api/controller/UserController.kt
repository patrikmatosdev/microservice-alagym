package com.microservice.alagym.api.controller

import com.microservice.alagym.api.model.User
import com.microservice.alagym.api.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val repo: UserRepository
) {

    @PostMapping
    fun create(@RequestBody user: User): User {
        return repo.save(user)
    }

    @GetMapping
    fun list(): List<User> {
        return repo.findAll()
    }
}

package com.microservice.alagym.api.controller

import com.microservice.alagym.api.model.User
import com.microservice.alagym.api.repository.UserRepository
import org.springframework.http.ResponseEntity
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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User> {
        val user = repo.findById(id)

        return if (user.isPresent) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (repo.existsById(id)) {
            repo.deleteById(id)
            ResponseEntity.noContent().build()   // 204 No Content
        } else {
            ResponseEntity.notFound().build()    // 404 Not Found
        }
    }

}

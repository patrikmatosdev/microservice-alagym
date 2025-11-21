package com.microservice.alagym.api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.microservice.alagym.api.model.User
import com.microservice.alagym.api.repository.UserRepository
import com.microservice.alagym.api.dto.UserUpdateRequest
import com.microservice.alagym.api.dto.UserResponse

@RestController
@RequestMapping("/users")
class UserController(
    private val repo: UserRepository
) {

    @PostMapping("/create")
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

    @GetMapping("/document/{document}")
    fun findByDocument(@PathVariable document: String): ResponseEntity<User> {
        val user = repo.findByDocument(document)

        return if (user != null) {
            ResponseEntity.ok(user)
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

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: UserUpdateRequest
    ): ResponseEntity<UserResponse> {

        val user = repo.findById(id).orElseThrow {
            RuntimeException("Usuário não encontrado")
        }

        request.name?.let { user.name = it }
        request.email?.let { user.email = it }
        request.phone?.let { user.phone = it }
        request.address?.let { user.address = it }
        request.document?.let { user.document = it }
        request.type?.let { user.type = it }
        request.city?.let { user.city = it }
        request.country?.let { user.country = it }

        val updated = repo.save(user)

        return ResponseEntity.ok(UserResponse.fromEntity(updated))
    }

}

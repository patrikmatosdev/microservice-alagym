package com.microservice.alagym.api.controller

import org.springframework.web.bind.annotation.*
import com.microservice.alagym.api.model.Gym
import com.microservice.alagym.api.repository.GymRepository
import org.springframework.http.ResponseEntity


@RestController
@RequestMapping("/gym")
class GymController(
    private val repo: GymRepository
) {
    @GetMapping("/all")
    fun list(): List<Gym> {
        return repo.findAll()
    }

    @PostMapping("/create")
    fun create(@RequestBody gym: Gym): Gym {
        return repo.save(gym)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Gym> {
        val g = repo.findById(id)

        return if (g.isPresent) {
            ResponseEntity.ok(g.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

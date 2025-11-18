package com.microservice.alagym.api.repository

import com.microservice.alagym.api.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
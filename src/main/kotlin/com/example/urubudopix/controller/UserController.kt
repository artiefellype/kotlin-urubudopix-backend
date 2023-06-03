package com.example.urubudopix.controller

import com.example.urubudopix.dto.UserDto
import com.example.urubudopix.services.impl.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController (private val userSevices : UserService) {
    @PostMapping
    fun create(@RequestBody userDto: UserDto) : ResponseEntity<String> {
        val savedUser = this.userSevices.createUser(userDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("User ${savedUser.name} criado com sucesso")
    }

}
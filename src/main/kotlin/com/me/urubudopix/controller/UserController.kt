package com.me.urubudopix.controller

import com.me.urubudopix.controller.model.DTOs.UserModelDTO
import com.me.urubudopix.controller.model.DTOs.convertToUserModelDTO
import com.me.urubudopix.controller.model.UserModel
import com.me.urubudopix.controller.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(val repository: UserRepository) {

    @PostMapping("/create")
    fun createUser(@RequestBody userModel: UserModel){
        repository.save(userModel.convertToDBModel())
    }

    @GetMapping("/all")
    fun getAllUsers(): List<UserModelDTO>{
        return repository.findAll().map { it.convertToUserModelDTO() }
    }
}

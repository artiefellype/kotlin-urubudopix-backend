package com.example.urubudopix.services.impl

import com.example.urubudopix.entity.User
import com.example.urubudopix.repository.UserRepository
import com.example.urubudopix.services.UserService
import org.springframework.stereotype.Service

@Service
class UserService (private val repository: UserRepository): UserService {

    override fun createUser(user: User) :User {
       return this.repository.save(user)
    }
}
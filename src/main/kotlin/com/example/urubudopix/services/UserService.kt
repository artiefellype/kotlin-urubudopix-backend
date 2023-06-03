package com.example.urubudopix.services

import com.example.urubudopix.entity.User

interface UserService {
    fun createUser(user: User) : User
}
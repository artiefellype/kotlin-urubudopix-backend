package com.example.urubudopix.dto

import com.example.urubudopix.entity.User

data class UserDto (
    val id:Long,
    val name: String
){
    fun toEntity(): User = User (
        id = this.id,
        name = this.name
    )
}
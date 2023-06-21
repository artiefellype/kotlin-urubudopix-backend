package com.me.urubudopix.controller.model.DTOs

import com.me.urubudopix.controller.repository.model.UserDBModel
import java.util.Date

class UserModelDTO (
    val name: String,
    val date: Date,
    val id: String
)

fun UserDBModel.convertToUserModelDTO() = UserModelDTO (
    name = this.name,
    date = this.date,
    id = this.id.toString()
)

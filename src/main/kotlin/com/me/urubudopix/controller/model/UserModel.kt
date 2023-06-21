package com.me.urubudopix.controller.model

import com.me.urubudopix.controller.repository.model.UserDBModel

class UserModel (
    val name: String
){
    fun convertToDBModel() = UserDBModel(
        name = this.name
    )
}
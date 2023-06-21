package com.me.urubudopix.controller.repository.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class UserDBModel (
    val name: String
){
    @Id
    @GeneratedValue
    var id: UUID? = null
        private set
    val date: Date = Date()

}
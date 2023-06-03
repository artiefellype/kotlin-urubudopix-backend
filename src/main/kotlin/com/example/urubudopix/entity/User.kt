package com.example.urubudopix.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Usuarios")
data class User (
    @Id val id: Long,
    val name: String? = null,
)
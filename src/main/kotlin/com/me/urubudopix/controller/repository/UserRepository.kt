package com.me.urubudopix.controller.repository

import com.me.urubudopix.controller.repository.model.UserDBModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository: CrudRepository<UserDBModel, UUID>  {
}
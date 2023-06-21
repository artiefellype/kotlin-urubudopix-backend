package com.me.urubudopix.controller.repository

import com.me.urubudopix.controller.repository.model.WalletDBModel
import org.springframework.data.repository.CrudRepository
import java.util.*

interface WalletRepository: CrudRepository<WalletDBModel, UUID> {
}
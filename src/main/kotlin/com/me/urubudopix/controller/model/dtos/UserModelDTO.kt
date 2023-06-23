package com.me.urubudopix.controller.model.dtos

import com.me.urubudopix.controller.repository.model.UserDBModel
import com.me.urubudopix.controller.repository.model.WalletDBModel
import java.util.*

class UserModelDTO(
    val name: String,
    val userWallet: WalletModelDTO,
    val createdAt: Date,
    val id: String
)

fun UserDBModel.convertToUserModelDTO() = UserModelDTO (
    name = this.name,
    userWallet = this.userWallet.convertToWalletModelDTO(),
    createdAt = this.createdAt,
    id = this.id.toString()
)

package com.me.urubudopix.controller.model.dtos

import com.me.urubudopix.controller.repository.model.UserDBModel
import com.me.urubudopix.controller.repository.model.WalletDBModel
import java.util.*

class UserModelDTO(
    val name: String,
    val wallet: WalletModelDTO,
    val date: Date,
    val id: String
)

fun UserDBModel.convertToUserModelDTO() = UserModelDTO (
    name = this.name,
    wallet = this.wallet.convertToWalletModelDTO(),
    date = this.date,
    id = this.id.toString()
)

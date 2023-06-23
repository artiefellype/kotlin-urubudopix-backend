package com.me.urubudopix.controller.model.dtos

import com.me.urubudopix.controller.repository.model.WalletDBModel
import java.util.*

class WalletModelDTO(
    var money: Double ,
    val createdAt: Date? = null,
    val id: String? = null
)

fun WalletDBModel.convertToWalletModelDTO() = WalletModelDTO (
    money = this.money,
    createdAt = this.createdAt,
    id = this.id.toString()
)


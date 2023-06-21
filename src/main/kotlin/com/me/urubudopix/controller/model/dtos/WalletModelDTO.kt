package com.me.urubudopix.controller.model.dtos

import com.me.urubudopix.controller.repository.model.WalletDBModel
import java.util.*

class WalletModelDTO(
    var money: Double = 0.00,
    val date: Date? = null,
    val id: String? = null
)

fun WalletDBModel.convertToWalletModelDTO() = WalletModelDTO (
    money = this.money,
    date = this.date,
    id = this.id.toString()
)
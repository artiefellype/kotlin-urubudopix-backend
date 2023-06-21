package com.me.urubudopix.controller.model

import com.me.urubudopix.controller.repository.model.WalletDBModel

class WalletModel(
    var money: Double = 0.00
) {
    fun convertToDBModel() = WalletDBModel(
        money = this.money
    )

}
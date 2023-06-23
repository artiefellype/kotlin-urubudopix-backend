package com.me.urubudopix.controller.model

import com.me.urubudopix.controller.repository.model.WalletDBModel

class WalletModel(
    var money: Double
) {
    fun convertToDBModel() = WalletDBModel(
        money = this.money
    )

    fun setSavedMoney(value: Double) {
        this.money = value
    }

    fun getSavedMoney(): Double {
        return this.money
    }

}
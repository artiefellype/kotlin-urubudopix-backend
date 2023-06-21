package com.me.urubudopix.controller.model

import com.me.urubudopix.controller.repository.model.UserDBModel

class UserModel (
    val name: String,
    var wallet: WalletModel
){
    fun convertToDBModel() = UserDBModel(
        name = this.name,
        wallet = this.wallet.convertToDBModel()
    )
}
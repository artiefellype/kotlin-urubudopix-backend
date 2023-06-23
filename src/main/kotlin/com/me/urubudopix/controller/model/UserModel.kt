package com.me.urubudopix.controller.model

import com.me.urubudopix.controller.repository.model.UserDBModel

class UserModel (
    val name: String,
    var userWallet: WalletModel
){
    fun convertToDBModel() = UserDBModel(
        name = this.name,
        userWallet = this.userWallet.convertToDBModel()
    )
}
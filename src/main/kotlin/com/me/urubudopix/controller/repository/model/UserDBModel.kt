package com.me.urubudopix.controller.repository.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.me.urubudopix.controller.model.WalletModel
import jakarta.persistence.*
import java.util.*

@Entity
class UserDBModel(
    val name: String,

    @OneToOne
    @JoinColumn(name = "wallet_id")
    @JsonIgnore
    var wallet: WalletDBModel
){
    @Id
    @GeneratedValue
    var id: UUID? = null
        private set
    val date: Date = Date()


}
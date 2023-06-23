package com.me.urubudopix.controller.repository.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.me.urubudopix.controller.model.UserModel
import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
class WalletDBModel (
    var money: Double,
    @OneToOne(mappedBy = "userWallet", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JsonIgnore
    var user: UserDBModel? = null

) {
    @Id
    @GeneratedValue
    var id: UUID? = null
        private set
    val createdAt: Date = Date()




}
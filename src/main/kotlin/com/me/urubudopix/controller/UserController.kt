package com.me.urubudopix.controller

import com.me.urubudopix.controller.model.dtos.UserModelDTO
import com.me.urubudopix.controller.model.dtos.convertToUserModelDTO
import com.me.urubudopix.controller.model.UserModel
import com.me.urubudopix.controller.model.WalletModel
import com.me.urubudopix.controller.repository.UserRepository
import com.me.urubudopix.controller.repository.WalletRepository
import com.me.urubudopix.controller.repository.data.CreateUserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(val repository: UserRepository, val walletRepository: WalletRepository) {

    @PostMapping("/create")
    fun createUser(@RequestBody request: CreateUserRequest){
        val walletN = WalletModel()

        var userModel = UserModel(
            name = request.name,
            wallet = walletN
        )

        val walletSaved = walletN.convertToDBModel()

        val userSaved = userModel.convertToDBModel()

        userSaved.wallet = walletSaved
        walletSaved.user = userSaved

        walletRepository.save(walletSaved)
        repository.save(userSaved)
    }


    @GetMapping("/all")
    fun getAllUsers(): List<UserModelDTO>{
        return repository.findAll().map { it.convertToUserModelDTO() }
    }
}

package com.me.urubudopix.controller.schedules

import com.me.urubudopix.controller.model.dtos.convertToWalletModelDTO
import com.me.urubudopix.controller.repository.UserRepository
import com.me.urubudopix.controller.repository.WalletRepository
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@EnableScheduling
@Component
class UserScheduler(private val userRepository: UserRepository, private val walletRepository: WalletRepository) {

    companion object {
        @JvmStatic
        private val log = LoggerFactory.getLogger(UserScheduler::class.java)
    }

    @Scheduled(fixedRate = 60_000L)
    fun updateWalletValue(){
        log.info("Profiting...")
        val users = userRepository.findAll()
        for (user in users) {
            var userWallets = walletRepository.findAll()
            for (wallet in userWallets) {
                if(user.userWallet.id?.equals(wallet.id) == true) {
                    wallet.money += (wallet.money * 0.33)
                    walletRepository.save(wallet)
                }
            }
            userRepository.save(user)
        }
    }

}
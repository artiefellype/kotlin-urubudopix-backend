package com.me.urubudopix

import com.fasterxml.jackson.databind.ObjectMapper
import com.me.urubudopix.controller.model.UserModel
import com.me.urubudopix.controller.repository.UserRepository
import com.me.urubudopix.controller.repository.model.UserDBModel
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*

@WebMvcTest
class UserControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @Test
    fun `should create a user with sucess`() {
        val creation = UserModel (
            name = "Dona Maria do carro do ovo"
        )

        every { userRepository.save(any()) } returns mockk()

        mockMvc.perform(post("/api/users/create")
            .content(ObjectMapper().writeValueAsString(creation))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk)
    }

    @Test
    fun `should return users with sucess`() {
        val mockUsers = mockk<UserDBModel>().apply {
            every { name } returns "Dona Maria"
            every { date } returns Date()
            every { id } returns UUID.randomUUID()
        }

        every { userRepository.findAll() } returns listOf(mockUsers)

        mockMvc.perform(get("/api/users/all")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].name").value("Dona Maria"))

    }

    @Test
    fun `should return a bad request if the request there´s no body`() {
        mockMvc.perform(post("/api/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().is4xxClientError)
    }
}
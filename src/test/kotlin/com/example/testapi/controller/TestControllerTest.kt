package com.example.testapi.controller

import com.example.testapi.model.AddRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun testPostTestaddWithValidRequest() {
        val request = AddRequest(a = 5, b = 3)
        
        mockMvc.perform(
            post("/api/testadd")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result").value(8))
    }

    @Test
    fun testPostTestaddWithNegativeNumbers() {
        val request = AddRequest(a = -5, b = -3)
        
        mockMvc.perform(
            post("/api/testadd")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result").value(-8))
    }

    @Test
    fun testGetTestaddWithQueryParameters() {
        mockMvc.perform(
            get("/api/testadd")
                .param("a", "10")
                .param("b", "20")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result").value(30))
    }

    @Test
    fun testGetTestaddWithZeroValues() {
        mockMvc.perform(
            get("/api/testadd")
                .param("a", "0")
                .param("b", "0")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result").value(0))
    }

    @Test
    fun testGetTestaddWithLargeNumbers() {
        mockMvc.perform(
            get("/api/testadd")
                .param("a", "1000000")
                .param("b", "2000000")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result").value(3000000))
    }
} 
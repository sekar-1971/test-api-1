package com.example.testapi.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private lateinit var calculatorService: CalculatorService

    @Test
    fun `test add with positive numbers`() {
        val result = calculatorService.add(5, 3)
        assertEquals(8, result)
    }

    @Test
    fun `test add with negative numbers`() {
        val result = calculatorService.add(-5, -3)
        assertEquals(-8, result)
    }

    @Test
    fun `test add with zero`() {
        val result = calculatorService.add(5, 0)
        assertEquals(5, result)
    }

    @Test
    fun `test add with large numbers`() {
        val result = calculatorService.add(1000000, 2000000)
        assertEquals(3000000, result)
    }

    @Test
    fun `test add with mixed positive and negative`() {
        val result = calculatorService.add(10, -5)
        assertEquals(5, result)
    }
} 
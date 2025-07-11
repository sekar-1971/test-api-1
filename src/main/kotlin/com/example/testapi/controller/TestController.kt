package com.example.testapi.controller

import com.example.testapi.model.AddRequest
import com.example.testapi.model.AddResponse
import com.example.testapi.service.CalculatorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TestController(private val calculatorService: CalculatorService) {

    @PostMapping("/testadd")
    fun testAdd(@RequestBody request: AddRequest): AddResponse {
        val result = calculatorService.add(request.a, request.b)
        return AddResponse(result = result)
    }
//33
    @GetMapping("/testadd")
    fun testAddGet(@RequestParam a: Int, @RequestParam b: Int): AddResponse {
        val result = calculatorService.add(a, b)
        return AddResponse(result = result)
    }

    @GetMapping("/health")
    fun healthCheck(): Map<String, Any> {
        return mapOf(
            "status" to "UP",
            "service" to "test-api",
            "timestamp" to System.currentTimeMillis()
        )
    }

    @GetMapping("/health/lb")
    fun loadBalancerHealthCheck(): Map<String, String> {
        return mapOf("status" to "healthy")
    }
} 
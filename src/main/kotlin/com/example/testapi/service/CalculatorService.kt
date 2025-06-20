package com.example.testapi.service

import org.springframework.stereotype.Service

@Service
class CalculatorService {
    
    fun add(a: Int, b: Int): Int {
        return a + b
    }
} 
package com.example.gateway.client.feign

import com.example.gateway.client.DummyjsonProduct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

@ReactiveFeignClient(
    name = "dummyjson-service",
    url = "https://dummyjson.com"
)
interface DummyjsonClient {
    @GetMapping("/products/{id}")
    fun getProduct(@PathVariable id: Long): Mono<DummyjsonProduct>
}

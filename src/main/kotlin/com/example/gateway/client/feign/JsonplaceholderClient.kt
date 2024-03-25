package com.example.gateway.client.feign

import com.example.gateway.client.JsonplaceholderTodo
import org.springframework.web.bind.annotation.GetMapping
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

@ReactiveFeignClient(
    name = "jsonplaceholder-service",
    url = "https://jsonplaceholder.typicode.com",
    primary = false
)
interface JsonplaceholderClient {
    @GetMapping("/todos")
    fun getTodos(): Mono<List<JsonplaceholderTodo>>
}


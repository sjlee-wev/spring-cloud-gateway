package com.example.gateway.client

import com.example.gateway.client.feign.JsonplaceholderClient
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Component
class JsonplcaeholderWebClient : JsonplaceholderClient {

    private lateinit var webClient: WebClient

    init {
        webClient = getWebClient()
    }

    override fun getTodos(): Mono<List<JsonplaceholderTodo>> {
        return webClient.get()
            .uri("/todos")
            .retrieve()
            .bodyToMono(JsonplaceholderTodoList::class.java)
            .flatMap { Mono.just(it.todos) }
    }

    private fun getWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://dummyjson.com")
            .build()
    }
}

package com.example.gateway.content

import com.example.gateway.client.feign.DummyjsonClient
import com.example.gateway.client.feign.JsonplaceholderClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ContentService(
    private val jsonplaceholderClient: JsonplaceholderClient,
    private val dummyjsonClient: DummyjsonClient
) {
    fun getAllContent(): Mono<Content> {
        return Mono.zip(
            jsonplaceholderClient.getTodos(),
            jsonplaceholderClient.getTodos(),
            dummyjsonClient.getProduct(1),
            dummyjsonClient.getProduct(1),
            dummyjsonClient.getProduct(1),
        ).map { tuple ->
            Content(
                tuple.t1,
                tuple.t2,
                tuple.t3,
                tuple.t4,
                tuple.t5,
            )
        }
    }
}

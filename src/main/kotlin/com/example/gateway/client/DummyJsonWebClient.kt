package com.example.gateway.client

import com.example.gateway.client.feign.DummyjsonClient
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit
import java.util.function.Consumer

@Component
class DummyJsonWebClient : DummyjsonClient {

    private lateinit var webClient: WebClient

    init {
        webClient = getWebClient()
    }

    override fun getProduct(id: Long): Mono<DummyjsonProduct> {
        return webClient.get()
            .uri("/products/$id")
            .retrieve()
            .bodyToMono(DummyjsonProduct::class.java)
    }

    private fun getWebClient(): WebClient {
        val httpClient: HttpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .responseTimeout(Duration.ofMillis(5000))
            .doOnConnected { conn ->
                conn.addHandlerLast(ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                    .addHandlerLast(WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))
            }

        return WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .filter { request, next ->
                val modifiedRequest: ClientRequest = ClientRequest.from(request)
                    .header("X-Auth", "Sujin")
                    .build()
                next.exchange(modifiedRequest)
            }
            .filter(
                ExchangeFilterFunction.ofResponseProcessor { clientResponse: ClientResponse ->
                    clientResponse.headers().asHttpHeaders().forEach { name: String?, values: List<String?> ->
                        values.forEach(Consumer<String?> { value: String? ->
                        })
                    }
                    Mono.just(clientResponse)
                }
            )
            .baseUrl("https://dummyjson.com")
            .build()
    }
}

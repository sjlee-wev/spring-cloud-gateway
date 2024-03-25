package com.example.gateway.filter

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component

@Component
class AuthGatewayFilterFactory : AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config>(Config::class.java) {
    private val log = LoggerFactory.getLogger(javaClass)

    data class Config(
        val name: String
    )

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            log.info("Auth filter : " + config.name)

            val request = exchange.request.mutate()
                .header("X-Auth", "Sujin")
                .build()
            chain.filter(
                exchange
                    .mutate()
                    .request(request)
                    .build()
            )
        }
    }
}

package com.example.gateway.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi

@Configuration
class SwaggerConfig {
    @Bean
    fun gateWayApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("API Gateway API")
            .packagesToScan("com.example.gateway")
            .addOpenApiCustomizer{
                it.info = gateWayApiInfo()
            }.build()
    }

    @Bean
    fun collectionApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Collection API")
            .packagesToScan("com.example.gateway")
            .addOpenApiCustomizer{
                it.info = collectionApiInfo()
            }.build()
    }

    private fun gateWayApiInfo() = Info()
        .title("API Gateway API")
        .description("Swagger UI 테스트")
        .version("1.0.0")

    private fun collectionApiInfo() = Info()
        .title("Collection API")
        .description("Collection Swagger UI 테스트")
        .version("1.0.0")
}
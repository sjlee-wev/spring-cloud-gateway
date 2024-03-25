package com.example.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// https://juejin.cn/post/7337513012394541095
//@EnableReactiveFeignClients(basePackages = ["com.example.gateway.client"])
@SpringBootApplication
class GatewayApplication

fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args)
}

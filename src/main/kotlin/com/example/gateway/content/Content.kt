package com.example.gateway.content

import com.example.gateway.client.DummyjsonProduct
import com.example.gateway.client.JsonplaceholderTodo

data class Content(
    val todos: List<JsonplaceholderTodo>,
    val todos2: List<JsonplaceholderTodo>,
    val product: DummyjsonProduct,
    val product2: DummyjsonProduct,
    val product3: DummyjsonProduct
)

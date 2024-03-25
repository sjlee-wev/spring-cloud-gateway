package com.example.gateway.client

data class JsonplaceholderTodoList(
    val todos: List<JsonplaceholderTodo>
)

data class JsonplaceholderTodo(
    val id: Long,
    val todo: String
)

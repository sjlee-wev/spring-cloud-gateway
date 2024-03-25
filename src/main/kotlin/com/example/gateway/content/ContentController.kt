package com.example.gateway.content

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/content")
class ContentController(
    private val contentService: ContentService
) {

    @GetMapping
    fun getContent(): Mono<Content> {
        return contentService.getAllContent()
    }
}

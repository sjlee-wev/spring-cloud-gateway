package com.example.gateway.content

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/content")
@Tag(name = "Content", description = "Content API Document")
class ContentController(
    private val contentService: ContentService
) {

    @GetMapping
    @Operation(summary = "컨텐츠 맵핑", description = "컨텐츠 Client API")
    fun getContent(): Mono<Content> {
        return contentService.getAllContent()
    }
}

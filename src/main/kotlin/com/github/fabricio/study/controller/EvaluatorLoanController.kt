package com.github.fabricio.study.controller

import com.github.fabricio.study.dto.RequestDTO
import com.github.fabricio.study.dto.ResponseDTO
import com.github.fabricio.study.service.ChatService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/evaluator")
class EvaluatorLoanController(private val chatService: ChatService) {

    val logging = KotlinLogging.logger {}

    @PostMapping
    fun evalutor(@RequestBody requestDTO: RequestDTO) : ResponseDTO {
        val response = chatService.execute(requestDTO)

        logging.info { "responde ia $response" }
        return response
    }
}
package com.github.fabricio.study.service

import com.github.fabricio.study.dto.RequestDTO
import com.github.fabricio.study.dto.ResponseDTO
import com.github.fabricio.study.utils.ConstantsSystemPrompt.DATE_BIRTH
import com.github.fabricio.study.utils.ConstantsSystemPrompt.INCOME
import com.github.fabricio.study.utils.ConstantsSystemPrompt.LOAN
import com.github.fabricio.study.utils.ConstantsSystemPrompt.TIME_WORK
import org.springframework.ai.chat.client.ChatClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class ChatService(private val chatClient: ChatClient,
                  @Value("classpath:/promptTemplates/analise.st")
                  private val prompt: Resource) {

    fun execute(requestDTO: RequestDTO): ResponseDTO {
        return chatClient.prompt()
            .system { it.text(prompt)
                .param(DATE_BIRTH, requestDTO.dateBirth)
                .param(INCOME, requestDTO.income)
                .param(TIME_WORK, requestDTO.timeWork)
                .param(LOAN, requestDTO.loan)
            }
                .user(requestDTO.transaction)
            .call()
            .entity(ResponseDTO::class.java) ?: throw RuntimeException("Response not found")

    }
}
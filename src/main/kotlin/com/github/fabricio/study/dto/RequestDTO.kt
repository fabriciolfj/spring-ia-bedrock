package com.github.fabricio.study.dto

import java.math.BigDecimal
import java.time.LocalDate

data class RequestDTO(val transaction: String,
                      val dateBirth: LocalDate,
                      val timeWork: Int,
                      val loan: BigDecimal,
                      val income: BigDecimal)
package br.com.livraria.livraria.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AtualizacaoAutorDto(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    val nome: String
)
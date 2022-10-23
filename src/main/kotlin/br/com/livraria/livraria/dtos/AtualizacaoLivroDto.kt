package br.com.livraria.livraria.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AtualizacaoLivroDto(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    val titulo: String,
    @field:NotEmpty
    val genero: String,
    @field:NotNull
    val anoDePublicacao: Long,
    @field:NotNull
    val idAutor: Long
)
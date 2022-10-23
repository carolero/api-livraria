package br.com.livraria.livraria.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NovoLivroForm(
    @field:NotEmpty(message = "Título é obrigatório.")
    val titulo: String,
    @field:NotEmpty(message = "Gênero é obrigatório.")
    val genero: String,
    @field:NotNull(message = "Ano de publicação é obrigatório.")
    val anoDePublicacao: Long,
    @field:NotNull(message = "Autor é obrigatório.")
    val idAutor: Long
)
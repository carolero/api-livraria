package br.com.livraria.livraria.dtos

import javax.validation.constraints.NotEmpty

data class NovoAutorForm(
    @field:NotEmpty(message = "Nome do autor é obrigatório.")
    val nome: String
)
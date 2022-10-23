package br.com.livraria.livraria.dtos

data class LivroView(
    val id: Long?,
    val titulo: String,
    val genero: String,
    val anoDePublicacao: Long,
    val autor: String
)
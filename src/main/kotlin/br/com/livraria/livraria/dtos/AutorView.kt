package br.com.livraria.livraria.dtos

import br.com.livraria.livraria.models.Livro

data class AutorView(
    val id: Long?,
    val nome: String,
    val livros: List<Livro>
)
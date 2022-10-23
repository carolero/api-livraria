package br.com.livraria.livraria.repositories

import br.com.livraria.livraria.models.Livro
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository : JpaRepository<Livro, Long> {

    fun findByAutorNome(nomeAutor: String, paginacao: Pageable): Page<Livro>

}
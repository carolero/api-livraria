package br.com.livraria.livraria.repositories

import br.com.livraria.livraria.models.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AutorRepository: JpaRepository<Autor, Long> {

    @Query(value = "SELECT ID, NOME FROM AUTOR", nativeQuery = true)
    fun findByAutorNome(): Collection<Autor>

}
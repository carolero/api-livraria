package br.com.livraria.livraria.services

import br.com.livraria.livraria.dtos.AtualizacaoAutorDto
import br.com.livraria.livraria.dtos.AutorNomeView
import br.com.livraria.livraria.dtos.AutorView
import br.com.livraria.livraria.dtos.NovoAutorForm
import br.com.livraria.livraria.exceptions.NotFoundException
import br.com.livraria.livraria.mappers.AutorFormMapper
import br.com.livraria.livraria.mappers.AutorViewMapper
import br.com.livraria.livraria.repositories.AutorRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AutorService(
    private val repository: AutorRepository,
    private val autorViewMapper: AutorViewMapper,
    private val autorFormMapper: AutorFormMapper,
    private val notFoundMessage: String = "Autor não encontrado."
) {

    fun listarAutores(): List<AutorNomeView> {
        return repository.findByAutorNome().stream().map { a -> autorViewMapper.mapNomeAutor(a) }
            .collect(Collectors.toList())
    }

    fun buscarAutorPorId(id: Long): AutorView {
        val autor = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return autorViewMapper.map(autor)
    }

    fun cadastraAutor(autorDto: NovoAutorForm): AutorView {
        val autor = autorFormMapper.map(autorDto)
        repository.save(autor)
        return autorViewMapper.map(autor)
    }

    fun atualizaAutor(autorDto: AtualizacaoAutorDto): AutorView {
        val autor = repository.findById(autorDto.id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        autor.nome = autorDto.nome
        return autorViewMapper.map(autor)
    }

    fun deletarAutor(id: Long) {
        repository.deleteById(id)
    }

}
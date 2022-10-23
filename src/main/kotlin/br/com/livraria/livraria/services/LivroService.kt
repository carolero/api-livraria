package br.com.livraria.livraria.services

import br.com.livraria.livraria.dtos.AtualizacaoLivroDto
import br.com.livraria.livraria.dtos.LivroView
import br.com.livraria.livraria.dtos.NovoLivroForm
import br.com.livraria.livraria.exceptions.NotFoundException
import br.com.livraria.livraria.mappers.LivroFormMapper
import br.com.livraria.livraria.mappers.LivroViewMapper
import br.com.livraria.livraria.repositories.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LivroService(
    private val repository: LivroRepository,
    private val livroViewMapper: LivroViewMapper,
    private val livroFormMapper: LivroFormMapper,
    private val notFoundMessage: String = "Livro não encontrado."
) {

    fun listarLivros(
        nomeAutor: String?,
        paginacao: Pageable
    ): Page<LivroView> {
        val livros = if (nomeAutor == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByAutorNome(nomeAutor, paginacao)
        }
        return livros.map { l -> livroViewMapper.map(l) }
    }

    fun buscarLivroPorId(id: Long): LivroView {
        val livro = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return livroViewMapper.map(livro)
    }

    fun cadastraLivro(livroDto: NovoLivroForm): LivroView {
        val livro = livroFormMapper.map(livroDto)
        repository.save(livro)
        return livroViewMapper.map(livro)
    }

    fun atualizaLivro(livroDto: AtualizacaoLivroDto): LivroView {
        val livro = repository.findById(livroDto.id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        livro.titulo = livroDto.titulo
        livro.genero = livroDto.genero
        livro.anoDePublicacao = livroDto.anoDePublicacao
        return livroViewMapper.map(livro)
    }

    fun deletarLivro(id: Long) {
        repository.deleteById(id)
    }

}
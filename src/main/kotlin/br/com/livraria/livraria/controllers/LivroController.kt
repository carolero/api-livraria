package br.com.livraria.livraria.controllers

import br.com.livraria.livraria.dtos.AtualizacaoLivroDto
import br.com.livraria.livraria.dtos.LivroView
import br.com.livraria.livraria.dtos.NovoLivroForm
import br.com.livraria.livraria.services.LivroService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/livros")
class LivroController(private val service: LivroService) {

    @GetMapping
    fun listarLivros(
        @RequestParam(required = false) nomeAutor: String?,
        paginacao: Pageable
    ): Page<LivroView> {
        return service.listarLivros(nomeAutor, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarLivroPorId(@PathVariable id: Long): LivroView {
        return service.buscarLivroPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrarLivro(
        @RequestBody @Valid livroDto: NovoLivroForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<LivroView> {
        val livroView = service.cadastraLivro(livroDto)
        val uri = uriBuilder.path("/livros/${livroView.id}").build().toUri()
        return ResponseEntity.created(uri).body(livroView)
    }

    @PutMapping
    @Transactional
    fun atualizarLivro(@RequestBody @Valid livroDto: AtualizacaoLivroDto): ResponseEntity<LivroView> {
        val livroView = service.atualizaLivro(livroDto)
        return ResponseEntity.ok(livroView)
    }
    
}
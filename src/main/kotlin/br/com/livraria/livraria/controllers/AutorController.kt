package br.com.livraria.livraria.controllers

import br.com.livraria.livraria.dtos.AtualizacaoAutorDto
import br.com.livraria.livraria.dtos.AutorNomeView
import br.com.livraria.livraria.dtos.AutorView
import br.com.livraria.livraria.dtos.NovoAutorForm
import br.com.livraria.livraria.services.AutorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/autores")
class AutorController(private val service: AutorService) {

    @GetMapping
    fun listarAutores(): List<AutorNomeView> {
        return service.listarAutores()
    }

    @GetMapping("/{id}")
    fun buscarAutorPorId(@PathVariable id: Long): AutorView {
        return service.buscarAutorPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrarLivro(
        @RequestBody @Valid autorDto: NovoAutorForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AutorView> {
        val autorView = service.cadastraAutor(autorDto)
        return ResponseEntity.ok(autorView)
    }

    @PutMapping
    @Transactional
    fun atualizarAutor(@RequestBody @Valid autorDto: AtualizacaoAutorDto): ResponseEntity<AutorView> {
        val autorView = service.atualizaAutor(autorDto)
        return ResponseEntity.ok(autorView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletarAutor(@PathVariable id: Long) {
        service.deletarAutor(id)
    }

}
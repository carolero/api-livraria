package br.com.livraria.livraria.controllers

import br.com.livraria.livraria.dtos.LivroView
import br.com.livraria.livraria.dtos.NovoPedidoForm
import br.com.livraria.livraria.dtos.PedidoView
import br.com.livraria.livraria.services.PedidoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/pedidos")
class PedidoController(
    private val service: PedidoService
) {

    @GetMapping
    fun listarPedidos(): List<PedidoView> {
        return service.listarPedidos()
    }

    @GetMapping("/{id}")
    fun buscarPedidoPorId(@PathVariable id: Long): PedidoView {
        return service.buscarPedidoPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrarLivro(
        @RequestBody @Valid pedidoDto: NovoPedidoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PedidoView> {
        val pedidoView = service.cadastraPedido(pedidoDto)
        val uri = uriBuilder.path("/pedidos/${pedidoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(pedidoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletarPedido(@PathVariable id: Long) {
        service.deletarPedido(id)
    }

}
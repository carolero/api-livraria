package br.com.livraria.livraria.services

import br.com.livraria.livraria.dtos.NovoPedidoForm
import br.com.livraria.livraria.dtos.PedidoView
import br.com.livraria.livraria.exceptions.NotFoundException
import br.com.livraria.livraria.mappers.PedidoFormMapper
import br.com.livraria.livraria.mappers.PedidoViewMapper
import br.com.livraria.livraria.repositories.PedidoRepository
import org.springframework.stereotype.Service

@Service
class PedidoService(
    private val repository: PedidoRepository,
    private val pedidoViewMapper: PedidoViewMapper,
    private val pedidoFormMapper: PedidoFormMapper,
    private val notFoundMessage: String = "Pedido não encontrado."
) {

    fun listarPedidos(): List<PedidoView> {
        val pedidos = repository.findAll()
        return pedidos.map { p -> pedidoViewMapper.map(p) }
    }

    fun buscarPedidoPorId(id: Long): PedidoView {
        val pedido = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return pedidoViewMapper.map(pedido)
    }

    fun cadastraPedido(pedidoDto: NovoPedidoForm): PedidoView {
        val pedido = pedidoFormMapper.map(pedidoDto)
        repository.save(pedido)
        return pedidoViewMapper.map(pedido)
    }

    fun deletarPedido(id: Long) {
        repository.deleteById(id)
    }

}
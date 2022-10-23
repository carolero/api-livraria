package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.PedidoView
import br.com.livraria.livraria.models.Pedido
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class PedidoViewMapper : Mapper<Pedido, PedidoView> {
    override fun map(p: Pedido): PedidoView {
        return PedidoView(
            id = p.id,
            valorTotal = p.valorTotal,
            livrosIds = p.livros.stream().map { l -> l.id }.collect(Collectors.toList())
        )
    }
}
package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.NovoPedidoForm
import br.com.livraria.livraria.models.Pedido
import br.com.livraria.livraria.repositories.LivroRepository
import org.springframework.stereotype.Component

@Component
class PedidoFormMapper(
    private val repository: LivroRepository
) : Mapper<NovoPedidoForm, Pedido> {
    override fun map(p: NovoPedidoForm): Pedido {
        return Pedido(
            valorTotal = p.valorTotal,
            livros = p.livrosIds
                .map { id -> repository.findById(id) }
                .filter { livroOpt -> livroOpt.isPresent }
                .map { livroOpt -> livroOpt.get() }
        )
    }

}
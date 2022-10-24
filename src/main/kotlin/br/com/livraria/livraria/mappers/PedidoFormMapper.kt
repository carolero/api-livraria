package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.NovoPedidoForm
import br.com.livraria.livraria.models.Pedido
import br.com.livraria.livraria.repositories.LivroRepository
import br.com.livraria.livraria.services.LivroService
import org.springframework.stereotype.Component

@Component
class PedidoFormMapper(
    private val livroRepository: LivroRepository,
    private val livroService: LivroService
) : Mapper<NovoPedidoForm, Pedido> {
    override fun map(p: NovoPedidoForm): Pedido {

        return Pedido(
            valor = p.valor,
            livros = p.livrosIds
                .map { id -> livroRepository.findById(id) }
                .filter { livroOpt -> livroOpt.isPresent }
                .map { livroOpt -> livroOpt.get() }
        )


    }

}
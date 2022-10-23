package br.com.livraria.livraria.repositories

import br.com.livraria.livraria.models.Pedido
import org.springframework.data.jpa.repository.JpaRepository

interface PedidoRepository : JpaRepository<Pedido, Long> {
}
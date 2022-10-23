package br.com.livraria.livraria.dtos

data class PedidoView(
    val id: Long?,
    val valorTotal: Double,
    val livrosIds: List<Long?>
)
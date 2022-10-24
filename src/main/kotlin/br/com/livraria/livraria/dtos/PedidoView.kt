package br.com.livraria.livraria.dtos

data class PedidoView(
    val id: Long?,
    val valor: Double,
    val livrosIds: List<Long?>
)
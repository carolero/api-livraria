package br.com.livraria.livraria.dtos

import javax.validation.constraints.NotNull

data class NovoPedidoForm(
    @field:NotNull(message = "Valor é obrigatório.")
    val valorTotal: Double,
    val livrosIds: List<Long>
)
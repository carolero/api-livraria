package br.com.livraria.livraria.dtos

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class NovoPedidoForm(
    val valor: Double,
    val livrosIds: List<Long>
)
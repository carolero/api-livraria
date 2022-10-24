package br.com.livraria.livraria.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Pedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val valor: Double,
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "itempedido",
        joinColumns = [JoinColumn(name = "pedido_id")],
        inverseJoinColumns = [JoinColumn(name = "livro_id")]
    )
    val livros: List<Livro>
)
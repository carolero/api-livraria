package br.com.livraria.livraria.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var genero: String,
    var anoDePublicacao: Long,
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    val autor: Autor,
    @JsonBackReference
    @ManyToMany(mappedBy = "livros")
    val pedidos: List<Pedido>
)
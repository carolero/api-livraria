package br.com.livraria.livraria.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*

@Entity
data class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String,
    @JsonManagedReference
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    val livros: List<Livro> = Arrays.asList()
)
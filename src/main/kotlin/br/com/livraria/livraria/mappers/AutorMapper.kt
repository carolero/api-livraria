package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.AutorView
import br.com.livraria.livraria.models.Autor
import org.springframework.stereotype.Component

@Component
class AutorMapper : Mapper<AutorView, Autor> {

    override fun map(a: AutorView): Autor {
        return Autor(
            id = a.id,
            nome = a.nome,
            livros = a.livros
        )
    }

}
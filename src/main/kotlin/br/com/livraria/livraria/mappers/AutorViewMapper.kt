package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.AutorNomeView
import br.com.livraria.livraria.dtos.AutorView
import br.com.livraria.livraria.models.Autor
import org.springframework.stereotype.Component

@Component
class AutorViewMapper : Mapper<Autor, AutorView> {

    override fun map(a: Autor): AutorView {
        return AutorView(
            id = a.id,
            nome = a.nome,
            livros = a.livros
        )
    }

    fun mapNomeAutor(a: Autor): AutorNomeView {
        return AutorNomeView(
            id = a.id,
            nome = a.nome
        )
    }

}
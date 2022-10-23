package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.LivroView
import br.com.livraria.livraria.models.Livro
import org.springframework.stereotype.Component

@Component
class LivroViewMapper : Mapper<Livro, LivroView> {

    override fun map(l: Livro): LivroView {
        return LivroView(
            id = l.id,
            titulo = l.titulo,
            genero = l.genero,
            anoDePublicacao = l.anoDePublicacao,
            autor = l.autor.nome
        )
    }
}
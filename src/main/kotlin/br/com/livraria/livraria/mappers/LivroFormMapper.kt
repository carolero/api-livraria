package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.NovoLivroForm
import br.com.livraria.livraria.models.Livro
import br.com.livraria.livraria.services.AutorService
import org.springframework.stereotype.Component

@Component
class LivroFormMapper(
    private val autorService: AutorService,
    private val autorMapper: AutorMapper
) : Mapper<NovoLivroForm, Livro> {
    override fun map(l: NovoLivroForm): Livro {
        return Livro(
            titulo = l.titulo,
            genero = l.genero,
            anoDePublicacao = l.anoDePublicacao,
            autor = autorMapper.map(autorService.buscarAutorPorId(l.idAutor)),
            pedidos = arrayListOf()
        )
    }

}
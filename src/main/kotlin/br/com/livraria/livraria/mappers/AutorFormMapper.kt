package br.com.livraria.livraria.mappers

import br.com.livraria.livraria.dtos.NovoAutorForm
import br.com.livraria.livraria.models.Autor
import org.springframework.stereotype.Component

@Component
class AutorFormMapper : Mapper<NovoAutorForm, Autor> {

    override fun map(a: NovoAutorForm): Autor {
        return Autor(
            nome = a.nome
        )
    }

}
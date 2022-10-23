package br.com.livraria.livraria.mappers

interface Mapper<T, U> {

    fun map(t: T): U

}

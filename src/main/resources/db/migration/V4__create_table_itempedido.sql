create table itempedido(
    pedido_id bigint not null,
    livro_id bigint not null,
    foreign key (pedido_id) references pedido(id),
    foreign key (livro_id) references livro(id),
    primary key(pedido_id, livro_id)
);
create table livro(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    genero varchar(50) not null,
    ano_de_publicacao integer not null,
    autor_id integer not null,
    foreign key (autor_id) references autor(id),
    primary key(id)
);
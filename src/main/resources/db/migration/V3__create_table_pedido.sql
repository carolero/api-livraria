create table pedido(
    id bigint not null auto_increment,
    valor_total decimal not null default 0,
    primary key(id)
);
create database comprecoisas;

create table categorias (
                            id bigint primary key,
                            nome varchar(255) not null,
                            categoria_pai bigint,

                            foreign key (categoria_pai) references categorias(id)




);

CREATE TABLE produtos(
                         id bigINT PRIMARY KEY,
                         titulo VARCHAR (255) NOT NULL,
                         descricao TEXT NOT NULL,
                         valor DECIMAL (10,2) not null,
                         desconto float,
                         data_cadastro DATE NOT NULL,
                         categoria bigint not null,

                         foreign key(categoria) references categorias(id)

);

create table imagem(
                       caminho varchar(255) unique not null,
                       id bigint primary key,
                       id_produtos bigint,
                       foreign key(id_produtos) references produtos(id)
);















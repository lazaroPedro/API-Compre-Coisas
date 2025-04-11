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








use comprecoisas;


 create table categorias (
	id_categorias bigint unsigned NOT NULL auto_increment,
  nome varchar(255) not null,
  fk_categoria_pai bigint unsigned,
  PRIMARY KEY (`id_categorias`),
  foreign key (fk_categoria_pai) references categorias(id_categorias)




);

 CREATE TABLE produtos(

  `id_produtos` bigint unsigned NOT NULL  auto_increment,
  `titulo` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `desconto` float NOT NULL DEFAULT '0',
  `data_cadastro` datetime Not NULL,
  `fk_sub_categoria` bigint NOT NULL,
  PRIMARY KEY (`id_produtos`),

FOREIGN KEY (`fk_sub_categoria`) REFERENCES `categorias` (`id_categorias`)
);

create table imagem(
  caminho varchar(255) unique not null,
  id bigint primary key auto_increment,
  id_produtos bigint,
 	foreign key(id_produtos) references produtos(id)
);


 use comprecoisas;
 insert into categorias(id_categorias, nome) values(1, "PCs e Notebooks");
 insert into categorias(id_categorias, nome, fk_categoria_pai) values (6, "Acer", 1);

create table categorias (
	id_categorias bigint unsigned NOT NULL auto_increment,
  nome varchar(255) not null,
  fk_categoria_pai bigint unsigned,
  PRIMARY KEY (`id_categorias`),
  foreign key (fk_categoria_pai) references categorias(id_categorias)




);
CREATE TABLE produtos(

  `id_produtos` bigint unsigned NOT NULL auto_increment,
  `titulo` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `valor` decimal(10,2) unsigned NOT NULL,
  `desconto` float unsigned NOT NULL DEFAULT '0',
  `data_cadastro` datetime Not NULL,
  `fk_sub_categoria` bigint unsigned NOT NULL,
  PRIMARY KEY (`id_produtos`),

FOREIGN KEY (`fk_sub_categoria`) REFERENCES `categorias` (`id_categorias`)
);

CREATE TABLE `imagens` (
  `id_imagens` bigint unsigned NOT NULL auto_increment,
  `caminho` varchar(255) NOT NULL,
  `fk_produtos` bigint unsigned NOT NULL,
  PRIMARY KEY (`id_imagens`),
  UNIQUE KEY `caminho` (`caminho`),
  FOREIGN KEY (`fk_produtos`) REFERENCES `produtos` (`id_produtos`)
)









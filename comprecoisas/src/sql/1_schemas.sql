-- Criar tipos ENUM usados
CREATE TYPE genero AS ENUM ('MASCULINO', 'FEMININO', 'NAO_INFORMAR', 'OUTRO');
CREATE TYPE status_conta AS ENUM ('ATIVA', 'EXCLUIDA', 'SUSPENSA', 'ANALISE');
CREATE TYPE status_produto AS ENUM ('ATIVO', 'EXCLUIDO', 'SEM_ESTOQUE', 'SUSPENSO', 'VENDIDO', 'RESERVADO');
CREATE TYPE status_entrega AS ENUM ('AGUARDANDO_ENVIO', 'EM_TRANSITO', 'ATRASADO', 'ENTREGUE', 'CANCELADA');
CREATE TYPE status_pedido AS ENUM ('FINALIZADO', 'EXCLUIDO', 'SUSPENSO', 'PROCESSAMENTO');
CREATE TYPE tipo_pagamento AS ENUM ('BOLETO', 'PIX', 'CARTAO_DEBITO', 'CARTAO_CREDITO');
CREATE TYPE status_pagamento AS ENUM ('PAGO', 'PROCESSAMENTO', 'FALHO');

-- Tabelas

CREATE TABLE categorias (
                            id_categoria BIGSERIAL PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            fk_categoria_pai BIGINT,
                            FOREIGN KEY (fk_categoria_pai) REFERENCES categorias(id_categoria)
);

CREATE TABLE usuarios (
                          id_usuario BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          hash_senha TEXT NOT NULL,
                          salt_senha TEXT NOT NULL,
                          cpf CHAR(11) UNIQUE NOT NULL,
                          telefone VARCHAR(15) NOT NULL,
                          data_nascimento TIMESTAMP NOT NULL,
                          data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                          genero genero NOT NULL,
                          status_conta status_conta NOT NULL
);

CREATE TABLE enderecos (
                           id_endereco BIGSERIAL PRIMARY KEY,
                           rua VARCHAR(255) NOT NULL,
                           numero VARCHAR(10) NOT NULL,
                           bairro VARCHAR(255) NOT NULL,
                           municipio VARCHAR(255) NOT NULL,
                           estado VARCHAR(255) NOT NULL,
                           cep VARCHAR(8) NOT NULL,
                           fk_usuario BIGINT NOT NULL,
                           FOREIGN KEY (fk_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE produtos (
                          id_produto BIGSERIAL PRIMARY KEY,
                          titulo VARCHAR(255) NOT NULL,
                          descricao TEXT NOT NULL,
                          valor DECIMAL(10,2) NOT NULL,
                          desconto FLOAT NOT NULL DEFAULT 0,
                          data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                          status_produto status_produto NOT NULL,
                          fk_endereco_origem BIGINT NOT NULL,
                          fk_categoria BIGINT NOT NULL,
                          fk_vendedor BIGINT NOT NULL,
                          FOREIGN KEY (fk_endereco_origem) REFERENCES enderecos(id_endereco),
                          FOREIGN KEY (fk_categoria) REFERENCES categorias(id_categoria),
                          FOREIGN KEY (fk_vendedor) REFERENCES usuarios(id_usuario)
);

CREATE TABLE imagens (
                         id_imagem BIGSERIAL PRIMARY KEY,
                         caminho VARCHAR(255) UNIQUE NOT NULL,
                         fk_produto BIGINT NOT NULL,
                         FOREIGN KEY (fk_produto) REFERENCES produtos(id_produto)
);

CREATE TABLE entregas (
                          id_entrega BIGSERIAL PRIMARY KEY,
                          frete DECIMAL(10,2) NOT NULL,
                          status_entrega status_entrega NOT NULL,
                          id_rastreamento VARCHAR(255) NOT NULL,
                          transportadora VARCHAR(255) NOT NULL,
                          fk_endereco_entrega BIGINT NOT NULL,
                          previsao_entrega TIMESTAMP NOT NULL,
                          data_entrega TIMESTAMP,
                          FOREIGN KEY (fk_endereco_entrega) REFERENCES enderecos(id_endereco)
);

CREATE TABLE pagamentos (
                            id_pagamento BIGSERIAL PRIMARY KEY,
                            valor_total DECIMAL(10,2),
                            tipo_pagamento tipo_pagamento NOT NULL,
                            data_pagamento TIMESTAMP default CURRENT_TIMESTAMP,
                            status_pagamento status_pagamento NOT NULL,
                            id_transacao VARCHAR(255) NOT NULL
);

CREATE TABLE pedidos (
                         id_pedido BIGSERIAL PRIMARY KEY,
                         data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                         status_pedido status_pedido NOT NULL,
                         fk_comprador BIGINT NOT NULL,
                         fk_pagamento BIGINT NOT NULL,
                         fk_entrega BIGINT NOT NULL,
                         FOREIGN KEY (fk_comprador) REFERENCES usuarios(id_usuario),
                         FOREIGN KEY (fk_pagamento) REFERENCES pagamentos(id_pagamento),
                         FOREIGN KEY (fk_entrega) REFERENCES entregas(id_entrega)
);

CREATE TABLE itens_pedidos (
                               id_produto BIGINT NOT NULL,
                               id_pedido BIGINT NOT NULL,
                               PRIMARY KEY (id_produto, id_pedido),
                               FOREIGN KEY (id_produto) REFERENCES produtos(id_produto),
                               FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
);

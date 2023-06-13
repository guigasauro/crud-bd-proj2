DROP TABLE IF EXISTS itemVenda;
DROP TABLE IF EXISTS venda;
DROP TABLE IF EXISTS estoque;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS formaPagamento;
DROP TABLE IF EXISTS vendedor;
DROP TABLE IF EXISTS fabricante;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS anime;
DROP TABLE IF EXISTS cidade;
DROP TABLE IF EXISTS timeTorcedor;

CREATE TABLE anime (
idAnime INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE cidade (
idCidade INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE timeTorcedor (
idTimeTorcedor INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE cliente ( 
idCliente INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
telefone INT(20),
idAnime INT,
idCidade INT,
idTimeTorcedor INT,
FOREIGN KEY (idAnime) REFERENCES anime(idAnime),
FOREIGN KEY (idCidade) REFERENCES cidade(idCidade),
FOREIGN KEY (idTimeTorcedor) REFERENCES timeTorcedor(idTimeTorcedor)
);

CREATE TABLE categoria (
idCategoria INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE fabricante (
idFabricante INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
endereco VARCHAR(100)
);

CREATE TABLE vendedor (
idVendedor INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE formaPagamento (
idFormaPagamento INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE produto (
idProduto INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
preco DECIMAL(10,2),
idCategoria INT,
idFabricante INT,
FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria),
FOREIGN KEY (idFabricante) REFERENCES fabricante(idFabricante)
);

CREATE TABLE estoque (
idProduto INT AUTO_INCREMENT PRIMARY KEY,
quantidade INT,
FOREIGN KEY (idProduto) REFERENCES produto(idProduto)
);

CREATE TABLE venda ( -- Venda completa
idVenda INT PRIMARY KEY AUTO_INCREMENT,
idCliente INT,
idVendedor INT,
idFormaPagamento INT,
dataVenda DATE,
FOREIGN KEY (idCliente) REFERENCES cliente(idCliente),
FOREIGN KEY (idVendedor) REFERENCES vendedor(idVendedor),
FOREIGN KEY (idFormaPagamento) REFERENCES formaPagamento(idFormaPagamento)
); 

CREATE TABLE itemVenda ( -- apenas um tipo de item
idItemVenda INT PRIMARY KEY AUTO_INCREMENT,
idVenda INT,
idProduto INT,
quantidade INT,
FOREIGN KEY (idVenda) REFERENCES venda(idVenda),
FOREIGN KEY (idProduto) REFERENCES produto(idProduto)
);


-- INSERTS --

-- Inserts para a tabela anime
INSERT INTO anime (nome) VALUES ('Naruto');
INSERT INTO anime (nome) VALUES ('One Piece');
INSERT INTO anime (nome) VALUES ('Attack on Titan');

-- Inserts para a tabela cidade
INSERT INTO cidade (nome) VALUES ('São Paulo');
INSERT INTO cidade (nome) VALUES ('Rio de Janeiro');
INSERT INTO cidade (nome) VALUES ('Curitiba');

-- Inserts para a tabela timeFutebol
INSERT INTO timeTorcedor (nome) VALUES ('Flamengo');
INSERT INTO timeTorcedor (nome) VALUES ('São Paulo FC');
INSERT INTO timeTorcedor (nome) VALUES ('Palmeiras');

-- Inserts para a tabela cliente
INSERT INTO cliente (nome, telefone, idAnime, idCidade, idTimeTorcedor) VALUES ('João', 123456789, 1, 1, 1);
INSERT INTO cliente (nome, telefone, idAnime, idCidade, idTimeTorcedor) VALUES ('Maria', 987654321, 2, 2, 2);
INSERT INTO cliente (nome, telefone, idAnime, idCidade, idTimeTorcedor) VALUES ('Pedro', 555555555, 3, 3, 3);
INSERT INTO cliente (nome, telefone, idAnime, idCidade, idTimeTorcedor) VALUES ('Ana', 111111111, 1, 2, 3);
INSERT INTO cliente (nome, telefone, idAnime, idCidade, idTimeTorcedor) VALUES ('Lucas', 999999999, 2, 3, 1);

-- Inserts para a tabela categoria
INSERT INTO categoria (nome) VALUES ('Eletrônicos');
INSERT INTO categoria (nome) VALUES ('Roupas');
INSERT INTO categoria (nome) VALUES ('Alimentos');

-- Inserts para a tabela fabricante
INSERT INTO fabricante (nome, endereco) VALUES ('Fabricante A', 'Endereço A');
INSERT INTO fabricante (nome, endereco) VALUES ('Fabricante B', 'Endereço B');
INSERT INTO fabricante (nome, endereco) VALUES ('Fabricante C', 'Endereço C');

-- Inserts para a tabela produto
INSERT INTO produto (nome, preco, idCategoria, idFabricante) VALUES ('Celular', 999.99, 1, 1);
INSERT INTO produto (nome, preco, idCategoria, idFabricante) VALUES ('Camiseta', 29.99, 2, 2);
INSERT INTO produto (nome, preco, idCategoria, idFabricante) VALUES ('Arroz', 4.99, 3, 3);

-- Inserts para a tabela estoque
INSERT INTO estoque (quantidade) VALUES (10);
INSERT INTO estoque (quantidade) VALUES (20);
INSERT INTO estoque (quantidade) VALUES (30);

-- Inserts forma de pagamentos
INSERT INTO formaPagamento (nome) VALUES ('Cartão');
INSERT INTO formaPagamento (nome) VALUES ('Boleto');
INSERT INTO formaPagamento (nome) VALUES ('Pix');
INSERT INTO formaPagamento (nome) VALUES ('Berries');

-- Inserts vendedor
INSERT INTO vendedor (nome) VALUES ('João');
INSERT INTO vendedor (nome) VALUES ('Maria');
INSERT INTO vendedor (nome) VALUES ('Pedro');

-- Inserts para a tabela venda
INSERT INTO venda (idCliente, idVendedor, idFormaPagamento, dataVenda) VALUES (1, 1, 1, '2023-05-20');
-- INSERT INTO venda (idVenda, idCliente, idVendedor, idFormaPagamento, dataVenda) VALUES (2, 2, 2, 2, '2023-05-21');
-- INSERT INTO venda (idVenda, idCliente, idVendedor, idFormaPagamento, dataVenda) VALUES (3, 3, 1, 1, '2023-05-22');

-- Inserts para a tabela itemVenda
INSERT INTO itemVenda (idVenda, idProduto, quantidade) VALUES (1, 1, 5);
INSERT INTO itemVenda (idVenda, idProduto, quantidade) VALUES (1, 2, 3);
INSERT INTO itemVenda (idVenda, idProduto, quantidade) VALUES (1, 3, 2);


-- CRIAÇÃO DE VIEWS

DROP VIEW IF EXISTS produtoView;
DROP VIEW IF EXISTS clienteView;
DROP VIEW vendaView;

CREATE VIEW produtoView AS
SELECT p.idProduto AS idProduto, p.nome, p.preco, c.nome AS nomeCategoria, f.nome AS nomeFabricante, e.quantidade AS quantidade
FROM produto p
JOIN categoria c ON p.idCategoria = c.idCategoria
JOIN fabricante f ON p.idFabricante = f.idFabricante
JOIN estoque e ON p.idProduto = e.idProduto;

CREATE VIEW clienteView AS
SELECT c.idCliente, c.nome, c.telefone, a.nome AS nomeAnime, cid.nome AS nomeCidade, tf.nome AS nomeTimeTorcedor
FROM cliente c
JOIN anime a ON c.idAnime = a.idAnime
JOIN cidade cid ON c.idCidade = cid.idCidade
JOIN timeTorcedor tf ON c.idTimeTorcedor = tf.idTimeTorcedor;

CREATE VIEW vendaView AS
SELECT v.idVenda,
		iv.idItemVenda,
		c.nome AS nomeCliente,
        ve.nome AS nomeVendedor,
        fp.nome AS formaPagamento,
        iv.idProduto,
        p.nome AS nomeProduto,
        iv.quantidade,
        p.preco AS precoProduto,
        v.dataVenda
FROM venda v
JOIN cliente c ON v.idCliente = c.idCliente
JOIN vendedor ve ON v.idVendedor = ve.idVendedor
JOIN formaPagamento fp ON v.idFormaPagamento = fp.idFormaPagamento
JOIN itemVenda iv ON v.idVenda = iv.idVenda
JOIN produto p ON iv.idProduto = p.idProduto;

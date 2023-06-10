DROP TABLE IF EXISTS itemVenda;
DROP TABLE IF EXISTS venda;
DROP TABLE IF EXISTS estoque;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS formaPagamento;
DROP TABLE IF EXISTS vendedor;
DROP TABLE IF EXISTS fabricante;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS cliente;

select * from produto;

CREATE TABLE cliente (
idCliente INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
endereco VARCHAR(100),
telefone INT(20),
isTorcedorFlamengo BOOLEAN,
isFanOnePiece BOOLEAN,
isSouza BOOLEAN
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
idProduto INT,
quantidade INT,
FOREIGN KEY (idProduto) REFERENCES produto(idProduto)
);

CREATE TABLE venda (
idVenda INT PRIMARY KEY,
idCliente INT,
idVendedor INT,
idFormaPagamento INT,
dataVenda DATE,
FOREIGN KEY (idCliente) REFERENCES cliente(idCliente),
FOREIGN KEY (idVendedor) REFERENCES vendedor(idVendedor),
FOREIGN KEY (idFormaPagamento) REFERENCES formaPagamento(idFormaPagamento)
);

CREATE TABLE itemVenda (
idItemVenda INT AUTO_INCREMENT PRIMARY KEY,
idVenda INT,
idProduto INT,
quantidade INT,
FOREIGN KEY (idVenda) REFERENCES venda(idVenda),
FOREIGN KEY (idProduto) REFERENCES produto(idProduto)
);

INSERT INTO categoria (nome) VALUES ('Categoria1');
INSERT INTO categoria (nome) VALUES ('Categoria2');
INSERT INTO categoria (nome) VALUES ('Categoria3');

INSERT INTO fabricante (nome, endereco) VALUES ('Fabricante1', 'Endereco1');
INSERT INTO fabricante (nome, endereco) VALUES ('Fabricante2', 'Endereco2');
INSERT INTO fabricante (nome, endereco) VALUES ('Fabricante3', 'Endereco3');

INSERT INTO produto (nome, preco, idCategoria, idFabricante) VALUES ('Produto1', 10.99, 1, 1);
INSERT INTO produto (nome, preco, idCategoria, idFabricante) VALUES ('Produto2', 20.99, 2, 2);
INSERT INTO produto (nome, preco, idCategoria, idFabricante) VALUES ('Produto3', 30.99, 3, 3);

INSERT INTO estoque (idProduto, quantidade) VALUES (1, 10);
INSERT INTO estoque (idProduto, quantidade) VALUES (2, 5);
INSERT INTO estoque (idProduto, quantidade) VALUES (3, 2);

select * from ProdutoView;

DROP VIEW IF EXISTS ProdutoView;

CREATE VIEW produtoView AS
SELECT p.idProduto AS idProduto, p.nome, p.preco, c.nome AS nomeCategoria, f.nome AS nomeFabricante, e.quantidade AS quantidade
FROM produto p
JOIN categoria c ON p.idCategoria = c.idCategoria
JOIN fabricante f ON p.idFabricante = f.idFabricante
JOIN estoque e ON p.idProduto = e.idProduto;





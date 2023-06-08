package br.com.mercado.dao;

import br.com.mercado.factory.ConnectionFactory;
import br.com.mercado.model.ProdutoView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoViewDAO {
    public static void imprimirProdutos(List<ProdutoView> produtos) {
        for (ProdutoView produto : produtos) {
            System.out.println("ID: " + produto.getIdProduto());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Categoria: " + produto.getNomeCategoria());
            System.out.println("Fabricante: " + produto.getNomeFabricante());
            System.out.println("---------------------------");
        }
    }
    public static List<ProdutoView> getProdutoView() {
        List<ProdutoView> produtoViews = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Estabelecer conexão com o banco de dados
            conn = ConnectionFactory.createConectionToMySQL();

            // Preparar a consulta SQL
            String sql = "SELECT * FROM ProdutoView";
            pstmt = conn.prepareStatement(sql);

            // Executar a consulta
            rs = pstmt.executeQuery();

            // Iterar pelos resultados e criar os objetos ProdutoView
            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String nomeCategoria = rs.getString("nomeCategoria");
                String nomeFabricante = rs.getString("nomeFabricante");

                ProdutoView produtoView = new ProdutoView(idProduto, nome, preco, nomeCategoria, nomeFabricante);
                produtoViews.add(produtoView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Fechar os recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return produtoViews;
    }

    /**
    public static List<ProdutoView> buscarProdutosPorPreco(String url, String username, String password,
                                                       double precoMinimo, double precoMaximo) {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT p.id_produto, p.nome, p.preco, c.nome AS nome_categoria, f.nome AS nome_fabricante " +
                "FROM produto p " +
                "JOIN categoria c ON p.id_categoria = c.id_categoria " +
                "JOIN fabricante f ON p.id_fabricante = f.id_fabricante " +
                "WHERE p.preco BETWEEN ? AND ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, precoMinimo);
            statement.setDouble(2, precoMaximo);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idProduto = resultSet.getInt("id_produto");
                String nomeProduto = resultSet.getString("nome");
                double precoProduto = resultSet.getDouble("preco");
                String nomeCategoria = resultSet.getString("nome_categoria");
                String nomeFabricante = resultSet.getString("nome_fabricante");

                ProdutoView produto = new ProdutoView(idProduto, nomeProduto, precoProduto, nomeCategoria, nomeFabricante);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
     */

}
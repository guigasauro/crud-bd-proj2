package br.com.mercado.dao;

import br.com.mercado.factory.ConnectionFactory;
import br.com.mercado.model.ItemVenda;
import br.com.mercado.model.ProdutoView;
import br.com.mercado.dao.ProdutoViewDAO;

import java.sql.*;
import java.util.List;

public class ItemVendaDAO {
    public static void ImprimirItensVenda(List<ItemVenda> itensVenda, String titulo) {
        System.out.println("---- " + titulo + " ----");
        for (ItemVenda itemVenda : itensVenda) {
            int idproduto = itemVenda.getIdProduto();
            ProdutoView produto = ProdutoViewDAO.getForIdProdutoView(idproduto);
            System.out.println("ID:              " + itemVenda.getId());
            System.out.println("ID Produto:      " + idproduto);
            System.out.println("ID Venda:        " + itemVenda.getIdVenda());
            System.out.println("Quantidade:      " + itemVenda.getQuantidade());
            System.out.println("Valor Unitário:  " + produto.getPreco());
            System.out.println("Valor Total:     " + produto.getPreco() * itemVenda.getQuantidade());
            System.out.println("---------------------------");
        }
    }

    public static List<ItemVenda> getAllItemVenda(){
        List<ItemVenda> itensVenda = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionFactory.createConectionToMySQL();

            String sql = "SELECT * FROM itemvenda";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("idItemVenda");
                int idProduto = rs.getInt("idProduto");
                int idVenda = rs.getInt("idVenda");
                int quantidade = rs.getInt("quantidade");

                ItemVenda itemVenda = new ItemVenda(id, idProduto, idVenda, quantidade);
                itensVenda.add(itemVenda);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return itensVenda;
    }

    public static ItemVenda getForIdItemVenda(int id){
        ItemVenda itemVenda = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionFactory.createConectionToMySQL();

            String sql = "SELECT * FROM itemvenda WHERE idItemVenda = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while(rs.next()){
                int idProduto = rs.getInt("idProduto");
                int idVenda = rs.getInt("idVenda");
                int quantidade = rs.getInt("quantidade");

                itemVenda = new ItemVenda(id, idProduto, idVenda, quantidade);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return itemVenda;
    }

    public static List<ItemVenda> getForVendaItemVenda(int idVenda){
        List<ItemVenda> itensVenda = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionFactory.createConectionToMySQL();

            String sql = "SELECT * FROM itemvenda WHERE idVenda = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idVenda);

            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("idItemVenda");
                int idProduto = rs.getInt("idProduto");
                int quantidade = rs.getInt("quantidade");

                ItemVenda itemVenda = new ItemVenda(id, idProduto, idVenda, quantidade);
                itensVenda.add(itemVenda);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return itensVenda;
    }
}

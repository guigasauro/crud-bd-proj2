package br.com.mercado.model;

public class ProdutoView {
    private int idProduto;
    private String nome;
    private double preco;
    private String nomeCategoria;
    private String nomeFabricante;

    public ProdutoView(int idProduto, String nome, double preco, String nomeCategoria, String nomeFabricante) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.nomeCategoria = nomeCategoria;
        this.nomeFabricante = nomeFabricante;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getNomeFabricante() {
        return nomeFabricante;
    }
}

package br.com.mercado.model;

public class ItemVenda {
    private int id;
    private int idVenda;
    private int idProduto;
    private int quantidade;

    public ItemVenda() {
        // Construtor vazio
    }

    public ItemVenda(int idVenda, int idProduto, int quantidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public ItemVenda(int id, int idVenda, int idProduto, int quantidade) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public ItemVenda(int idProduto, int quantidade){
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

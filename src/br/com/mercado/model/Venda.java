package br.com.mercado.model;

import java.sql.Date;

public class Venda {
    private int id;
    private int idCliente;
    private int idVendedor;
    private int idFormaPagamento;
    private Date data;

    public Venda() {
        // Construtor vazio
    }

    public Venda(int idCliente, int idVendedor, int idFormaPagamento, Date data) {
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.idFormaPagamento = idFormaPagamento;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

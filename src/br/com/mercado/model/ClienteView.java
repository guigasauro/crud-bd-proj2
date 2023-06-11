package br.com.mercado.model;

public class ClienteView {


    private int idCliente;
    private String nome;
    private int telefone;
    private String nomeAnime;
    private String nomeCidade;
    private String nomeTimeTorcedor;

    public ClienteView() {
        // Construtor vazio
    }

    public ClienteView(int idCliente, String nome, String nomeAnime, String nomeCidade, String nomeTimeTorcedor) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.nomeAnime = nomeAnime;
        this.nomeCidade = nomeCidade;
        this.nomeTimeTorcedor = nomeTimeTorcedor;
    }

    public ClienteView(int idCliente, String nome, int telefone, String nomeAnime, String nomeCidade, String nomeTime) {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNomeAnime() {
        return nomeAnime;
    }

    public void setNomeAnime(String nomeAnime) {
        this.nomeAnime = nomeAnime;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeTimeTorcedor() {
        return nomeTimeTorcedor;
    }

    public void setNomeTimeTorcedor(String nomeTimeTorcedor) {
        this.nomeTimeTorcedor = nomeTimeTorcedor;
    }



}


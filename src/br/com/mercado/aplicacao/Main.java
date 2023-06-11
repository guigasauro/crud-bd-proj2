package br.com.mercado.aplicacao;

import br.com.mercado.dao.*;
import br.com.mercado.model.Cliente;
import br.com.mercado.service.MainService;
import br.com.mercado.dao.ClienteDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while(true){
            String titulo = "";
            Scanner scn = new Scanner(System.in);  // Create a Scanner object

            System.out.println("Escolha uma opção de exibição: \n" +
                    "[1] Todos os itens\n" +
                    "[2] Nome do produto\n" +
                    "[3] Valor minimo e maximo\n" +
                    "[4] Categoria\n" +
                    "[5] Fabricante\n" +
                    "[6] Quantidade minima\n" +
                    "[7] Relatório\n" + // Precisa da função de vendas
                    "-=-=-\n" +
                    "[8] Cadastrar cliente\n" + // fazer
                    "[9] Logar na conta\n" + // fazer
                    "[10] Exibir detalhes da conta\n" + // fazer
                    "-=-=-\n" +
                    "[0] Sair do programa\n");

            int opcao = MainService.perguntaNumeroInt("Digite a opção desejada: ");

            if(opcao==0){
                System.out.println("FIM");
                break;
            } else if (opcao==1) {
                titulo = "Todos os itens";
                ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getAllProdutoView(), titulo);
            } else if (opcao==2) {
                titulo = "Escreva o nome do produto que você deseja buscar";
                String nome = MainService.perguntaString(titulo);
                titulo = "Busca pelo nome" + nome.toUpperCase();
                ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getForNameProdutoView(nome),titulo);
            } else if (opcao==3) {
                titulo = "Digite o valor minimo: ";
                double min = MainService.perguntaNumeroDouble(titulo);
                titulo = "Digite o valor maximo: ";
                double max = MainService.perguntaNumeroDouble(titulo);
                titulo = "Busca pelo produto com preço entre " + min + " e " + max;
                ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getForPriceProdutoViewBy(min, max), titulo);
            } else if (opcao==4) {
                titulo = "Escreva o nome da categoria que você deseja buscar";
                String nome = MainService.perguntaString(titulo);
                titulo = "Busca pela categoria " + nome.toUpperCase();
                ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getForCategoryProdutoView(nome), titulo);
            } else if (opcao==5) {
                titulo = "Escreva o nome do fabricante que você deseja buscar";
                String nome = MainService.perguntaString(titulo);
                titulo = "Busca pelo fabricante " + nome.toUpperCase();
                ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getForManufacturerProdutoView(nome), titulo);
            } else if (opcao==6) {
                titulo = "Escreva a quantidade minima de um produto que deseja buscar: ";
                int qtd = MainService.perguntaNumeroInt(titulo);
                titulo = "Busca pela quantidade igual ou acima de " + qtd;
                ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getForAmountProdutoView(qtd), titulo);
            } else if (opcao==7) {
                break;
            } else if (opcao==8) {
                System.out.println("Digite os seu dados para o cadastro");
                String nome = MainService.perguntaString("Nome: ");
                int telefone = MainService.perguntaNumeroInt("Número de telefone: ");
                AnimeDAO.imprimirAnimes(AnimeDAO.getAllAnime());
                int idAnime = MainService.perguntaNumeroInt("Id do anime preferido: ");
                CidadeDAO.imprimirCidade(CidadeDAO.getAllCidade());
                int idCidade = MainService.perguntaNumeroInt("Id da cidade natal: ");
                TimeTorcedorDAO.imprimirTimeTorcedor(TimeTorcedorDAO.getAllTimeTorcedor());
                int idTimeTorcedor = MainService.perguntaNumeroInt("Id do time torcedor: ");

                Cliente cliente = new Cliente(nome,telefone, idAnime, idCidade, idTimeTorcedor);
                int idCliente = ClienteDAO.save(cliente);

                System.out.println("Cadastrado com sucesso!, seu ID: " + idCliente);

                break;
            } else if (opcao==9) {
                int idCliente = 0;
                do {
                    idCliente = MainService.perguntaNumeroInt("Digite o seu id para efetuar o login: ");
                    idCliente = ClienteDAO.getClientId(idCliente);
                } while (idCliente==0);
                System.out.println("Login efetuado com sucesso!, seu ID: " + idCliente);
            } else if (opcao==10) {
                break;
            }
        }
    }
}

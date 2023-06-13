import java.util.List;
import java.util.Scanner;

import br.com.mercado.dao.ItemVendaDAO;
import br.com.mercado.dao.ProdutoViewDAO;
import br.com.mercado.model.ItemVenda;
import br.com.mercado.service.MainService;

public class testeCarrinho {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        List<ItemVenda> carrinho = null;


        System.out.println("Carrinho de compras");
        System.out.println("[1] Adicionar novo produto");
        System.out.println("[2] Remover produto");
        System.out.println("[3] Alterar quantidade");
        System.out.println("[4] Listar produtos");
        System.out.println("[5] Finalizar compra");
        System.out.println("[0] Cancelar compra");

        int opcao = MainService.perguntaNumeroInt("Digite a opção desejada: ");

        if(opcao==0){
            //MenuCliente();
            System.out.println("FIM");
        } else if (opcao==1) {
            ProdutoViewDAO.imprimirProdutos(ProdutoViewDAO.getAllProdutoView(), "Lista de produtos");
            int produto = MainService.perguntaNumeroInt("Digite o código do produto a ser adicionado: ");
            int quantidade = MainService.perguntaNumeroInt("Digite a quantidade: ");
            ItemVenda itemCarrinho = new ItemVenda(produto, quantidade);
            carrinho.add(itemCarrinho);

        } else if (opcao==2) {
            System.out.println("Qual produto deseja remover?");
            for(int i = 0; i < carrinho.size(); i++){
                System.out.println("[" + i + "] " + carrinho.get(i).getIdProduto() + " - " + ProdutoViewDAO.getForIdProdutoView(carrinho.get(i).getIdProduto()).getNome() + " - " + carrinho.get(i).getQuantidade());
            }
            int produto = MainService.perguntaNumeroInt("Digite o código do produto a ser removido: ");
            ItemVenda itemRemove = ItemVendaDAO.getForIdItemVenda(produto);
            carrinho.remove(itemRemove);
        } else if (opcao==3) {
            for(int i = 0; i < carrinho.size(); i++){
                System.out.println("[" + i + "] " + carrinho.get(i).getIdProduto() + " - " + ProdutoViewDAO.getForIdProdutoView(carrinho.get(i).getIdProduto()).getNome() + " - " + carrinho.get(i).getQuantidade());
            }
            
            int produto = MainService.perguntaNumeroInt("Digite o código do produto a ser alterado: ");
            int quantidade = MainService.perguntaNumeroInt("Digite a nova quantidade: ");
            
            for(int i = 0; i < carrinho.size(); i++){
                if(carrinho.get(i).getIdProduto() == produto){
                    carrinho.get(i).setQuantidade(quantidade);
                }
            }

        } else if (opcao==4) {
            System.out.println("Produtos no carrinho:");
            for(int i = 0; i < carrinho.size(); i++){
                System.out.println("[" + i + "] " + carrinho.get(i).getIdProduto() + " - " + ProdutoViewDAO.getForIdProdutoView(carrinho.get(i).getIdProduto()).getNome() + " - " + carrinho.get(i).getQuantidade());
            }
        } else if (opcao==5) {
            //MenuFinalizarCompra();
        }


    }
}

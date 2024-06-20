package List.OperacoesBasicas.CarrinhoCompras;

import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Item> listaItens;

    public CarrinhoCompras() {
        this.listaItens = new ArrayList<>();
    }

    //método adicionar itens
    public void adicionarItem(String nome, double valor, int quantidade) {
        listaItens.add(new Item(nome, valor, quantidade));

        //Scanner
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!listaItens.isEmpty()){
            for (Item n : listaItens) {
                if (n.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(n);
                    System.out.println("Removendo o item '" + n.getNome() + "' do carrinho");
                }
            }
        } else {
            System.out.println("A lista está vazia!");
        }

        listaItens.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        if(!listaItens.isEmpty()) {
            for (int i = 0; i < listaItens.size(); i++) {
                Item item = (Item) listaItens.get(i);
                valorTotal += item.getPreco() * item.getQuantidade();

            }
            return valorTotal;

        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if(!listaItens.isEmpty()) {
            System.out.println(this.listaItens);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

        //adicionando itens ao carrinho
        carrinhoCompras.adicionarItem("Café", 18d, 3);
        carrinhoCompras.adicionarItem("Café", 9.99, 1);
        carrinhoCompras.adicionarItem("Bolacha", 4d, 2);
        carrinhoCompras.adicionarItem("Água", 2.50, 1);
        carrinhoCompras.adicionarItem("Manteiga", 3d, 4);

        //exibindo os itens do carrinho
        carrinhoCompras.exibirItens();

        //removendo itens do carrinho
        carrinhoCompras.removerItem("Café");
        carrinhoCompras.removerItem("Água");

        //exibindo os itens do carrinho
        carrinhoCompras.exibirItens();

        //calculando e exibindo o valor total do carrinho
        System.out.printf("O valor total do carrinho é de: $ %.2f%n" , carrinhoCompras.calcularValorTotal());


    }
}

package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        if (!estoqueProdutosMap.isEmpty()) {
            System.out.println(estoqueProdutosMap);
        } else {
            System.out.println("Não há produtos no estoque!");
        }
    }

    public void removerProdutoPorCodigo(long cod) {
        if (!estoqueProdutosMap.isEmpty()) {
            if (estoqueProdutosMap.containsKey(cod)) {
                System.out.println("Removendo o produto com código: " + cod + "\n");
                estoqueProdutosMap.remove(cod);
            } else {
                System.out.println("Produto não encontrado!");
            }
        } else {
            System.out.println("Não há produtos no estoque!");
        }
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getPreco() * p.getQuantidade();
            }
        } else {
            throw new RuntimeException("Não há produtos no estoque!");
        }

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        } else {
            throw new RuntimeException("Não há produtos no estoque!");
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() < menorPreco) {
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        } else {
            throw new RuntimeException("Não há produtos no estoque!");
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValor = null;
        double maiorValorTotalProdutoEstoque = 0d;

        if (!estoqueProdutosMap.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
                double valorProdutoEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();

                if (valorProdutoEstoque > maiorValorTotalProdutoEstoque) {
                    maiorValorTotalProdutoEstoque = valorProdutoEstoque;
                    produtoMaiorQuantidadeValor = entry.getValue();
                }
            }
        } else {
            throw new RuntimeException("Não há produtos no estoque!");
        }

        return produtoMaiorQuantidadeValor;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        //exibindo produtos - vazio
        estoqueProdutos.exibirProdutos();

        //adicionando produtos
        estoqueProdutos.adicionarProduto(151L, "Monitor", 3, 250.50);
        estoqueProdutos.adicionarProduto(15L, "Teclado", 4, 89.99);
        estoqueProdutos.adicionarProduto(78L, "Livro", 6, 10d);
        estoqueProdutos.adicionarProduto(113L, "PC", 1, 1800.01);
        estoqueProdutos.adicionarProduto(111L, "Mouse", 3, 65.85);
        estoqueProdutos.adicionarProduto(12L, "Notebook", 2, 1200d);
        estoqueProdutos.adicionarProduto(10L, "Caneta", 12, 5.70d);

        estoqueProdutos.exibirProdutos();

        //valor total do estoque
        System.out.println("O valor total do estoque é de R$ " + estoqueProdutos.calcularValorTotalEstoque());

        //produto mais caro
        System.out.println("O produto mais caro do estoque: " + estoqueProdutos.obterProdutoMaisCaro());

        //produto mais barato
        System.out.println("O produto mais barato do estoque: " + estoqueProdutos.obterProdutoMaisBarato());

        //removendo produto por codigo
        estoqueProdutos.removerProdutoPorCodigo(10L);

        //produto mais barato atualizado
        System.out.println("O produto mais barato do estoque: " + estoqueProdutos.obterProdutoMaisBarato());


        //produto com maior quantidade em valor do estoque
        System.out.println("O produto de maior quantidade em valor do estoque: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());


    }
}

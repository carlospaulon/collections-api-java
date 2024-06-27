package Set.Ordenacao;

import java.util.*;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(String nome, long cod, double preco, int quantidade) {
        produtoSet.add(new Produto(nome, cod, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        if (!produtoSet.isEmpty()) {
            return produtosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtoPorPreco = new TreeSet<>(new Produto.ComparatorPorPreco());
        if (!produtoSet.isEmpty()) {
            produtoPorPreco.addAll(produtoSet);
            return produtoPorPreco;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibiProdutosPorQuantidade() {
        Set<Produto> produtoPorQuantidade = new TreeSet<>(new Produto.ComparatorPorQuantidade());
        if (!produtoSet.isEmpty()) {
            produtoPorQuantidade.addAll(produtoSet);
            return produtoPorQuantidade;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibirProdutosPorCodigo() {
        Set<Produto> produtoPorCodigo = new TreeSet<>(new Produto.ComparatorPorCodigo());
        if (!produtoSet.isEmpty()) {
            produtoPorCodigo.addAll(produtoSet);
            return produtoPorCodigo;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.exibirProdutosPorNome();
        cadastroProdutos.adicionarProduto("Leite", 21L, 3.99d, 3);
        cadastroProdutos.adicionarProduto("Bolacha", 193L, 2.87d, 6);
        cadastroProdutos.adicionarProduto("Arroz", 55L, 8d, 1);
        cadastroProdutos.adicionarProduto("Feijão", 44L, 5.5d, 2);
        cadastroProdutos.adicionarProduto("Agua", 25L, 1.99d, 12);

        System.out.println("Ordenando os produtos por nome: " + cadastroProdutos.exibirProdutosPorNome());
        System.out.println("Ordenando os produtos por preço: " + cadastroProdutos.exibirProdutosPorPreco());
        System.out.println("Ordenando os produtos por quantidade: " + cadastroProdutos.exibiProdutosPorQuantidade());
        System.out.println("Ordenando os produtos por código: " + cadastroProdutos.exibirProdutosPorCodigo());
    }
}

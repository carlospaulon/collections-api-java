package Map.Ordenacao;

import Map.Ordenacao.Livro.ComparatorPorPreco;

import java.util.*;
import java.util.Map.Entry;

public class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livrosMap.put(link, livro);
    }

    public void removerLivro(String titulo) {
        List<String> chavesParaRemover = new ArrayList<>();

        if (!livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    chavesParaRemover.add(entry.getKey());
                }
            }
        } else {
            System.out.println("Não há nenhum livro para remoção!");
        }

        if (!chavesParaRemover.isEmpty()) {
            for (String chave : chavesParaRemover) {
                System.out.println("Removendo o livro '" + titulo + "' da livraria!");
                livrosMap.remove(chave);
            }
        } else {
            System.out.println("Livro não encontradado!");
        }

    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(livrosMap.entrySet());

        if (!livrosParaOrdenar.isEmpty()) {
            Collections.sort(livrosParaOrdenar, new ComparatorPorPreco());

            Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

            for (Map.Entry<String, Livro> entry : livrosParaOrdenar) {
                livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
            }

            return livrosOrdenadosPorPreco;
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(livrosMap.entrySet());

        if (!livrosParaOrdenar.isEmpty()) {
            Collections.sort(livrosParaOrdenar, new Livro.ComparatorPorAutor());

            Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

            for (Map.Entry<String, Livro> entry : livrosParaOrdenar) {
                livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
            }

            return livrosOrdenadosPorAutor;
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorTitulo() {
        List<Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(livrosMap.entrySet());

        if (!livrosParaOrdenar.isEmpty()) {
            Collections.sort(livrosParaOrdenar, new Livro.ComparatorPorTitulo());

            Map<String, Livro> livrosOrdenadosPorTitulo = new LinkedHashMap<>();

            for (Map.Entry<String, Livro> entry : livrosParaOrdenar) {
                String chaveLivro = entry.getKey();
                Livro livro = entry.getValue();
                livrosOrdenadosPorTitulo.put(chaveLivro, livro);
            }
            return livrosOrdenadosPorTitulo;
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

        if (!livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
                Livro livro = entry.getValue();
                String chaveLivro = entry.getKey();
                if (livro.getAutor().equals(autor)) {
                    livrosPorAutor.put(chaveLivro, livro);
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        return livrosPorAutor;
    }

    public List<Livro> obterLivrosMaisCaros() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

        if (!livrosMap.isEmpty()) {
            for (Livro livro : livrosMap.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livrosMap.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto);
            }
        }

        return livrosMaisCaros;
    }

    public List<Livro> obterLivrosMaisBaratos() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;

        if (!livrosMap.isEmpty()) {
            for (Livro livro : livrosMap.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComMenorPreco = livrosMap.get(entry.getKey());
                livrosMaisBaratos.add(livroComMenorPreco);
            }
        }

        return livrosMaisBaratos;
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        LivrariaOnline livrariaOnline = new LivrariaOnline();

        //adicionando livros
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5.00));
        livrariaOnline.adicionarLivro("https://a.co/d/01KxbYvQ", new Livro("A garota do lago", "Charlie Donlea", 30.50));

        //ordenando livros por preco
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //ordenando livros por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        //ordenando livros por titulo
        System.out.println("Livros ordenados por titulo: \n" + livrariaOnline.exibirLivrosOrdenadosPorTitulo());

        //pesquisa de livros por autor
        String autorPesquisa = "Agatha Christie";
        System.out.println("\nExibindo livro(s) de " + autorPesquisa + livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));
        System.out.println("Exibindo livro(s) de Charlie Donlea: " + livrariaOnline.pesquisarLivrosPorAutor("Charlie Donlea"));

        //livros mais caros
        System.out.println("\nLivro(s) mais caro(s): " + livrariaOnline.obterLivrosMaisCaros());

        //livros mais baratos
        System.out.println("Livro(s) mais barato(s): " + livrariaOnline.obterLivrosMaisBaratos());
        System.out.println();

        //removendo livro
        livrariaOnline.removerLivro("1984");
        livrariaOnline.removerLivro("E não sobrou nenhum");
        livrariaOnline.removerLivro("1985");

        //exibindo todos os livros
        if (!livrariaOnline.livrosMap.isEmpty()) {
            System.out.println("Exibindo todos os livros da livraria: " + livrariaOnline.livrosMap);
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
    }
}



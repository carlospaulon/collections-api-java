package List.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    List<Livro> listaLivro;

    public CatalogoLivros() {
        this.listaLivro = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        listaLivro.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!listaLivro.isEmpty()) {
            for(Livro l : listaLivro) {
                if (l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
            return livrosPorAutor;
        } else {
            throw new RuntimeException("A lista está vaiza");
        }
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosIntervalo = new ArrayList<>();
        if (!listaLivro.isEmpty()) {
            for(Livro l : listaLivro) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosIntervalo.add(l);
                }
            }
            return livrosIntervalo;
        } else {
            throw new RuntimeException("A lista está vaiza");
        }
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livro = null;
        if (!listaLivro.isEmpty()) {
            for (Livro l : listaLivro) {
                if (l.getTitle().equalsIgnoreCase(titulo)) {
                    livro = l;
                    break;
                }
            }
            return livro;
        } else {
            throw new RuntimeException("A lista está vaiza");
        }
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        //adicionando livros
        catalogoLivros.adicionarLivro("A guerra dos tronos vol.1", "George R.R. Martin", 1996);
        catalogoLivros.adicionarLivro("A guerra dos tronos vol.2", "George R.R. Martin", 2012);
        catalogoLivros.adicionarLivro("Entendendo Algoritmos", "Aditya Y. Bhargava",  2017);
        catalogoLivros.adicionarLivro("O plano perfeito", "Sidney Sheldon", 1997);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("Em Chamas", "Colins", 2012);
        catalogoLivros.adicionarLivro("Em Chamas", "Colins", 2009);

        //Pesquisa por autor
        System.out.println(catalogoLivros.pesquisarPorAutor("George R.R. Martin"));
        System.out.println(catalogoLivros.pesquisarPorAutor("Sidney Sheldon"));
        //autor inexistente no catalogo - lista vazia
        System.out.println(catalogoLivros.pesquisarPorAutor("Agatha Christie"));

        //Pesquisa por intervalo de anos
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(1997, 2009));
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(1996, 1997));
        //intervalo inexistente - lista vazia
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(2020, 2024));

        //Pesquisa por titulo
        System.out.println(catalogoLivros.pesquisarPorTitulo("Entendendo Algoritmos"));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Em Chamas"));
        //titulo inexistente - null
        System.out.println(catalogoLivros.pesquisarPorTitulo("Java XML"));

    }
}

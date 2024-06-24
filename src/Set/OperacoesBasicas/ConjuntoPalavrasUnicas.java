package Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!palavrasUnicas.isEmpty()) {
            if (palavrasUnicas.contains(palavra)) {
                palavrasUnicas.remove(palavra);
            } else {
                System.out.println("Palavra não encontrada no conjunto!");
            }
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasUnicas.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavrasUnicas.isEmpty()) {
            System.out.println(palavrasUnicas);
        } else {
            System.out.println("O conjunto está vazio");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        //adicionando itens escolares ao conjunto
        conjuntoPalavrasUnicas.adicionarPalavra("Caneta");
        conjuntoPalavrasUnicas.adicionarPalavra("Post-it");
        conjuntoPalavrasUnicas.adicionarPalavra("Caderno");
        conjuntoPalavrasUnicas.adicionarPalavra("Lápis");

        //Exibindo os itens únicos no conjunto
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        //verificando se um determinado item está no conjunto
        System.out.println("Uma 'caneta' está no conjunto? " + conjuntoPalavrasUnicas.verificarPalavra("Caneta"));
        System.out.println("Um 'estojo' está no conjunto? " +conjuntoPalavrasUnicas.verificarPalavra("Estojo") + "\n");

        //removendo um item do conjunto
        conjuntoPalavrasUnicas.removerPalavra("Caneta");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
        System.out.println("Uma 'caneta' está no conjunto? " +conjuntoPalavrasUnicas.verificarPalavra("Caneta"));

        //removendo um item inexistente
        conjuntoPalavrasUnicas.removerPalavra("Livro");

        //Exibindo os itens únicos no conjunto
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}

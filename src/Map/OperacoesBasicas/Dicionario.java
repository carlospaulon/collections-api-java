package Map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public void exibirPalavras() {
        if (!dicionarioMap.isEmpty()) {
            System.out.println(dicionarioMap);
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = dicionarioMap.get(palavra);
        if (definicao != null) {
            return definicao;
        }
        return "Palavra não encontrada!";
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        //exibo as palavras - vazio
        dicionario.exibirPalavras();

        //adiciono palavras ao dicionário
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");
        dicionario.adicionarPalavra("python", "Linguagem de programação muito utilizada com machine learning.");
        dicionario.exibirPalavras();

        //removo palavras do dicionário
        dicionario.removerPalavra("python");
        dicionario.removerPalavra("js");
        dicionario.exibirPalavras();
        System.out.println();

        //pesquiso por nome
        System.out.println(dicionario.pesquisarPorPalavra("java"));
        String definicaoKotlin = dicionario.pesquisarPorPalavra("kotlin");
        System.out.println("A definição da linguagem 'kotlin': " + definicaoKotlin);

        System.out.println(dicionario.pesquisarPorPalavra("js"));
    }
}

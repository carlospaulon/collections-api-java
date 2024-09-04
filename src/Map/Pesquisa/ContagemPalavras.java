package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!contagemMap.isEmpty()) {
            if (contagemMap.containsKey(palavra)) {
                System.out.println("Removendo a palavra '" + palavra + "' do Map");
                contagemMap.remove(palavra);
            } else {
                System.out.println("A palavra '" + palavra + "' não foi encontrada no Map!");
            }
        } else {
            throw new RuntimeException("O Map está vazio!");
        }
    }

    public void exibirContagemPalavras() {
        if (!contagemMap.isEmpty()) {
            System.out.println(contagemMap);
        } else {
            throw new RuntimeException("O Map está vazio!");
        }
    }

    public int exibirQuantidadePalavras() {
        int contagemTotal = 0;

        if (!contagemMap.isEmpty()) {
            for (int contagem : contagemMap.values()) {
                contagemTotal += contagem;
            }
        } else {
            System.out.println("O Map está vazio!");
        }
        return contagemTotal;
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int countPalavra = 0;

        if (!contagemMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
                if (entry.getValue() > countPalavra) {
                    countPalavra = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
        } else {
            throw new RuntimeException("O Map está vazio!");
        }

        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        //map vazio
        System.out.println("Há " + contagemPalavras.exibirQuantidadePalavras() + " palavras no Map");

        //adicionando palavras
        contagemPalavras.adicionarPalavra("Java", 3);
        contagemPalavras.adicionarPalavra("Python", 5);
        contagemPalavras.adicionarPalavra("JS", 1);
        contagemPalavras.adicionarPalavra("Swift", 1);
        contagemPalavras.adicionarPalavra("C#", 2);

        //quantas palavras há no map
        System.out.println("Há " + contagemPalavras.exibirQuantidadePalavras() + " palavras no Map\n");

        //removendo palavras do map
        contagemPalavras.removerPalavra("C#");
        contagemPalavras.removerPalavra("Swift");
        contagemPalavras.removerPalavra("Kotlin");

        System.out.println("\nHá " + contagemPalavras.exibirQuantidadePalavras() + " palavras no Map");

        //palavra mais frequente
        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());

        //palavras e quantidades que estão no map
        contagemPalavras.exibirContagemPalavras();
    }
}

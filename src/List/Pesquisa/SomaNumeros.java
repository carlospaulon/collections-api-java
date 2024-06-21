package List.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.listaNumeros.add(numero);
    }

    public int calcularSoma() {
        int resultado = 0;
        if (!listaNumeros.isEmpty()) {
            for (int n : listaNumeros) {
                resultado += n;
            }
            return resultado;
        } else {
            throw new RuntimeException("A lista de números está vazia!");
        }
    }

    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;
        if (!listaNumeros.isEmpty()) {
            for (int numero : listaNumeros) {
                if (numero >= maior) {
                    maior = numero;
                }
            }
            return maior;
        } else {
            throw new RuntimeException("A lista de números está vazia!");
        }
    }

    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;
        if (!listaNumeros.isEmpty()) {
            for (int numero : listaNumeros) {
                if (numero <= menor) {
                    menor = numero;
                }
            }
            return menor;
        } else {
            throw new RuntimeException("A lista de números está vazia!");
        }
    }

    public void exibirNumeros() {
        if (!listaNumeros.isEmpty()) {
            System.out.println("Números da lista = " + this.listaNumeros);
        } else {
            throw new RuntimeException("A lista de números está vazia!");
        }
    }


    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(-7);
        somaNumeros.adicionarNumero(-5);
        somaNumeros.adicionarNumero(29);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(-3);
        somaNumeros.adicionarNumero(64);
        somaNumeros.adicionarNumero(-50);

        somaNumeros.exibirNumeros();
        System.out.println("Maior número da lista = " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número da lista = " + somaNumeros.encontrarMenorNumero());
        System.out.println("Soma dos valores da lista = " + somaNumeros.calcularSoma());

    }
}

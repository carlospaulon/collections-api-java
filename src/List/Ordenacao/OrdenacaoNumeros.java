package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> listNumber;

    public OrdenacaoNumeros() {
        this.listNumber = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.listNumber.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> listaAscendente = new ArrayList<>(this.listNumber);
        if (!listaAscendente.isEmpty()) {
            Collections.sort(listaAscendente);
            return listaAscendente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> listaDescendente = new ArrayList<>(this.listNumber);
        if (!listaDescendente.isEmpty()) {
            listaDescendente.sort(Collections.reverseOrder());
            return listaDescendente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros() {
        if (!listNumber.isEmpty()) {
            System.out.println(this.listNumber);
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(55);
        ordenacaoNumeros.adicionarNumero(8);
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(-2);
        ordenacaoNumeros.adicionarNumero(99);
        ordenacaoNumeros.adicionarNumero(154);
        ordenacaoNumeros.adicionarNumero(0);
        
        //lista sem ordenação - ordem de adição
        ordenacaoNumeros.exibirNumeros();

        //ordenando e exibindo em ordem ascendente
        System.out.println(ordenacaoNumeros.ordenarAscendente());

        //ordenando e exibindo em ordem descendente
        System.out.println(ordenacaoNumeros.ordenarDescendente());

    }
}

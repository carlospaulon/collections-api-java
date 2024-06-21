package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoas);
        if (!listaPessoas.isEmpty()) {
            Collections.sort(pessoasPorIdade);
            return pessoasPorIdade;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaPessoas);
        if (!listaPessoas.isEmpty()) {
            Collections.sort(pessoasPorAltura, new Pessoa.ComparatorPorAltura());
            return pessoasPorAltura;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("João", 21, 1.78);
        ordenacaoPessoas.adicionarPessoa("Paula", 36, 1.80);
        ordenacaoPessoas.adicionarPessoa("Roberto", 45, 1.95);
        ordenacaoPessoas.adicionarPessoa("Linus", 35, 1.56);
        ordenacaoPessoas.adicionarPessoa("Maria", 65, 1.48);

        //lista não ordenada - Ordem de adição
        System.out.println(ordenacaoPessoas.listaPessoas);
        System.out.println();

        //ordenando por altura e idade
        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }
}

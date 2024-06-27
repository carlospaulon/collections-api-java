package Set.Ordenacao;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        if (!alunoSet.isEmpty()) {
            for (Aluno a : alunoSet) {
                if (a.getMatricula() == matricula) {
                    alunoSet.remove(a);
                    break;
                }
            }
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if (!alunoSet.isEmpty()) {
            return alunosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new Aluno.ComparatorPorNota());
        if (!alunoSet.isEmpty()) {
            alunosPorNota.addAll(alunoSet);
            return alunosPorNota;
        } else  {
            throw new RuntimeException("O conjunto está vazio!");
        }
     }

     public void exibirAlunos() {
        if (!alunoSet.isEmpty()) {
         System.out.println(alunoSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
     }


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        //mostrar alunos
        gerenciadorAlunos.exibirAlunos();

        //adicionando alunos
        gerenciadorAlunos.adicionarAluno("Bruna", 2546L, 6.77d);
        gerenciadorAlunos.adicionarAluno("Maria", 2585L, 10d);
        gerenciadorAlunos.adicionarAluno("Maria R.", 2586L, 8.54d);
        gerenciadorAlunos.adicionarAluno("Mateus", 1142L, 3.25d);
        gerenciadorAlunos.adicionarAluno("Caio", 135L, 3.50d);
        gerenciadorAlunos.adicionarAluno("Angela", 1546L, 3.50d);
        //A aluna 'Angélica' não será adicionada ao conjunto
        gerenciadorAlunos.adicionarAluno("Angélica", 135L, 3.50d);

        gerenciadorAlunos.exibirAlunos();
        //ordenando por nome
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        //ordenando por nota
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
        System.out.println();

        //removendo aluno
        gerenciadorAlunos.removerAluno(1546L);
        gerenciadorAlunos.removerAluno(135L);
        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());




    }
}

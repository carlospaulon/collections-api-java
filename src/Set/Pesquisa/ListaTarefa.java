package Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefa {
    private Set<Tarefa> tarefaSet;

    public ListaTarefa() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio!");
        }

        if (tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefa() {
        if (!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public int contarTarefa() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (!t.isConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public void marcarTarefaConcluida(String descricao) {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                }
            }
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        Tarefa tarefaPendente = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaPendente = t;
                    break;
                }
            }

            if (tarefaPendente != null) {
                if (tarefaPendente.isConcluida()) {
                    tarefaPendente.setConcluida(false);
                }
            } else {
                System.out.println("Tarefa não encontrada na lista!");
            }
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public void limparListaTarefa() {
        if (tarefaSet.isEmpty()) {
            System.out.println("A lista já está vazia!");
        } else {
            tarefaSet.removeAll(tarefaSet);
        }
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        //exibindo tarefas - 0
        listaTarefa.exibirTarefa();

        //adicionando tarefas
        listaTarefa.adicionarTarefa("Estudar Java");
        listaTarefa.adicionarTarefa("Estudar Python");
        listaTarefa.adicionarTarefa("Ler livro");
        listaTarefa.adicionarTarefa("Comer");
        listaTarefa.adicionarTarefa("Malhar");
        listaTarefa.adicionarTarefa("Treino JJ");

        listaTarefa.exibirTarefa();
        //quantidade de tarefas
        System.out.println("Total de tarefas na lista: " + listaTarefa.contarTarefa() + "\n");

        //removendo tarefas
        listaTarefa.removerTarefa("Comer");
        listaTarefa.removerTarefa("Ler Livro");
        listaTarefa.exibirTarefa();
        System.out.println("Total de tarefas na lista: " + listaTarefa.contarTarefa() + "\n");

        //marcando tarefas como concluidas
        listaTarefa.marcarTarefaConcluida("Malhar");
        listaTarefa.marcarTarefaConcluida("Treino JJ");
        listaTarefa.marcarTarefaConcluida("Estudar Java");
        listaTarefa.exibirTarefa();

        //marcando tarefas como pendentes
        listaTarefa.marcarTarefaPendente("Malhar");
        listaTarefa.marcarTarefaPendente("Treino JJ");
        listaTarefa.marcarTarefaPendente("Treino MT");
        System.out.println();

        //mostrando tarefas concluidas
        System.out.println(listaTarefa.obterTarefasConcluidas());

        //mostrando tarefas pendentes
        System.out.println(listaTarefa.obterTarefasPendentes());
        System.out.println();

        //limpando a lista
        listaTarefa.limparListaTarefa();
        listaTarefa.exibirTarefa();
    }
}

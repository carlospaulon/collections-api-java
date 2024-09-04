package Map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public void exibirContatos() {
        if (!agendaContatoMap.isEmpty()) {
            System.out.println(agendaContatoMap);
        } else {
            System.out.println("A agenda de contatos está vazia!");
        }
    }

    public Integer pesquisarPorNome(String nome) {
        Integer contatoPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            contatoPorNome = agendaContatoMap.get(nome);
            if (contatoPorNome == null) {
                System.out.println("Contato não encontrado!");
            }
        } else {
            System.out.println("A agenda de contatos está vazia!");
        }

        return contatoPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        //exibindo contatos - vazio
        agendaContatos.exibirContatos();

        //adicionando contatos
        agendaContatos.adicionarContato("João", 55544466);
        agendaContatos.adicionarContato("Maria", 35214);
        agendaContatos.adicionarContato("Carlos", 885);
        //atualizando o contato 'Maria'
        agendaContatos.adicionarContato("Maria", 111111);
        agendaContatos.adicionarContato("Max", 885);
        agendaContatos.adicionarContato("Max I", 9112);
//
        agendaContatos.exibirContatos();
        //removendo contato
        agendaContatos.removerContato("Max");
        agendaContatos.removerContato("Max II");
        System.out.println();
        agendaContatos.exibirContatos();
//
        //pesquisando por nome
        System.out.println("O número de Maria é: " + agendaContatos.pesquisarPorNome("Maria"));
        System.out.println("O número de Carlos é: " + agendaContatos.pesquisarPorNome("Carlos"));
        System.out.println(agendaContatos.pesquisarPorNome("Max III"));

    }
}

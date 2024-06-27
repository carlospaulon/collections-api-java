package Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        if (!contatoSet.isEmpty()) {
            System.out.println(contatoSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatoPorNome = new HashSet<>();

        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().startsWith(nome)) {
                    contatoPorNome.add(c);
                }
            }
            return contatoPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        //exibindo contatos - vazio
        agendaContatos.exibirContatos();

        //adicionando contatos
        agendaContatos.adicionarContato("João", 554433);
        agendaContatos.adicionarContato("João M.", 12345);
        agendaContatos.adicionarContato("João Java", 12);
        agendaContatos.adicionarContato("Maria", 11425);
        agendaContatos.adicionarContato("José", 12345);
        agendaContatos.adicionarContato("Maria T.", 99988);
        agendaContatos.adicionarContato("Camila", 75478);
        agendaContatos.adicionarContato("Mateus", 75478);
        //Esta 'Maria' não será considerada, pois já foi adicionado à lista
        agendaContatos.adicionarContato("Maria", 75478);

        //exibindo contatos
        agendaContatos.exibirContatos();

        //pesquiso os contatos que iniciam com João e com Maria
        System.out.println(agendaContatos.pesquisarPorNome("João"));
        System.out.println(agendaContatos.pesquisarPorNome("Maria"));
        System.out.println();

        System.out.println("Contato atualizado " + agendaContatos.atualizarNumeroContato("José", 987456));
        System.out.println("Contato atualizado " + agendaContatos.atualizarNumeroContato("Maria T.", 12548));
        System.out.println();

        System.out.println("Exibindo os contatos após atualizações: ");
        agendaContatos.exibirContatos();
    }
}

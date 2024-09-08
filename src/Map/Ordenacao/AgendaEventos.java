package Map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String atracao) {
        eventosMap.put(data, new Evento(nomeEvento, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> mapOrdenado = new TreeMap<>(eventosMap);
        if (!mapOrdenado.isEmpty()) {
            for (Map.Entry<LocalDate, Evento> entry : mapOrdenado.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                Evento evento = entry.getValue();

                System.out.println("Data: " + dataEvento + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
            }
        } else {
            throw new RuntimeException("A agenda está vazia!");
        }
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        Map<LocalDate, Evento> mapOrdenado = new TreeMap<>(eventosMap);

        for (Map.Entry<LocalDate, Evento> entry : mapOrdenado.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if (dataAtual.equals(dataEvento) || dataEvento.isAfter(dataAtual)) {
                proximaData = dataEvento;
                proximoEvento = entry.getValue();
                break;
            }
        }
        if (proximoEvento != null) {
            System.out.println("O próximo evento: " + proximoEvento.getNome() + ", ocorrerá em " + proximaData);
        } else {
            System.out.println("Não há eventos futuros na agenda!");
        }

    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.obterProximoEvento();

        agendaEventos.adicionarEvento(LocalDate.of(2024, 2, 19), "Palestra Beira-Rio", "Professor Noslen");
        agendaEventos.adicionarEvento(LocalDate.of(2005, 4, 10), "Lançamento de Software", "Demo da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 9, 25), "Futebol Solidário", "Jogador do Inter");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 2, 19), "Seminário sobre IA", "Open AI");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.SEPTEMBER, 10), "Movie", "The Batman");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.SEPTEMBER, 4), "Collections", "Debate");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.OCTOBER, 11), "Estágio SAP", "Churrasco");

        agendaEventos.exibirAgenda();
        System.out.println();
        agendaEventos.obterProximoEvento();

    }
}

package List.Ordenacao;

public class Livro {
    private String title;
    private String autor;
    private int anoPublicacao;

    public Livro(String title, String autor, int anoPublicacao) {
        this.title = title;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }
}

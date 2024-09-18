package br.ufpb.dcx.tobias.soares.gerenciadorDeTarefas;

public class Tarefa {
    private String titulo;
    private String descricao;
    private Usuario usuario;
    private boolean ehCompleta;

    public Tarefa(String titulo, String descricao, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.ehCompleta = false;
        this.usuario = usuario;
    }

    public Tarefa(String titulo, Usuario usuario){
        this.titulo = titulo;
        this.descricao = "";
        this.ehCompleta = false;
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEhCompleta() {
        return ehCompleta;
    }

    public void setEhCompleta(boolean ehCompleta) {
        this.ehCompleta = ehCompleta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", titulo='" + titulo + '\'' +
                ", usuario=" + usuario +
                ", ehCompleta=" + ehCompleta +
                '}';
    }
}

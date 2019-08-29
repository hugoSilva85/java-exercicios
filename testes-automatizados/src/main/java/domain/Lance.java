package domain;

public class Lance {
    private Usuario usuario;
    private double valor;

    public Lance(Usuario usuario, double valor){
        this.usuario = usuario;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
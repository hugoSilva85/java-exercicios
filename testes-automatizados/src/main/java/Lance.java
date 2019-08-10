public class Lance {
    private Usuario usuario;
    private double valor;

    Lance(Usuario usuario, double valor){
        this.usuario = usuario;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

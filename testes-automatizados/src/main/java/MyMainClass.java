import domain.Lance;
import domain.Leilao;
import domain.Usuario;
import services.Avaliador;

public class MyMainClass {
    public static void main(String[] args) {
        Usuario hugo = new Usuario("Hugo");
        Usuario juca = new Usuario("Hugo");

        Leilao leilao = new Leilao("Playstation 3 novo");

        leilao.propoe(new Lance(hugo,300.0));
        leilao.propoe(new Lance(juca,400.0));
        leilao.propoe(new Lance(hugo,450.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        System.out.println(leiloeiro.getMaiorLance());
        System.out.println(leiloeiro.getMenorDeTodos());
    }
}
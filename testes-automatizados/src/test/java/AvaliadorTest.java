import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AvaliadorTest {
    @Test
    public void MustToBeShowBidsInAscendingOrder(){

        Usuario yuri = new Usuario("Yuri");
        Usuario hugo = new Usuario("Hugo");
        Usuario tete = new Usuario("Tete");
        Usuario day = new Usuario("Day");

        Leilao leilao = new Leilao("Carro com sinistro 2016");

        leilao.propoe(new Lance(yuri,3000.0));
        leilao.propoe(new Lance(tete,3500.0));
        leilao.propoe(new Lance(hugo,5000.0));
        leilao.propoe(new Lance(day,6700.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 6700.0;
        double menorEsperado = 3000.0;

        Assertions.assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        Assertions.assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }
}

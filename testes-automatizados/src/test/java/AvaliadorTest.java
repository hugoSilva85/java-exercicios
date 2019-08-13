import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.List;

public class AvaliadorTest {
    @Test
    public void GivenIamReceivedManyBids(){

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

        assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }

    @Test
    public void  GivenIamReceivedJustOneBid(){
        Usuario yuri = new Usuario("Yuri");

        Leilao leilao = new Leilao("PS4 Novo");

        leilao.propoe(new Lance(yuri,800.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 800.0;
        double menorEsperado = 800.0;

        assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }

    @Test
    public void GivenIamWantToSeeTheThreeHighestBids(){
        Usuario hugo = new Usuario("Hugo");
        Usuario day  = new Usuario("Dayane");
        Usuario joao = new Usuario("Joao");

        Leilao leilao = new Leilao("Casa na praia");

        leilao.propoe(new Lance(hugo,30000.0));
        leilao.propoe(new Lance(day, 40000.0));
        leilao.propoe(new Lance(joao,5000.0));
        leilao.propoe(new Lance(hugo,8000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertThat(3).isEqualTo(maiores.size());
        assertThat(40000.0).isEqualTo(maiores.get(0).getValor());
        assertThat(30000.0).isEqualTo(maiores.get(1).getValor());
        assertThat(8000.0).isEqualTo(maiores.get(2).getValor());

    }
}

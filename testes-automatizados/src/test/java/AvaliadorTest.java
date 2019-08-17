import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.List;

public class AvaliadorTest {
    private Avaliador leiloeiro;
    private Usuario yuri;
    private Usuario hugo;
    private Usuario tete;
    private Usuario day;
    private Usuario joao;

    private void criaAvaliador(){
        this.leiloeiro = new Avaliador();
        this.yuri = new Usuario("Yuri");
        this.hugo = new Usuario("Hugo");
        this.tete = new Usuario("Tete");
        this.day = new Usuario("Day");
        this.joao = new Usuario("Joao");
    }
    @Test
    public void GivenIamReceivedManyBids(){
        Leilao leilao = new Leilao("Carro com sinistro 2016");

        leilao.propoe(new Lance(yuri,3000.0));
        leilao.propoe(new Lance(tete,3500.0));
        leilao.propoe(new Lance(hugo,5000.0));
        leilao.propoe(new Lance(day,6700.0));

        criaAvaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 6700.0;
        double menorEsperado = 3000.0;

        assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }

    @Test
    public void  GivenIamReceivedJustOneBid(){
        Leilao leilao = new Leilao("PS4 Novo");

        leilao.propoe(new Lance(yuri,800.0));

        criaAvaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 800.0;
        double menorEsperado = 800.0;

        assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }

    @Test
    public void GivenIamWantToSeeTheThreeHighestBids(){
        Leilao leilao = new Leilao("Casa na praia");

        leilao.propoe(new Lance(hugo,30000.0));
        leilao.propoe(new Lance(day, 40000.0));
        leilao.propoe(new Lance(joao,5000.0));
        leilao.propoe(new Lance(hugo,8000.0));

        criaAvaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertThat(3).isEqualTo(maiores.size());
        assertThat(40000.0).isEqualTo(maiores.get(0).getValor());
        assertThat(30000.0).isEqualTo(maiores.get(1).getValor());
        assertThat(8000.0).isEqualTo(maiores.get(2).getValor());

    }
}

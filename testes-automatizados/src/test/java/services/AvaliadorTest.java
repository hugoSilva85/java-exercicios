package services;

import domain.Lance;
import domain.Leilao;
import domain.Usuario;
import org.junit.Before;
import org.junit.Test;
import services.Avaliador;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AvaliadorTest {
    private Avaliador leiloeiro;
    private Usuario yuri;
    private Usuario hugo;
    private Usuario tete;
    private Usuario day;
    private Usuario joao;

    @Before
    public void criaAvaliador(){
        this.leiloeiro = new Avaliador();
        this.yuri = new Usuario("Yuri");
        this.hugo = new Usuario("Hugo");
        this.tete = new Usuario("Tete");
        this.day = new Usuario("Day");
        this.joao = new Usuario("Joao");
    }

    @Test
    public void GivenIamReceivedManyBids(){
        Leilao leilao = new CriadorDeLeilao()
                .para("Carro com sinistro 2016")
                .lance(yuri,3000.0)
                .lance(tete,3500.0)
                .lance(hugo,5000.0)
                .lance(day,6700.0)
                .constori();

        criaAvaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 6700.0;
        double menorEsperado = 3000.0;

        assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }

    @Test
    public void  GivenIamReceivedJustOneBid(){
        Leilao leilao = new CriadorDeLeilao()
                .para("PS4 Novo")
                .lance(yuri,800.0)
                .constori();

        criaAvaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 800.0;
        double menorEsperado = 800.0;

        assertThat(maiorEsperado).isEqualTo(leiloeiro.getMaiorLance());
        assertThat(menorEsperado).isEqualTo(leiloeiro.getMenorDeTodos());
    }

    @Test
    public void GivenIamWantToSeeTheThreeHighestBids(){
        Leilao leilao = new CriadorDeLeilao()
                .para("Casa na praia")
                .lance(hugo,30000.0)
                .lance(day, 40000.0)
                .lance(joao,5000.0)
                .lance(hugo,8000.0)
                .constori();

        criaAvaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertThat(3).isEqualTo(maiores.size());
        assertThat(40000.0).isEqualTo(maiores.get(0).getValor());
        assertThat(30000.0).isEqualTo(maiores.get(1).getValor());
        assertThat(8000.0).isEqualTo(maiores.get(2).getValor());
    }

    @Test(expected = RuntimeException.class)
    public void GivenIamNoReceivedAnyOneBids(){
            Leilao leilao = new CriadorDeLeilao()
                    .para("Marea turbo")
                    .constori();

            leiloeiro.avalia(leilao);
    }
}

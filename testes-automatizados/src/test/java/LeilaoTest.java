import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeilaoTest {
    private Usuario yuri;
    private Usuario hugo;
    private Usuario tate;

    @Before
    public void criaAvaliador() {
        this.yuri = new Usuario("Yuri");
        this.hugo = new Usuario("Hugo");
        this.tate = new Usuario("Tete");
    }

    @Test
    public void GivenIamReceivedJustOneBid() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Carro com sinistro 2016")
                .lance(yuri, 3000.0)
                .constori();

        assertThat(1).isEqualTo(leilao.getLances().size());
    }

    @Test
    public void GivenIamReceivedManyBids() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Carro com sinistro 2016")
                .lance(yuri, 3000.0)
                .lance(tate, 3500.0)
                .lance(hugo, 5000.0)
                .constori();

        assertThat(3).isEqualTo(leilao.getLances().size());
    }

    @Test
    public void GivenReceivedMoreThanOneBidsFromTheSamePerson(){
        Leilao leilao = new CriadorDeLeilao()
                .para("Carro com sinistro 2016")
                .lance(yuri, 3000.0)
                .lance(yuri, 4400.0)
                .constori();

        assertThat(1).isEqualTo(leilao.getLances().size());
    }
}


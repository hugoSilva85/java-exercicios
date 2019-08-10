import java.util.ArrayList;
import java.util.List;

public class Leilao {
    private String produto;
    private List<Lance> lances;

    public Leilao(String produto){
        this.produto = produto;
    }

    public void propoe(Lance lance){
        this.lances = new ArrayList<Lance>();
        lances.add(lance);
    }

    public List<Lance> getLances() {
        return lances;
    }
}
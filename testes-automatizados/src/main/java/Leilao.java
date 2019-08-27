import java.util.ArrayList;
import java.util.List;

public class Leilao {
    private String produto;
    private List<Lance> lances;

    public Leilao(String produto){
        this.lances = new ArrayList<Lance>();
        this.produto = produto;
    }

    public void propoe(Lance lance){
        if(lances.isEmpty() ||
                !ultimoLanceDado()
                .getUsuario()
                .equals(lance.getUsuario()))
        {
            lances.add(lance);
        }
    }

    public List<Lance> getLances() { return lances; }
    private Lance ultimoLanceDado(){return lances.get(lances.size()-1);}
}
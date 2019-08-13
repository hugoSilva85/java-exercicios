import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
    /*
    A var maiorDeTodos e inicializado com o menor valor possivel para um double,
    sendo assim ele cai na condiçao do if na primeira vez e é substituido pelo primeiro valor da lista
    A var menorDeTodos segue a mesma condição porém no valor inverso
    */

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avalia(Leilao leilao){
        for(Lance lance: leilao.getLances()){
            if(lance.getValor()> maiorDeTodos){
                maiorDeTodos = lance.getValor();
            }
            if(lance.getValor()< menorDeTodos){
                menorDeTodos = lance.getValor();
            }
        }
    }

    private void pegaOsMaioresNo(Leilao leilao){
        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            public int compare(Lance lance1, Lance lance2) {
                if(lance1.getValor() < lance2.getValor()) return 1;
                if(lance1.getValor() > lance2.getValor()) return -1;
                return 0;
            }
        });
        maiores = maiores.subList(0,3);
    }

    public List<Lance> getTresMaiores(){ return this.maiores; }
    public double getMaiorLance(){ return maiorDeTodos; }
    public double getMenorDeTodos(){ return menorDeTodos; }
}

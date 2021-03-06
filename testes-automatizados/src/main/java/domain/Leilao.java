package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Leilao {
    private String produto;
    private List<Lance> lances;
    private final int MAX_LANCES = 5;
    private Integer id;
    private String descricao;
    private boolean encerrado;

    public Leilao(String produto){
        this.lances = new ArrayList<Lance>();
        this.produto = produto;
    }

    public void propoe(Lance lance){


        if( lances.isEmpty() || podeDarLance(lance.getUsuario()))
        {
            lances.add(lance);
        }
    }

    public List<Lance> getLances() { return lances; }
    private Lance ultimoLanceDado(){return lances.get(lances.size()-1);}

    private int qtdDeLancesDo(Usuario usuario){
        int total = 0;
        for (Lance l: lances){
            if(l.getUsuario().equals(usuario)) total++;
        }
        return total;
    }

    private boolean podeDarLance(Usuario usuario){
        return  !ultimoLanceDado()
                .getUsuario()
                .equals(usuario) &&
                qtdDeLancesDo(usuario) < MAX_LANCES;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void getDescricao(String descricaoValue){
        this.descricao = descricaoValue;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void encerra() {
        this.encerrado = true;
    }

    public boolean isEncerrado() {
        return encerrado;
    }
}
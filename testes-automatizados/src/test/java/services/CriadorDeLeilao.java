package services;

import domain.Lance;
import domain.Leilao;
import domain.Usuario;

public class CriadorDeLeilao {
    private Leilao leilao;

    public CriadorDeLeilao(){}

    public CriadorDeLeilao para(String descricao){
        this.leilao = new Leilao(descricao);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, double valor){
        leilao.propoe(new Lance(usuario,valor));
        return this;
    }

    public Leilao constori(){
        return leilao;
    }
}

package cargos;

import sistema.Autenticavel;

public class Gerente extends Funcionario implements Autenticavel {
    private int senha = 123456;

    public boolean autentica(int senha){
        if(this.senha != senha){
            return false;
        }

        return  true;
    }
}

package cargos;

import sistema.Acessos;

public class Funcionario {
    private int salario;
    private int abono;
    private int id;
    private String funcao;
    private Acessos acessos;

    public int getSalario(){
        return salario;
    }

    public void setSalario(int access){
        this.salario = access;
    }
}

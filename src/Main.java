import cargos.Diretor;
import cargos.Engenheiro;
import sistema.Autenticavel;
import sistema.SistemaInterno;

public class Main {

    public static void main(String[] args) {

        Autenticavel diretor = new Diretor();
        SistemaInterno a = new SistemaInterno();

        if(a.login(diretor, 123456)){
            System.out.println("Autenticado");
        }else {
            System.out.println("Nao Autenticado");

        }
    }
}

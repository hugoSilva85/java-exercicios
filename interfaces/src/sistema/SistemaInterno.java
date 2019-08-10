package sistema;

public class SistemaInterno {
    public boolean login(Autenticavel a, int senha){

        boolean ok = a.autentica(senha);
        return ok;
    }
}

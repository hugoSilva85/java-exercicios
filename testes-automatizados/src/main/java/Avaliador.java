public class Avaliador {
    /*
    A var maiorDeTodos e inicializado com o menor valor possivel para um double,
    sendo assim ele cai na condiçao do if na primeira vez e é substituido pelo primeiro valor da lista
    */

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;

    public void avalia(Leilao leilao){
            for(Lance lance: leilao.getLances()){
            if(lance.getValor()> maiorDeTodos){
                maiorDeTodos = lance.getValor();
            }
        }
    }

    public double getMaiorLance(){
        return maiorDeTodos;
    }
}

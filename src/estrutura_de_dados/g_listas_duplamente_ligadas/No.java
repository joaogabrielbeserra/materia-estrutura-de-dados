package estrutura_de_dados.g_listas_duplamente_ligadas;

public class No {

    int valor;
    No prox;
    No ant;

    public No(int v){
        this.valor = v;
        this.prox = null;
        this.ant = null;
    }
}
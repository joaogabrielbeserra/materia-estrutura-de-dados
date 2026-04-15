package estrutura_de_dados.h_listas_duplamentes_ligadas_circulares;

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
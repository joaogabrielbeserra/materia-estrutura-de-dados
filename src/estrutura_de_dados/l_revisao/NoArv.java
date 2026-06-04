package estrutura_de_dados.l_revisao;

public class NoArv {
    int valor;
    NoArv dir;
    NoArv esq;


    public NoArv(int valor) {
        this.dir = null;
        this.esq = null;
        this.valor = valor;
    }
}

package estrutura_de_dados.e_filhas_e_pilhas;

public class Pilha {
    private No topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void empilhar(int x) {
        No novo = new No(x);
        novo.prox = topo; // o  novo nó aponta para quem era o topo
        topo = novo;      // o topo agora e o novo nó
        tamanho++;
    }

    public int desempilhar() {
        if (vazia()) throw new RuntimeException("pilha sem nada");

        int valor = topo.valor;
        topo = topo.prox;
        tamanho--;
        return valor;
    }

    public int topo() {
        if (vazia()) throw new RuntimeException("pilha sem nada");
        return topo.valor;
    }

    public boolean vazia() {
        return topo == null;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void exibir() {
        if (vazia()) {
            System.out.println("A pilha está vazia, painho");
            return;
        }
        No temp = topo;
        while (temp != null) {
            System.out.println("| " + temp.valor + " |");
            temp = temp.prox;
        }
        System.out.println("-------");
    }
}


    


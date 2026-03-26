package estrutura_de_dados.e_filhas_e_pilhas;

public class Fila {
    private No cabeca; // Início da fila (quem sai)
    private No cauda;  // Fim da fila (quem entra)
    private int tamanho;

    public Fila() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void enfileirar(int x) {
        No novo = new No(x);
        if (vazia()) {
            cabeca = novo;
        } else {
            cauda.prox = novo; // O antigo último aponta para o novo
        }
        cauda = novo; // O novo nó agora é a cauda
        tamanho++;
    }

    public int desenfileirar() {
        if (vazia()) throw new RuntimeException("Fila vazia!");

        int valor = cabeca.valor;
        cabeca = cabeca.prox; // A cabeça pula para o próximo

        if (cabeca == null) { // Se a fila ficou vazia, limpa a cauda também
            cauda = null;
        }

        tamanho--;
        return valor;
    }

    public int cabeca() {
        if (vazia()) throw new RuntimeException("Fila vazia!");
        return cabeca.valor;
    }

    public int cauda() {
        if (vazia()) throw new RuntimeException("Fila vazia!");
        return cauda.valor;
    }

    public boolean vazia() {
        return cabeca == null;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void exibir() {
        if (vazia()) {
            System.out.println("Fila vazia, painho.");
            return;
        }
        No temp = cabeca;
        System.out.print("Início -> ");
        while (temp != null) {
            System.out.print("[" + temp.valor + "] ");
            temp = temp.prox;
        }
        System.out.println("<- Fim");
    }
}

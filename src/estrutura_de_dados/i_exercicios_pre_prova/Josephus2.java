package estrutura_de_dados.i_exercicios_pre_prova;


public class Josephus2 {

    static No inicio = null; // <- VARIÁVEL GLOBAL

    static void main(String[] args) {

        int N = 5;
        int S = 2;
        int J = 2;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();



        System.out.println("JOSEPHUS");
        System.out.println("N = " + N);
        System.out.println("S = " + S);



        josephus(S, J);

    }

    static void insereFinal(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = novo;
            inicio.prox = novo;
            inicio.ant = novo;
        } else {
            No ultimo = inicio.ant;

            novo.prox = inicio;
            novo.ant = ultimo;
            ultimo.prox = novo;
            inicio.ant = novo;
        }
        novo.prox = inicio;
    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }
        No temp = inicio;
        System.out.print("Lista: ");
        do {
            System.out.print("[" + temp.valor + "] ");
            temp = temp.prox;
        } while (temp != inicio);
        System.out.println("(Circular)");
    }

    static void josephus(int s, int j) {
        if (inicio == null) return;

        No atual = inicio;

        while (atual.prox != atual) {
            for (int i = 1; i < s; i++) {
                atual = atual.prox;
            }

            No proximoAposMorte = atual.prox;

            atual.ant.prox = atual.prox;
            atual.prox.ant = atual.ant;

            if (atual == inicio) inicio = proximoAposMorte;

            atual = proximoAposMorte;

            if (atual.prox == atual) break;

            for (int i = 1; i < j; i++) {
                atual = atual.ant;
            }

            No proximoAposMorteTras = atual.ant;

            atual.ant.prox = atual.prox;
            atual.prox.ant = atual.ant;

            if (atual == inicio) inicio = proximoAposMorteTras;

            atual = proximoAposMorteTras;
        }

        System.out.println("Sobrevivente final: " + atual.valor);
    }
}

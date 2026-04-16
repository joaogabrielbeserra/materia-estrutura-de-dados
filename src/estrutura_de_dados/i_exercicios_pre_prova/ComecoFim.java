package estrutura_de_dados.i_exercicios_pre_prova;

public class ComecoFim {
    static No inicio = null;

    static void main(String[] args) {

        float N = 7;


        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();

        No init = inicio;
        No finaly = inicio.ant;

        comecoFim(init, finaly);
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

    static void comecoFim(No init, No finaly) {
        if (init == finaly) {
            System.out.println(init.valor);
            return;
        }

        System.out.println(init.valor + " " + finaly.valor);

        if (init.prox == finaly) {
            return;
        }

        comecoFim(init.prox, finaly.ant);

    }
}

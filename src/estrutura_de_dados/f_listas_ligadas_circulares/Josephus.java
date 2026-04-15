package estrutura_de_dados.f_listas_ligadas_circulares;

public class Josephus {

    static No inicio = null; // <- VARIÁVEL GLOBAL

    public static void main(String[] args) {

        int N = 5;
        int S = 1;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();



        System.out.println("JOSEPHUS");
        System.out.println("N = " + N);
        System.out.println("S = " + S);



        josephus(S);

    }

    static void insereFinal(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = novo;
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;
            }

            temp.prox = novo;
        }
        novo.prox = inicio;
    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista VAZIA, nada a exibir");
        } else {
            No temp = inicio;
            do {
                System.out.println(temp.valor);
                temp = temp.prox;
            } while (temp != inicio);
        }
    }

    static void josephus(int s) {
        while (inicio.prox != inicio) {
            for (int i = 0; i < s - 2; i++) { inicio = inicio.prox; }
            inicio.prox = inicio.prox.prox;
            inicio = inicio.prox;
            }
        System.out.println("Sobrevivente final: " + inicio.valor);
        }
}

package estrutura_de_dados.h_listas_duplamentes_ligadas_circulares;

public class ListasDuplamenteLigadasCirculares {

    static No inicio = null;

    public static void main(String[] args) {
        System.out.println("--- Teste Inserção ---");
        inserirInicio(10);
        inserirFinal(30);
        inserirOrdenado(20);
        inserirOrdenado(5);
        inserirOrdenado(40);
        exibir();
        exibirInverso();

        System.out.println("\n--- Teste Remoção ---");
        removerPrimeiro();
        removerUltimo();
        remover(20);
        exibir();
    }

    static void inserirInicio(int x) {
        No novo = new No(x);
        if (inicio == null) {
            inicio = novo;
            novo.prox = inicio;
            novo.ant = inicio;
        } else {
            No ultimo = inicio.ant;
            novo.prox = inicio;
            novo.ant = ultimo;
            ultimo.prox = novo;
            inicio.ant = novo;
            inicio = novo;
        }
    }

    static void inserirFinal(int x) {
        if (inicio == null) {
            inserirInicio(x);
        } else {
            No novo = new No(x);
            No ultimo = inicio.ant;

            novo.prox = inicio;
            novo.ant = ultimo;
            ultimo.prox = novo;
            inicio.ant = novo;
        }
    }

    static void inserirOrdenado(int x) {
        if (inicio == null || x <= inicio.valor) {
            inserirInicio(x);
            return;
        }

        No atual = inicio;
        // Percorre enquanto o próximo não for o início e o valor for menor
        while (atual.prox != inicio && atual.prox.valor < x) {
            atual = atual.prox;
        }

        No novo = new No(x);
        novo.prox = atual.prox;
        novo.ant = atual;
        atual.prox.ant = novo;
        atual.prox = novo;
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

    static void exibirInverso() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }
        No temp = inicio.ant; // Começa pelo último
        System.out.print("Inverso: ");
        do {
            System.out.print("[" + temp.valor + "] ");
            temp = temp.ant;
        } while (temp != inicio.ant);
        System.out.println("(Circular)");
    }

    static void remover(int x) {
        if (inicio == null) return;

        No atual = inicio;
        do {
            if (atual.valor == x) {
                if (atual == inicio) {
                    removerPrimeiro();
                } else {
                    atual.ant.prox = atual.prox;
                    atual.prox.ant = atual.ant;
                }
                return;
            }
            atual = atual.prox;
        } while (atual != inicio);
    }

    static void removerPrimeiro() {
        if (inicio == null) return;

        if (inicio.prox == inicio) { // Só tem um elemento
            inicio = null;
        } else {
            No ultimo = inicio.ant;
            inicio = inicio.prox;
            inicio.ant = ultimo;
            ultimo.prox = inicio;
        }
    }

    static void removerUltimo() {
        if (inicio == null) return;

        if (inicio.prox == inicio) {
            inicio = null;
        } else {
            No ultimo = inicio.ant;
            No penultimo = ultimo.ant;
            penultimo.prox = inicio;
            inicio.ant = penultimo;
        }
    }

    // Classe auxiliar No
    static class No {
        int valor;
        No prox;
        No ant;

        No(int valor) {
            this.valor = valor;
        }
    }
}

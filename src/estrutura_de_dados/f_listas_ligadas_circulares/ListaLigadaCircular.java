package estrutura_de_dados.f_listas_ligadas_circulares;

import estrutura_de_dados.e_filhas_e_pilhas.No;

public class ListaLigadaCircular {
    private No inicio;

    public ListaLigadaCircular(){
        this.inicio = null;
    }

    public void inserirLast(int x) {
        No novo = new No(x);
        if(vazia()) {
            inicio = novo;
            inicio.prox = inicio;
        } else {
            No temp = inicio;
            while(temp.prox != inicio) {
                temp = temp.prox;
            }
            temp.prox = novo;
            novo.prox = inicio;
        }
    }

    public void inserirInit(int x) {
        No novo = new No(x);
        if(vazia()) {
            inicio = novo;
            inicio.prox = inicio;
        } else {

            No temp = inicio;
            while(temp.prox != inicio) {
                temp = temp.prox;
            }
            temp.prox = novo;
            novo.prox = inicio;
            inicio = novo;

        }
    }

    public void exibir() {
        No temp = inicio;
        if (vazia()) {
            System.out.println("A pilha está vazia, painho");
        } else {
            System.out.print("Início -> ");
            do {
                System.out.print("| " + temp.valor + " | -> ");
                temp = temp.prox;
            } while (temp != inicio);
            System.out.println("Voltou pro Início");
        }
    }

    public void removerLast() {
        No temp = inicio;
        if (vazia()) {
            System.out.println("A pilha está vazia, painho");
        } else {
            while (temp.prox.prox != inicio) {
                temp = temp.prox;
            }
            temp.prox = inicio;

        }
    }

    public void removerInit() {
        No temp = inicio;
        if (vazia()) {
            System.out.println("A pilha está vazia, painho");
        } else {
            while (temp.prox != inicio) {
                temp = temp.prox;
            }
            inicio = inicio.prox;
            temp.prox = inicio;

        }
    }



    public boolean vazia() {
        return inicio == null;
    }
//
//    public static int removerUltimo(int x) {
//
//    }
//
//    public static int removerPrimeiro(int x) {
//
//    }
}

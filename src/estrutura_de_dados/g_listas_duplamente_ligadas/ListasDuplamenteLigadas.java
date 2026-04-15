package estrutura_de_dados.g_listas_duplamente_ligadas;

public class ListasDuplamenteLigadas {

    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {
        exibir();
        inserirOrdenado(50);

        inserirOrdenado(10);

        inserirOrdenado(60);

        inserirOrdenado(55);

        inserirOrdenado(5);

        inserirOrdenado(20);

        exibir();
        System.out.println("");
        removerPrimeiro();
        System.out.println("");
        exibir();
        System.out.println("");
        exibirInverso();

        System.out.println("");
        exibir();
        System.out.println("");
        removerUltimo();
        System.out.println("");
        exibir();
        System.out.println("");
        exibirInverso();


        System.out.println("");
        exibir();
        System.out.println("");
        remover(11);
        System.out.println("");
        exibir();
        System.out.println("");
        exibirInverso();

    }

    static void inserirInicio(int x){
        No novo = new No(x);
        if (inicio==null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }
    }

    static void inserirFinal(int x){
        No novo = new No(x);
        if (inicio==null) {
            inicio = novo;
            fim = novo;
        }
        else {
            novo.ant = fim;
            fim.prox = novo;
            fim = novo;
        }
    }

    static void inserirOrdenado(int x){
        No novo = new No(x);
        if (inicio==null) {
            inicio = novo;
            fim = novo;
        } else {
            if(novo.valor < inicio.valor) {
                novo.prox = inicio;
                inicio.ant = novo;
                inicio = novo;

            } else if (novo.valor > fim.valor) {
                novo.ant = fim;
                fim.prox = novo;
                fim = novo;
            } else {
                No temp = inicio;
                while(temp.prox.valor < novo.valor) {
                    temp = temp.prox;
                }
                novo.ant = temp;
                novo.prox = temp.prox;
                novo.prox.ant = novo;
                temp.prox = novo;
            }
        }
    }

    static void exibir(){
        if(vazia()) System.out.println("lista vazia!");
        else {
            No temp = inicio;
            while (temp != null) {
                System.out.println("| " + temp.valor + " |");
                temp = temp.prox;
            }
        }
    }

    static boolean vazia(){
        if (inicio == null) return true;
        else return false;
    }

    static void exibirInverso(){
        if(vazia()) System.out.println("lista vazia!");
        else {
            No temp = fim;
            while (temp != null) {
                System.out.println("| " + temp.valor + " |");
                temp = temp.ant;
            }
        }
    }

    static void remover(int x){
        if(vazia()) {
            System.out.println("lista vazia!");
        } else if (inicio.valor == x) {
            removerPrimeiro();
        } else if (fim.valor == x) {
            removerUltimo();
        } else {
            No temp = inicio;
            while (temp != null && temp.valor != x) {
                temp = temp.prox;
            }

            if (temp == null) {
                System.out.println("Valor " + x + " não encontrado na lista.");
            } else {
                temp.ant.prox = temp.prox;
                temp.prox.ant = temp.ant;
                System.out.println("Valor " + x + " removido.");
            }

        }
    }

    static void removerPrimeiro(){
        if(vazia()) System.out.println("lista vazia!");
        else {
            inicio = inicio.prox;
            inicio.ant = null;
        }
    }

    static void removerUltimo(){
        if(vazia()) System.out.println("lista vazia!");
        else {
            fim = fim.ant;
            fim.prox = null;
        }
    }

}

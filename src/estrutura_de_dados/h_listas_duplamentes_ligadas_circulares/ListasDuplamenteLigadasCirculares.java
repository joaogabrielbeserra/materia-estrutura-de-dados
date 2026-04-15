package estrutura_de_dados.h_listas_duplamentes_ligadas_circulares;


public class ListasDuplamenteLigadasCirculares {

    static No inicio = null;

    public static void main(String[] args) {
        exibir();
        inserirInicio(10);
        exibir();
        inserirInicio(20);
        exibir();


    }

    static void inserirInicio(int x){
        No novo = new No(x);
        if(inicio == null) {
            inicio = novo;
            novo.prox = inicio;
            novo.ant = inicio;
        } else {
            No ultimo = inicio.ant; // Busca o último nó usando o anterior do início

            novo.prox = inicio;
            novo.ant = ultimo;

            ultimo.prox = novo; // Último aponta pro novo
            inicio.ant = novo;  // Antigo início aponta pra trás pro novo
            inicio = novo;


        }
    }

    static void inserirFinal(int x){

    }

    static void inserirOrdenado(int x){

    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        No temp = inicio;
        System.out.print("Início (" + inicio.valor + ") -> ");

        do {
            System.out.print("[" + temp.valor + "] ");
            temp = temp.prox;
        } while (temp != inicio); 
        System.out.println("-> Voltou para o Início (" + temp.valor + ")");
    }

    static void exibirInverso(){

    }

    static void remover(int x){

    }

    static void removerPrimeiro(){

    }

    static void removerUltimo(){

    }

}


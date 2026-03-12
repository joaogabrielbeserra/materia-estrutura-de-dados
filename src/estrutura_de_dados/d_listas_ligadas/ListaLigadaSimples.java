package estrutura_de_dados.d_listas_ligadas;

public class ListaLigadaSimples {

    static No inicio = null;

    public static void main(String[] args) {
        inicio = new No(5);
        No n2 = new No(8);
        inicio.prox = n2;
        No n3 = new No(10);
        n2.prox = n3;
        No n4 = new No(7);
        n3.prox = n4;
        No n5 = new No(15);
        n4.prox = n5;
        No n6 = new No(27);
        n5.prox = n6;

        exibir();
    }

    public static void exibir(){
        if(inicio == null)
            System.out.println("Lista Vazia, nada a exibir.");
        else{
            No temp = inicio;
            while(temp != null){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }

}

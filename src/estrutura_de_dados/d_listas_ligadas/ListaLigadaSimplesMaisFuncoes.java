package estrutura_de_dados.d_listas_ligadas;

public class ListaLigadaSimplesMaisFuncoes {

    static No inicio = null;

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {

            int x = (int) (Math.random()*30);

            System.out.println("Inserindo: "+x);

            inserirOrdenado(x);
        }




        exibir();

    }

    public static void inserir(int x){
        No novo = new No(x);

        if(inicio == null)
            inicio = novo;
        else{
            No temp = inicio;
            while(temp.prox != null) //navegação até o final da lista
                temp = temp.prox;
            //aqui temp está no último nó da lista
            temp.prox = novo;
        }
    }


    public static void exibir(){
        if(inicio == null)
            System.out.println("Lista Vazia, nada a exibir.");
        else{
            System.out.println("--- Lista ----");
            No temp = inicio;
            while(temp != null){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }

    public static void inserirOrdenado(int x) {
        No novo = new No(x);
        if (inicio == null) {
            inicio = novo;
        } else if (novo.valor <= inicio.valor) {
            novo.prox = inicio;
            inicio = novo;
        } else {
            No temp = inicio;
            while((temp.prox != null)  && (temp.prox.valor < novo.valor)){
               temp = temp.prox;

            }
            if(temp.prox == null) {
                temp.prox = novo;
            } else  {
                novo.prox = temp.prox;
                temp.prox = novo;

            }
        }

    }

    public static void removerUltimo() {
        if (inicio == null) System.out.println("Lista Vazia, nada a exibir.");
        else if (inicio.prox == null) {
            inicio = null;
        } else {
            No temp = inicio;
            No anterior = null;
            while (temp.prox != null) {
                anterior = temp;
                temp = temp.prox;
            }
            anterior.prox = null;
        }
    }
}
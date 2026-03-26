package estrutura_de_dados.e_filhas_e_pilhas;


//Crie uma Lista Ligada com valores em ordem crescente entre 0 e N (N é fornecido pelo usuário)
//Crie um método chamado primos que remove da lista todos os números que não são primos
//Exiba a lista resultante (somente os números primos entre 0 e N)
//Crie um método recursivo chamado tamanho(No) que retorna quantos números primos existem entre 0 e N (basta contar quantos elementos restaram na lista ligada).
//        * Não utilize métodos externos como remover(x) para fazer as modificações na lista.
//        ** Não utilize métodos que identificam os números primos.
//        *** Toda sua implementação deve ser baseada somente nas alterações diretamente na lista ligada.


import java.util.Scanner;

public class Primos {

    static No inicio = null; // <- VARIÁVEL GLOBAL
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o valor de N: ");
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            inserir(i);
        }

        primos(N);

        exibir();
        System.out.println("Existem "+tamanho(inicio)+" numeros primos entre 0 e "+N);
    }

    private static void primos(int n){

        No temp = inicio;

        while (temp.valor < 2) {
            temp = temp.prox;
        }

        No t1 = temp;
        No t2 = temp.prox;

        No anterior = null;

        while (t1.prox != null) {
            while (t2.prox != null) {
                anterior = t2;
                t2 = t2.prox;
                if (t2.valor%t1.valor==0){
                    anterior.prox = t2.prox;
                }
            }

            t1 = t1.prox;
            t2 = t1.prox;


        }


    }








private static int tamanho(No temp){

    return 0;
}


private static void inserir(int x) {
    No novo = new No(x);

    if(inicio == null) {
        inicio = novo;
    } else if (inicio.prox == null) {
        inicio.prox = novo;
    } else {
        No temp = inicio;
        while(temp.prox != null) {
            temp = temp.prox;
        }
        temp.prox = novo;
    }
}

public static void exibir(){
    if(inicio == null)
        System.out.println("Lista Vazia, nada a exibir.");
    else{
        System.out.println("--- Lista ----");
        No temp = inicio;
        System.out.println("------");
        while(temp != null){

            System.out.print(temp.valor);
            temp = temp.prox;
            System.out.print(" - ");
        }

    }
}

}
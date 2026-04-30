package estrutura_de_dados.c_ordenacao;

public class AvaliacaoOrdenacao {
    static void main(String[] args) {
        int N = 20000;

        int vetAleatorio_1[] = new int[N];
        int vetMelhorCaso_1[] = new int[N];
        int vetPiorCaso_1[] = new int[N];


        inicializarVetor(vetAleatorio_1, N, 0); //0-aleatório, 1-crescente, 2-decrescente
        inicializarVetor(vetMelhorCaso_1, N, 1); //0-aleatório, 1-crescente, 2-decrescente
        inicializarVetor(vetPiorCaso_1, N, 2); //0-aleatório, 1-crescente, 2-decrescente

        int vetAleatorio_2[] = vetAleatorio_1.clone();
        int vetMelhorCaso_2[] = vetMelhorCaso_1.clone();
        int vetPiorCaso_2[] = vetPiorCaso_1.clone();

        int vetAleatorio_3[] = vetAleatorio_1.clone();
        int vetMelhorCaso_3[] = vetMelhorCaso_1.clone();
        int vetPiorCaso_3[] = vetPiorCaso_1.clone();

        long inicio, fim, tempoS, tempoMS;

        System.out.println("");
        //////// BubleSort ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        bubleSort(vetAleatorio_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(BubleSort) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        bubleSort(vetMelhorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(BubleSort) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        bubleSort(vetPiorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(BubleSort) Pior Caso: " + tempoS + "s" + tempoMS + "ms");

        System.out.println("");
        //////// SelectionSort ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        selectionSort(vetAleatorio_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(SelectionSort) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        selectionSort(vetMelhorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(SelectionSort) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        selectionSort(vetPiorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(SelectionSort) Pior Caso: " + tempoS + "s" + tempoMS + "ms");

        System.out.println("");
        //////// InsertionSort ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        insertionSort(vetAleatorio_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(InsertionSort) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        insertionSort(vetMelhorCaso_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(InsertionSort) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        insertionSort(vetPiorCaso_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(InsertionSort) Pior Caso: " + tempoS + "s" + tempoMS + "ms");


        String s = "oi";

    }


    private static void exibirVetor(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            if (vet[i] < 10) {
                System.out.print("0" + vet[i] + " ");
            } else {
                System.out.print(vet[i] + " ");
            }
        }
        System.out.println("");
    }


    static void inicializarVetor(int vet[], int N, int s) {
        switch(s){
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int) (Math.random() * (N * 2));
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i+1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N-i;
                break;
        }
    }

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a] = vet[b];
        vet[b] = aux;
    }




    private static void bubleSort(int[] vet, int N) {
        for(int i=0; i<N; i++){
            boolean foiAlterado = false;
            int menorNumeroEncontrado = N;
            int indiceDoMenorNumero = -1;
            for(int j=i; j<N-1-i; j++){
                if(vet[j]>=vet[j+1]) {
                    troca(vet, j, j + 1);
                    foiAlterado = true;
                }
                if (vet[j] < menorNumeroEncontrado) {
                    menorNumeroEncontrado = vet[j];
                    indiceDoMenorNumero = j;
                }
            }
            if (indiceDoMenorNumero != i && indiceDoMenorNumero != -1) {
                int tmp = vet[i];
                vet[i] = vet[indiceDoMenorNumero];
                vet[indiceDoMenorNumero] = tmp;
            }
            if(!foiAlterado) return;
        }
    }

    public static void selectionSort(int[] vet, int N) {
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (vet[j] < vet[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = vet[minIndex];
            vet[minIndex] = vet[i];
            vet[i] = temp;
        }
    }

    private static void insertionSort(int[] vet, int N) {
        for (int i = 1; i < N; ++i) {
            int proximoNumero = vet[i];
            int atualIndice = i - 1;

            while (atualIndice >= 0 && vet[atualIndice] > proximoNumero) {
                vet[atualIndice + 1] = vet[atualIndice];
                atualIndice = atualIndice - 1;
            }
            vet[atualIndice + 1] = proximoNumero;
        }
    }
}

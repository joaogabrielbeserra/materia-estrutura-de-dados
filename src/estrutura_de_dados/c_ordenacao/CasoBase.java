package estrutura_de_dados.c_ordenacao;

public class CasoBase {

    public static void main(String[] args) {

        int N = 6;

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

        int vetAleatorio_4[] = vetAleatorio_1.clone();
        int vetMelhorCaso_4[] = vetMelhorCaso_1.clone();
        int vetPiorCaso_4[] = vetPiorCaso_1.clone();



        long inicio, fim, tempoS, tempoMS;

        //////// ORDENAÇÃO RUIM ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetAleatorio_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Aleatorio: " + tempoS + "s" + tempoMS + "ms");


        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetMelhorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetPiorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        System.out.println("Os 3 Vetores:");
        exibirVetor(vetAleatorio_1, N);
        exibirVetor(vetMelhorCaso_1, N);
        exibirVetor(vetPiorCaso_1, N);


        System.out.println("  ");
        //////// ORDENAÇÃO MELHORADO ! /////////////////

        //////// COM I no lugar de N-1 ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoComJ(vetAleatorio_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado n-1) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoComJ(vetMelhorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado  n-1) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoComJ(vetPiorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado  n-1) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        System.out.println("Os 3 Vetores:");
        exibirVetor(vetAleatorio_2, N);
        exibirVetor(vetMelhorCaso_2, N);
        exibirVetor(vetPiorCaso_2, N);

        System.out.println("");
        //////// Verficando se vetor ja está ordenado ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoJaOrdenado(vetAleatorio_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado ja ord) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoJaOrdenado(vetMelhorCaso_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado ja ord) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoJaOrdenado(vetPiorCaso_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado ja ord) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        System.out.println("Os 3 Vetores:");
        exibirVetor(vetAleatorio_3, N);
        exibirVetor(vetMelhorCaso_3, N);
        exibirVetor(vetPiorCaso_3, N);

        System.out.println("");
        //////// Comendo de fora pra dentro ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoOrdenandoComMenorEMaior(vetAleatorio_4, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado de fora pra dentro) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoOrdenandoComMenorEMaior(vetMelhorCaso_4, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado de fora pra dentro) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhoradoOrdenandoComMenorEMaior(vetPiorCaso_4, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado de fora pra dentro) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        System.out.println("Os 3 Vetores:");
        exibirVetor(vetAleatorio_4, N);
        exibirVetor(vetMelhorCaso_4, N);
        exibirVetor(vetPiorCaso_4, N);



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

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a] = vet[b];
        vet[b] = aux;
    }

    private static void ordenar(int[] vet, int N) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(vet[j]>vet[j+1])
                    troca(vet, j, j+1);
            }
        }
    }

    private static void ordenarMelhoradoComJ(int[] vet, int N) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1-i; j++){
                if(vet[j]>vet[j+1])
                    troca(vet, j, j+1);
            }
        }
    }

    private static void ordenarMelhoradoJaOrdenado(int[] vet, int N) {
        for(int i=0; i<N; i++){
            boolean foiAlterado = false;
            for(int j=0; j<N-1-i; j++){
                if(vet[j]>vet[j+1]) {
                    troca(vet, j, j + 1);
                    foiAlterado = true;
                }
            }
            if(!foiAlterado) return;
        }
    }

    private static void ordenarMelhoradoOrdenandoComMenorEMaior(int[] vet, int N) {
        for(int i=0; i<N; i++){
            int menorNumeroEncontrado = 0;
            boolean foiAlterado = false;
            for(int j=0; j<N-1-i; j++){
                if(vet[j]>vet[j+1]) {
                    if (menorNumeroEncontrado < vet[j+1]) {
                        menorNumeroEncontrado = vet[j+1];
                    }

                    troca(vet, j, j + 1);
                    foiAlterado = true;
                }  else {
                    menorNumeroEncontrado = vet[j];
                }

            }
            System.out.println(menorNumeroEncontrado);

            if(!foiAlterado) return;
        }
    }




}
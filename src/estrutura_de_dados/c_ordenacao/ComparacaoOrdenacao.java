package estrutura_de_dados.c_ordenacao;

public class ComparacaoOrdenacao {

    public static void main(String[] args) {
        int[] tamanhos = {5000, 10000, 30000, 50000, 100000, 200000};

        for (int N : tamanhos) {
            System.out.println("\n===================================");
            System.out.println("  N = " + N);
            System.out.println("======================================");

            int[] baseAleatorio = new int[N];
            int[] baseMelhor    = new int[N];
            int[] basePior      = new int[N];
            inicializarVetor(baseAleatorio, N, 0);
            inicializarVetor(baseMelhor,    N, 1);
            inicializarVetor(basePior,      N, 2);

            System.out.println();
            // BubbleSort
            System.out.println("BubbleSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "bubble");

            // SelectionSort
            System.out.println("SelectionSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "selection");

            // InsertionSort
            System.out.println("InsertionSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "insertion");

            // MergeSort
            System.out.println("MergeSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "merge");

            // HeapSort
            System.out.println("HeapSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "heap");

            // CountingSort
            System.out.println("CountingSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "counting");

            // QuickSort
            System.out.println("QuickSort:");
            medir(baseAleatorio.clone(), baseMelhor.clone(), basePior.clone(), N, "quick");
        }
    }

    private static void medir(int[] al, int[] me, int[] pi, int N, String tipo) {
        long inicio, fim, total;

        inicio = System.currentTimeMillis();
        executar(tipo, al, N);
        fim    = System.currentTimeMillis();
        total  = fim - inicio;
        System.out.println("  Aleatorio:     " + total / 1000 + "s " + total % 1000 + "ms");

        inicio = System.currentTimeMillis();
        executar(tipo, me, N);
        fim    = System.currentTimeMillis();
        total  = fim - inicio;
        System.out.println("  Ja ordenado:   " + total / 1000 + "s " + total % 1000 + "ms");

        inicio = System.currentTimeMillis();
        executar(tipo, pi, N);
        fim    = System.currentTimeMillis();
        total  = fim - inicio;
        System.out.println("  Ordem inversa: " + total / 1000 + "s " + total % 1000 + "ms");
        System.out.println();
    }

    private static void executar(String tipo, int[] vet, int N) {
        switch (tipo) {
            case "bubble":    bubbleSort(vet, N);          break;
            case "selection": selectionSort(vet, N);       break;
            case "insertion": insertionSort(vet, N);       break;
            case "merge":     mergeSort(vet, 0, N - 1);   break;
            case "heap":      heapSort(vet, N);            break;
            case "counting":  countingSort(vet, N);        break;
            case "quick":     quickSort(vet, 0, N - 1);   break;
        }
    }

    static void inicializarVetor(int[] vet, int N, int s) {
        switch (s) {
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int) (Math.random() * (N * 2));
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i + 1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N - i;
                break;
        }
    }

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a]  = vet[b];
        vet[b]  = aux;
    }

    private static void bubbleSort(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            boolean foiAlterado = false;
            int menorNumeroEncontrado = N;
            int indiceDoMenorNumero   = -1;
            for (int j = i; j < N - 1 - i; j++) {
                if (vet[j] >= vet[j + 1]) {
                    troca(vet, j, j + 1);
                    foiAlterado = true;
                }
                if (vet[j] < menorNumeroEncontrado) {
                    menorNumeroEncontrado = vet[j];
                    indiceDoMenorNumero   = j;
                }
            }
            if (indiceDoMenorNumero != i && indiceDoMenorNumero != -1) {
                int tmp              = vet[i];
                vet[i]               = vet[indiceDoMenorNumero];
                vet[indiceDoMenorNumero] = tmp;
            }
            if (!foiAlterado) return;
        }
    }

    private static void selectionSort(int[] vet, int N) {
        for (int i = 0; i < N - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (vet[j] < vet[minIdx])
                    minIdx = j;
            }
            troca(vet, i, minIdx);
        }
    }

    private static void insertionSort(int[] vet, int N) {
        for (int i = 1; i < N; i++) {
            int chave  = vet[i];
            int j      = i - 1;
            while (j >= 0 && vet[j] > chave) {
                vet[j + 1] = vet[j];
                j--;
            }
            vet[j + 1] = chave;
        }
    }

    private static void mergeSort(int[] vet, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(vet, esq, meio);
            mergeSort(vet, meio + 1, dir);
            merge(vet, esq, meio, dir);
        }
    }

    private static void merge(int[] vet, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = vet[esq + i];
        for (int j = 0; j < n2; j++) R[j] = vet[meio + 1 + j];

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) vet[k++] = L[i++];
            else               vet[k++] = R[j++];
        }
        while (i < n1) vet[k++] = L[i++];
        while (j < n2) vet[k++] = R[j++];
    }

    private static void heapSort(int[] vet, int N) {
        // constroi o max-heap
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(vet, N, i);

        // extrai elementos do heap um por um
        for (int i = N - 1; i > 0; i--) {
            troca(vet, 0, i);
            heapify(vet, i, 0);
        }
    }

    private static void heapify(int[] vet, int N, int i) {
        int maior = i;
        int esq   = 2 * i + 1;
        int dir   = 2 * i + 2;

        if (esq < N && vet[esq] > vet[maior]) maior = esq;
        if (dir < N && vet[dir] > vet[maior]) maior = dir;

        if (maior != i) {
            troca(vet, i, maior);
            heapify(vet, N, maior);
        }
    }

    private static void countingSort(int[] vet, int N) {
        int max = vet[0];
        for (int i = 1; i < N; i++)
            if (vet[i] > max) max = vet[i];

        int[] contagem = new int[max + 1];
        for (int i = 0; i < N; i++)
            contagem[vet[i]]++;

        int idx = 0;
        for (int i = 0; i <= max; i++)
            while (contagem[i]-- > 0)
                vet[idx++] = i;
    }

    private static void quickSort(int[] vet, int esq, int dir) {
        if (esq < dir) {
            int p = particionar(vet, esq, dir);
            quickSort(vet, esq, p - 1);
            quickSort(vet, p + 1, dir);
        }
    }

    private static int particionar(int[] vet, int esq, int dir) {
        int meio = esq + (dir - esq) / 2;
        troca(vet, meio, dir);

        int pivot = vet[dir];
        int i     = esq - 1;

        for (int j = esq; j < dir; j++) {
            if (vet[j] <= pivot) {
                i++;
                troca(vet, i, j);
            }
        }
        troca(vet, i + 1, dir);
        return i + 1;
    }
}

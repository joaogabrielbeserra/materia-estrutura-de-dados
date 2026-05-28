package estrutura_de_dados.j_arvores_binarias;



public class AtividadeInicial {
    static NoA inicio = null;


    static void main(String[] args) {
        inserir(1);
        inserir(2);
        inserir(3);
        inserir(4);
        inserir(5);
        inserir(6);
        inserir(7);



        exibeArvore(inicio);

        mostrarFB(inicio);

        System.out.println(ehAVL(inicio));





    }


    static void inserir(int numero){
        NoA novo = new NoA(numero);

        if(inicio == null) {
            inicio = novo;
        } else {
            boolean inseriu = false;
            NoA temp = inicio;

            while (!inseriu) {
                if(temp.valor >= novo.valor) {
                    if(temp.esq == null) {
                        temp.esq = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                } else {
                    if(temp.dir == null) {
                        temp.dir = novo;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }
                }
            }
        }

    }

    public static void exibeArvore(NoA raiz) {
        if (isVazio(raiz)) {
            System.out.println("(árvore vazia)");
            return;
        }

        if (!isVazio(raiz.dir)) {
            exibeArvoreVisual(raiz.dir, "", false);
        }

        System.out.println(raiz.valor);

        if (!isVazio(raiz.esq)) {
            exibeArvoreVisual(raiz.esq, "", true);
        }
    }

    public static void exibeArvoreVisual(NoA no, String prefixo, boolean ehEsquerdo) {
        if (isVazio(no)) {
            return;
        }

        if (!isVazio(no.dir)) {
            exibeArvoreVisual(
                    no.dir,
                    prefixo + (ehEsquerdo ? "│ " : " "),
                    false
            );
        }

        System.out.println(prefixo + (ehEsquerdo ? "└── " : "┌── ") + no.valor);

        if (!isVazio(no.esq)) {
            exibeArvoreVisual(
                    no.esq,
                    prefixo + (ehEsquerdo ? " " : "│ "),
                    true
            );
        }
    }

    static boolean isVazio(NoA no) {
        if (no == null) { return true; }
        else return false;
    }

    static int maior(NoA temp) {
        do {
            temp = temp.esq;
        } while (temp.esq != null);
        return temp.valor;
    }

    static int menor(NoA temp) {
        do {
            temp = temp.dir;
        } while (temp.dir != null);
        return temp.valor;
    }

    static void exibirFolhas(NoA temp){
        if(temp != null){
            if (ehFolha(temp)) {
                System.out.print(temp.valor + " ");
            }
            exibirFolhas(temp.esq);
            exibirFolhas(temp.dir);
        }

    }
    static int profundidade(NoA temp) {
        if(temp != null){
            if(ehFolha(temp))
                return 0;
            else{
                int x = profundidade(temp.esq);
                int y = profundidade(temp.dir);
                int r = (x>y)? x : y;
                return r+1;
            }
        }
        return -1;
    }

    static boolean ehFolha(NoA temp) {
        if((temp.esq == null) && (temp.dir==null))
            return true;
        return false;
    }

    static void insereExclusivo(NoA novo) {

    }

    static int contaFilhos(NoA n, int x) {
        if (n == null) return -1;

        if (n.valor == x) {
            int filhos = 0;
            if (n.esq != null) filhos++;
            if (n.dir != null) filhos++;
            return filhos;
        }

        int resultado = contaFilhos(n.esq, x);
        if (resultado != -1) return resultado;

        return contaFilhos(n.dir, x);
    }

    static boolean existe(int x) {
        NoA temp = inicio;
        while (temp != null) {
            if (temp.valor == x) return true;
            temp = (x < temp.valor) ? temp.esq : temp.dir;
        }
        return false;
    }

    public static void mostrarFB(NoA n) {
        if (n != null) {
            mostrarFB(n.esq);
            System.out.println(n.valor + " -> FB = " + fatorBalanceamento(n));
            mostrarFB(n.dir);
        }
    }

    public static int fatorBalanceamento(NoA n) {
        if (n == null) return 0;
        return altura(n.esq) - altura(n.dir);
    }

    private static int altura(NoA n) {
        if (n == null) return -1;
        return 1 + Math.max(altura(n.esq), altura(n.dir));
    }

    public static boolean ehAVL(NoA n) {
        if (n == null) return true;

        int fb = fatorBalanceamento(n);
        if (fb < -1 || fb > 1) return false;

        return ehAVL(n.esq) && ehAVL(n.dir);
    }

    public static NoA girarDireita(NoA x){
        NoA y = x.esq; //Seja Y o filho à esquerda de X
        x.esq = y.dir; // Torne o filho à direita de Y o filho à esquerda de X.
        y.dir = x; // Torne X o filho à direita de Y
        return y;
    }

    public static NoA girarEsquerda(NoA x){
        NoA y = x.dir; //Seja Y o filho à direita de X
        x.dir = y.esq; // Torne o filho à esquerda de Y o filho à direita de X.
        y.esq = x; // Torne X o filho à esquerda de Y
        return y;
    }

    public static void rodar(int valor, int direcao) {
        // caso especial: o nó a rodar é a própria raiz
        if (inicio != null && inicio.valor == valor) {
            if (direcao == 1) {
                inicio = girarDireita(inicio);
            } else {
                inicio = girarEsquerda(inicio);
            }
            return;
        }

        // busca o pai do nó alvo
        NoA pai = buscarPai(inicio, valor);
        if (pai == null) return; // valor não existe na árvore

        if (pai.esq != null && pai.esq.valor == valor) {
            // o nó alvo é filho esquerdo do pai
            pai.esq = (direcao == 1) ? girarDireita(pai.esq) : girarEsquerda(pai.esq);
        } else {
            // o nó alvo é filho direito do pai
            pai.dir = (direcao == 1) ? girarDireita(pai.dir) : girarEsquerda(pai.dir);
        }
    }

    private static NoA buscarPai(NoA atual, int valor) {
        if (atual == null) return null;

        boolean filhoEsqBate = (atual.esq != null && atual.esq.valor == valor);
        boolean filhoDirBate = (atual.dir != null && atual.dir.valor == valor);
        if (filhoEsqBate || filhoDirBate) return atual;

        NoA resultado = buscarPai(atual.esq, valor);
        if (resultado != null) return resultado;

        return buscarPai(atual.dir, valor);
    }






}


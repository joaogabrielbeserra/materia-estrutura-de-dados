package estrutura_de_dados.j_arvores_binarias;



public class AtividadeInicial {
    static NoA inicio = null;


    static void main(String[] args) {
        inserir(50);
        inserir(20);
        inserir(70);
        inserir(55);
        inserir(14);
        inserir(12);
        inserir(116);
        inserir(15);

        exibirFolhas(inicio);



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

    static void exibir(NoA temp){
        if(temp != null){
            exibir(temp.esq);
            System.out.print(temp.valor + " ");
            exibir(temp.dir);
        }
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




    }


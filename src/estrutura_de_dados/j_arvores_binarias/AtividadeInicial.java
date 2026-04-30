package estrutura_de_dados.j_arvores_binarias;



public class AtividadeInicial {
    static NoA inicio = null;


    static void main(String[] args) {
        inserir(10);
        exibirTudoEsquerdaPraDireita();




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
                    if(temp.esquerda == null) {
                        temp.esquerda = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esquerda;
                    }
                } else {
                    if(temp.direita == null) {
                        temp.direita = novo;
                        inseriu = true;
                    } else {
                        temp = temp.direita;
                    }
                }
            }
        }

    }

    static void exibirTudoEsquerdaPraDireita() {




        if (inicio == null) {
            System.out.println("arvore vazia");
        } else if (inicio.esquerda == null && inicio.direita == null) {
            System.out.println(inicio.valor);
        } else {
            NoA temp = inicio;
            System.out.println(temp.valor);

            while (temp.direita != inicio) {
                if() {
                    System.out.println(temp.valor);


                }
            }


            }
        }



    }


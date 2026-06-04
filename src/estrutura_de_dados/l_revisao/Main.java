package estrutura_de_dados.l_revisao;


//Métodos para inserir:
//Tema: Árvore binaria - métodos basicos
// - [X] inserir(int) (inserir na arvore binaria)
// - [X] exibir() (sem recursividade, cada valor uma linha)
// - [X] exibir() (bonito, forma gráfica)
// - [X] Crie o método int maior(NoA) que retorna o maior valor que existe na árvore
// - [X] Crie o método int menor(NoA) que retorna o menor valor que existe na árvore
// - [X] Crie o método void exibeFolhas(NoA) que exibe todas as folhas da árvore em ordem crescente
// - [X] Crie o método int profundidade(NoA) que retorna a profundidade da árvore
// - [X] Crie o método int tamanho(NoA) que retorna a quantidade de nós existente na árvore
//Tema: Árvore binaria - métodos remoção
// - [X] Crie o método void insereExclusivo(int x) que realiza a inserção somente de valores que ainda não existem na árvore
// - [X] Crie o método boolean existe(int x) que retorna true caso já exista um nó na árvore com o valor x e false caso não exista (auxiliar)
// - [X] Crie método recursivo int contaFilhos(NoA n, int x) que retorna o número de filhos do nó que possui o valor x:
//      - retorna -1 caso não exista na árvore nenhum nó com o valor x
//      - retorna 0 caso o o nó que possui o valor x não possua filhos (folha)
//      - retorna 1 caso o nó que possui o valor x tenha um único filho
//      - retorna 2 caso o nó que possui o valor x tenha dois filhos
// - [] removeFolha(temp, x);
// - [] removeUmFilho(temp, x);
// - [] removeDoisFilhos(temp, x);
// - exemplo
//```
//static void removeNo(NoA n, int x){
//
//    int f = contaFilhos(n,x);
//
//    switch(f){
//        case -1: System.out.println("O nó não existe na árvore"); break;
//        case  0: removeFolha(n,x); break;
//        case  1: removeUmFilho(n,x); break;
//        case  2: removeDoisFilhos(n,x); break;
//    }
//}
//```
//tema: Desafio termo
// - [] Desafio termo
//tema: Balanceamento de Árvores Binárias
// - [] Implemente um método recursivo que exibe o valor e o fator de balanceamento para todos os nós da árvore.
// - [] Verificar se a árvore inteira é AVL
// - [] Implementar o método que calcula e retorna o fator de balanceamento de um nó
// - [] Implementar o método que faz a rotação sobre o nó com o valor passado por parâmetro. A rotação será à esquerda caso o segundo parâmetro seja -1 e à direita caso o segundo parâmetro seja 1
//
//        - métodos de giro:
//        ```
//public static NoA girarDireita(NoA x){
//    NoA y = x.esq; //Seja Y o filho à esquerda de X
//    x.esq = y.dir; // Torne o filho à direita de Y o filho à esquerda de X.
//    y.dir = x; // Torne X o filho à direita de Y
//    return y;
//}
//
//public static NoA girarEsquerda(NoA x){
//    NoA y = x.dir; //Seja Y o filho à direita de X
//    x.dir = y.esq; // Torne o filho à esquerda de Y o filho à direita de X.
//    y.esq = x; // Torne X o filho à esquerda de Y
//    return y;
//}
//```
//tema: Exercícios e preparação para avaliação
// - [] Questão, necessário pegar no ecad. https://ecad.ifspcaraguatatuba.edu.br/mod/page/view.php?id=260117
//        - [] Entender sobre rotações:
//        - Simples à direita
//	- Simples à esquerda
//	- Dupla à direita
//	- Dupla à esquerda
// - [] Crie um método balancear que dada uma árvore qualquer (não AVL) faça com que a mesma se torne AVL somente percorrendo-a e fazendo as rotações conforme necessário.

import estrutura_de_dados.j_arvores_binarias.NoA;

public class Main {
    static NoArv inicio = null;

    static void main(String[] args) {



        inserir( 20);
        inserir(10 );
        inserir( 30);
        inserir( 45);
        inserir( 25);
        inserir( 8);
        inserir( 12);



        exibeArvore(inicio);

        System.out.print("Maior número da arvore: "); exibeMaior(inicio);
        System.out.print("Menor número da arvore: "); exibeMenor(inicio);
        System.out.print("Folhas em ordem crescente: "); exibeFolhas(inicio); System.out.println("");
        System.out.println("Profundidade da arvore: " + profundidade(inicio));
        System.out.println("tamanho da arvore: " + tamanho(inicio));
        System.out.println("10 ja existe na arvore? " + existe(10));
        System.out.print("Testando insereExclusivo: "); insereExclusivo(10);
        System.out.print("Testando conta folhas: "); System.out.println(contaFilhos(inicio, 20));

    }

    static void inserir( int valor){
        NoArv novo = new NoArv(valor);

        if(inicio == null) {
            inicio = novo;
        } else {
            boolean inseriu = false;
            NoArv temp = inicio;

            while(!inseriu) {
                if(novo.valor > temp.valor ){
                    if(temp.dir == null) {
                        temp.dir = novo;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }
                } else {
                    if(temp.esq == null) {
                        temp.esq = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                }
            }
        }
    }

    static void exibeArvore(NoArv raiz) {
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

    static void exibeArvoreVisual(NoArv no, String prefixo, boolean ehEsquerdo) {
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

    static boolean isVazio(NoArv no) {
        if (no == null) { return true; }
        else return false;
    }

    static void exibeMaior(NoArv inicio) {
        NoArv temp = inicio;
        while(temp.dir != null) {
            temp = temp.dir;
        }
        System.out.println(temp.valor);
    }

    static void exibeMenor(NoArv inicio) {
        NoArv temp = inicio;
        while(temp.esq != null) {
            temp = temp.esq;
        }
        System.out.println(temp.valor);
    }

    static void exibeFolhas(NoArv temp) {
        if (temp != null) {
            exibeFolhas(temp.esq);
            if(ehFolha(temp)) {
                System.out.print(temp.valor + " ");
            }
            exibeFolhas(temp.dir);
        }
    }

    static boolean ehFolha(NoArv temp) {
        if((temp.esq == null) && (temp.dir==null))
            return true;
        return false;
    }

    static int profundidade(NoArv temp) {
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

    static int tamanho(NoArv temp) {
        if(temp != null)
            return 1+tamanho(temp.esq)+tamanho(temp.dir);

        return 0;
    }

    static boolean existe(int x) {
        NoArv temp = inicio;
        while (temp != null) {
            if (x == temp.valor)
                return true;
            else if (x > temp.valor)
                temp = temp.dir;
            else
                temp = temp.esq;
        }
        return false;
    }

    static void insereExclusivo(int x) {
        NoArv novo = new NoArv(x);

        if(!existe(novo.valor)){
            inserir(x);
            System.out.println(novo.valor + " é exclusivo");
        } else {
            System.out.println(novo.valor + " n é exclusivo");
        }
    }

    static int contaFilhos(NoArv n, int x) {
        if (!existe(x))
            return -1;

        NoArv temp = n;
        while (temp != null) {
            if (temp.valor == x) {
                int count = 0;
                if (temp.dir != null) count++;
                if (temp.esq != null) count++;
                return count;
            }
            if (x > temp.valor)
                temp = temp.dir;
            else
                temp = temp.esq;
        }
        return -1;
    }


}

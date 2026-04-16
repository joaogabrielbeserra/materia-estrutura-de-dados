package estrutura_de_dados.i_exercicios_pre_prova;


public class Centro {

    static NoFloat inicio = null;


    static void main(String[] args) {

        float N = 1;


        for (int i = 1; i <= N; i++) {
            inserirInicio(i);
        }

        exibir();
        centro();

    }

    static void inserirInicio(float x) {
        NoFloat novo = new NoFloat(x);
        if (inicio == null) {
            inicio = novo;
            novo.prox = inicio;
            novo.ant = inicio;
        } else {
            NoFloat ultimo = inicio.ant;
            novo.prox = inicio;
            novo.ant = ultimo;
            ultimo.prox = novo;
            inicio.ant = novo;
            inicio = novo;
        }
    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }
        NoFloat temp = inicio;
        System.out.print("Lista: ");
        do {
            System.out.print("[" + temp.valor + "] ");
            temp = temp.prox;
        } while (temp != inicio);
        System.out.println("(Circular)");
    }


    static void centro() {
        NoFloat antiHorario = inicio.ant;
        NoFloat horario = inicio;

        while(true){
            if(antiHorario.ant == horario.prox) {
                System.out.println(antiHorario.ant.valor);
                break;
            } else if (antiHorario.ant == horario.prox.prox) {
                System.out.println((antiHorario.ant.valor + horario.prox.valor) / 2 );
                break;
            }

            antiHorario = antiHorario.ant;
            horario = horario.prox;

        }
    }
}

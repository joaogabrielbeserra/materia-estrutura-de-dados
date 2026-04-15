package estrutura_de_dados.f_listas_ligadas_circulares;

public class Main {

    static void main(String[] args) {
        ListaLigadaCircular ex = new ListaLigadaCircular();

        ex.exibir();

        ex.inserirLast(1);
        ex.inserirLast(2);
        ex.inserirLast(3);
        ex.inserirLast(4);
        ex.inserirLast(5);


        ex.exibir();
        ex.removerLast();
        ex.exibir();
        ex.removerInit();
        ex.exibir();

        ex.inserirInit(0);
        ex.exibir();
        ex.inserirInit(11);
        ex.exibir();





    }

}

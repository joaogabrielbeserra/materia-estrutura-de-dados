package estrutura_de_dados.a_exercicios_diagnosticos.atividade_reposicao;

import java.util.ArrayList;


public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();

    public Cardapio() {
        lanches.add(new Lanche("X-Burguer", 18.5));
        lanches.add(new Lanche("X-Salada", 20.0));
        lanches.add(new Lanche("X-Tudo", 25.0));
        lanches.add(new Lanche("X-Gaúcho", 100.0));
    }

    public ArrayList<Lanche> getLanches() {
        System.out.println("Lanches, selecione inserindo o número correspondente e dando enter: ");
        for (int i = 0; i < lanches.size(); i++) {
            System.out.print(i + " " );
            lanches.get(i).mostrarLanche();

        }
        return lanches;
    }


}

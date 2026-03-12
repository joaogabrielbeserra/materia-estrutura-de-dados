package estrutura_de_dados.a_exercicios_diagnosticos.atividade_reposicao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    ArrayList<Lanche> lanches = new ArrayList<>();
    int quantidade;


    public Pedido(Cliente cliente, ArrayList<Lanche> lanches) {
        this.cliente = cliente;
        this.lanches = lanches;

    }

    public void adicionarLancheAoPedido (Lanche lanche, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            lanches.add(lanche);
        }
    }


    public double calcularTotal() {
        double precoTotal = 0;
        for(Lanche lanche : lanches) {
            precoTotal = precoTotal + lanche.getPreco();
        }
        return precoTotal;


    }

    public double aplicarDesconto(double valorTotal, double desconto) {
        return valorTotal - (desconto/100 * valorTotal);
    }

    public void mostrarPedido() {
        System.out.println("Mostrando itens do atual pedido... ");
        this.cliente.mostrarCliente();
        System.out.println("Lanches do atual pedido: ");
        for (Lanche lanche : lanches) {
            lanche.mostrarLanche();
        }


    }
}

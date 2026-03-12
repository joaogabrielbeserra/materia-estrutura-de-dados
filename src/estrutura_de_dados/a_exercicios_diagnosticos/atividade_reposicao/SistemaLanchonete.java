package estrutura_de_dados.a_exercicios_diagnosticos.atividade_reposicao;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaLanchonete {

    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        Scanner sc = new Scanner(System.in);
        boolean pedidoEncerrado = false;
        System.out.print("Digite o nome do cliente do pedido por favor: ");
        String nomeCliente = sc.nextLine();

        Cliente clienteDoPedido = new Cliente(nomeCliente);

        ArrayList<Lanche> lanchesDoCardapio = cardapio.getLanches();
        System.out.print("Digite o número do lanche por favor: ");
        int numeroLanche = sc.nextInt();

        Lanche lancheDoPedido = new Lanche(
                lanchesDoCardapio.get(numeroLanche).getNome(),
                lanchesDoCardapio.get(numeroLanche).getPreco()
        );


        ArrayList<Lanche> lanchesDoPedido = new ArrayList<>();
        Pedido pedido = new Pedido(clienteDoPedido, lanchesDoPedido);

        System.out.print("Digite a quantidade desse Lanche no pedido por favor: ");
        int quantidade = sc.nextInt();

        pedido.adicionarLancheAoPedido(lancheDoPedido, quantidade);

        System.out.print("Você deseja incluir mais lanches no pedido? [0] nao | [1] sim: ");
        if (sc.next().equals("0")) {
            pedidoEncerrado = true;
        }

        sc.nextLine();


        while (!pedidoEncerrado) {
            pedido.mostrarPedido();
            System.out.println("Total do pedido atualmente: " + pedido.calcularTotal());


            cardapio.getLanches();
            System.out.print("Digite o número do novo lanche por favor: ");
            int numeroNovoLanche = sc.nextInt();


            Lanche lancheNovoDoPedido = new Lanche(lanchesDoCardapio.get(numeroNovoLanche).getNome(), lanchesDoCardapio.get(numeroNovoLanche).getPreco());

            System.out.print("Digite a quantidade desse novo Lanche no pedido por favor: ");
            int quantidadeNova = sc.nextInt();

            pedido.adicionarLancheAoPedido(lancheNovoDoPedido, quantidadeNova);

            System.out.print("Você deseja incluir mais lanches no pedido? [0] nao | [1] sim: ");
            if (sc.next().equals("0")) {
                pedidoEncerrado = true;
            }
        }

        System.out.println("Finalizando pedido...");
        pedido.mostrarPedido();
        System.out.println("Total do pedido: " + pedido.calcularTotal());
        boolean desconto = false;

        System.out.print("você é amigo do dono? [0] nao | [1] sim: ");
        if (sc.next().equals("1")) {
            desconto = true;
        }

        if(desconto){
            System.out.print("qual o valor do desconto em %? : ");
            double valorDesconto = sc.nextDouble();
            System.out.println("Total do pedido com descontos : " + pedido.aplicarDesconto(pedido.calcularTotal(), valorDesconto));
            System.out.println("Valor com imposto de 47%: "+ (pedido.aplicarDesconto(pedido.calcularTotal(), valorDesconto) + ((pedido.aplicarDesconto(pedido.calcularTotal(), valorDesconto))*0.47)));

        } else {
            System.out.println("Valor com imposto de 47%: "+ (pedido.calcularTotal() + (pedido.calcularTotal()*0.47)));

        }






    }
}


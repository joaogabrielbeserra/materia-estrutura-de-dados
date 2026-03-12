package estrutura_de_dados.a_exercicios_diagnosticos.atividade_reposicao;

public class Lanche {
    private String nome;
    private double preco;


    public Lanche(String nome,  double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }
    public void mostrarLanche(){
        System.out.print("Nome do Lanche: " + this.nome);
        System.out.println(" | Preço " + this.preco);
    }


}

package estrutura_de_dados.a_exercicios_diagnosticos.atividade_reposicao;

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void mostrarCliente(){
        System.out.println("Nome do cliente: " + this.nome);
    }
}

package estrutura_de_dados.i_exercicios_pre_prova;

public class NoLivro {

    NoLivro prox;
    NoLivro ant;
    String autores;
    String titulo;
    String edicao;
    String cidade;
    String editora;
    int ano;

    public NoLivro(String autores, String titulo, String edicao, String cidade, String editora, int ano) {
        this.autores = autores;
        this.titulo = titulo;
        this.edicao = edicao;
        this.cidade = cidade;
        this.editora = editora;
        this.ano = ano;
        this.ant = null;
        this.prox = null;
    }

}

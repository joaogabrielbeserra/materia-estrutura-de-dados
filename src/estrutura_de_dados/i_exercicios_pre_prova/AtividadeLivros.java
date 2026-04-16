package estrutura_de_dados.i_exercicios_pre_prova;

import estrutura_de_dados.i_exercicios_pre_prova.NoLivro;

import java.util.Scanner;

public class AtividadeLivros {

    static NoLivro inicio = null;

    public static void main(String[] args) {
        cadastrarLivro("LORENZI, F.; MATTOS, P. N.; CARVALHO, T. P.","Estruturas de dados","1ª edição","São Paulo","Thomson Learning",2007);
        cadastrarLivro("PEREIRA, S. L.","Estrutura de dados fundamentais: conceitos e aplicações","12ª edição","São Paulo","Érica",2008);
        cadastrarLivro("LAFORE, R.","Estrutura de dados & algoritmos em java","1ª edição","Rio de Janeiro","Ciência Moderna",2004);
        cadastrarLivro("SZWARCFITER, J. L.; MARKENZON, L.","Estruturas de dados e seus algoritmos","3ª edição","Rio de Janeiro","LTC",2010);
        cadastrarLivro("PREISS, B. R.","Estruturas de dados e algoritmos: pradrões de projetos orientados a objeto com java","1ª edição","Rio de Janeiro","Elsevier",2000);
        cadastrarLivro("WIRTH, N.","Algoritmos e estruturas de dados","1ª edição","Rio de Janeiro","LTC",2008);
        cadastrarLivro("CELES, W. ; CERQUEIRA, R.; RANGEL, J. L.","Introdução a estruturas de dados com técnicas de programação em C","1ª edição","Rio de Janeiro","Elsevier",2004);
        cadastrarLivro("GUIMARÃES, Â. M.; LAGES, N. A. C.","Algoritmos e estruturas de dados","1ª edição","Rio de Janeiro","LTC",2008);


        Scanner teclado = new Scanner(System.in);

        String opcao;

        NoLivro tmp = inicio;

        do{
            System.out.print("\nINFORME A OPÇÃO DESEJADA\n"
                    + "\"a\" para avançar\n"
                    + "\"r\" para retroceder\n"
                    + "\"d\" para detalhar\n"
                    + "\"s\" para sair\n"
                    + "ESCOLHA: ");

            opcao = teclado.nextLine();

            if(opcao.equals("a")){
                System.out.println("\nLIVRO ATUAL:");
                tmp = tmp.prox;
                System.out.println(tmp.titulo);
            }else if(opcao.equals("r")){
                System.out.println("\nLIVRO ATUAL");
                tmp = tmp.ant;
                System.out.println(tmp.titulo);
            }else if(opcao.equals("d")){
                System.out.println("\nLIVRO ATUAL DETALHADO");
                System.out.println(tmp.autores + " " + tmp.titulo + " " + tmp.edicao + " " + tmp.cidade + " " + tmp.edicao+ " " + tmp.ano);
            }



        }while(!opcao.equals("s"));

    }

    static void cadastrarLivro(String autores, String titulo, String edicao, String cidade, String editora, int ano) {
        NoLivro livroNovo = new NoLivro(autores,titulo,edicao,cidade,editora,ano);

        if (inicio == null) {
            inicio = livroNovo;
            inicio.prox = livroNovo;
            inicio.ant = livroNovo;
        } else {
            NoLivro ultimo = inicio.ant;

            livroNovo.prox = inicio;
            livroNovo.ant = ultimo;
            ultimo.prox = livroNovo;
            inicio.ant = livroNovo;
        }
        livroNovo.prox = inicio;
    }



}
package estrutura_de_dados.e_filhas_e_pilhas;

public class Pilha {
    private No topo; // topo é o nó de controle da lista o "início" da implementação anterior
    
    public Pilha(){
        this.topo = null;
    }
    
    public void empilhar(int x){
        No novo = new No(x);
        if (topo == null) {
                   topo = novo;

                } else if (topo.prox == null) {
                    topo.prox = novo;

                }    else {
                    No temp = topo;
                    No anterior = null;
                    while (temp != null) {
                        anterior = temp;
                        temp = temp.prox;
                    }
                    anterior.prox = novo;
                }
    }
    
    public void desempilhar(){
        No temp = topo;
        while (temp.prox != null) {
            temp = temp.prox;
        }

        
    }
    
    public int topo(){
        No temp = topo;
        while (temp.prox != null) {
            temp = temp.prox;

        }
        return temp.valor;
    }
    
    public boolean vazia(){
        if (topo == null) {
            return true;
        }
        return false;
    }
    
    public int tamanho(){
        
        return 0;
    }
    
    public void exibir(){
        if (topo == null) {
            System.out.println("A pilha está vazia painho");
        } else if (topo.prox == null) {
            System.out.println(topo.valor);
        }   else   {
            exibirRecursivoNoFormatoDaPilha(this.topo);
        }
    }

    private void exibirRecursivoNoFormatoDaPilha(No atual) {
        if (atual == null) {
            return;
        }

        // primeiro chama o próximo (mergulha na pilha)
        exibirRecursivoNoFormatoDaPilha(atual.prox);

        // na volta da recursão, imprime o valor (ordem inversa)
        System.out.println(atual.valor);
    }
}


    


package classes;

import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class Pilha implements Pilha_IF {

    private No topo;
    private int tamanho;

    private class No {
        Filme_IF elemento;
        No proximo;
        No anterior;

        public No(Filme_IF elemento){
            this.elemento = elemento;
        }
    }

    public Pilha (){
        topo = null;
        tamanho = 0;
    }

    @Override
    public Filme_IF pop() throws Exception {
        if (isEmpty()){
            throw new Exception("A pilha está vazia.");
        }
        Filme_IF elementoRemovido = topo.elemento;
        topo = topo.anterior;
        if (topo != null){
            topo.proximo = null;
        }
        tamanho--;
        return elementoRemovido;
    }

    @Override
    public void push(Filme_IF elemento) {

        No novoNo = new No(elemento); //o novo elemento que será empilhado.

        if (isEmpty()){
            topo = novoNo; //se a pilha estiver vazia não tem elementos para serem ligados então so é definido o topo.
        } else {
            novoNo.anterior = topo; //aqui caso exista um ou mais elementos, ligamos o novo nó ao topo da pilha
            topo.proximo = novoNo; // ligamos o topo da pilha ao novo nó, e por fim atualizamos o valor do topo.
            topo = novoNo;
        }
        tamanho++; //como um elemento foi inserido a pilha aumenta em 1.
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    @Override
    public Filme_IF top() throws Exception {

        if (isEmpty()){
            throw new Exception("A pilha está vazia.");
        }

        return topo.elemento;
    }
}

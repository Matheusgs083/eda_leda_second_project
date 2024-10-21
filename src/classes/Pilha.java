package classes;

import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class Pilha implements Pilha_IF {

    private Node top;
    private int tamanho;



    public Pilha (){
        top = null;
        tamanho = 0;
    }

    @Override
    public Filme_IF pop() throws Exception {
        if (isEmpty()){
            throw new Exception("A pilha está vazia.");
        }
        Filme_IF elementoRemovido = top.film;
        top = top.left;
        if (top != null){
            top.right = null;
        }
        tamanho--;
        return elementoRemovido;
    }

    @Override
    public void push(Filme_IF elemento) {

        Node newNode = new Node(elemento); //o novo elemento que será empilhado.

        if (isEmpty()){
            top = newNode; //se a pilha estiver vazia não tem elementos para serem ligados então so é definido o topo.
        } else {
            newNode.left = top; //aqui caso exista um ou mais elementos, ligamos o novo nó ao topo da pilha
            top.right = newNode; // ligamos o topo da pilha ao novo nó, e por fim atualizamos o valor do topo.
            top = newNode;
        }
        tamanho++; //como um elemento foi inserido a pilha aumenta em 1.
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Filme_IF top() throws Exception {

        if (isEmpty()){
            throw new Exception("A pilha está vazia.");
        }

        return top.film;
    }
}

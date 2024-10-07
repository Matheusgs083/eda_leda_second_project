package classes;

import interfaces.Fila_IF;
import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class Fila implements Fila_IF {

    private Pilha_IF pilha1;
    private Pilha_IF pilha2;

    public Fila(){
        pilha1 = new Pilha();
        pilha2 = new Pilha();
    }

    @Override
    public Filme_IF dequeue() throws Exception {
        if (pilha2.isEmpty()){
            while (!pilha1.isEmpty()){
                pilha2.push(pilha1.pop()); //Enquanto a pilha1 não estiver vazia a pilha2 inverte.
            }                              //Ex: p1 {1,2,3} e p2 {3,2,1}. Agora a pilha está enfileirada
        }                                  //ao usar o pilha2.pop o elemento "1" que foi inserido primeiro
                                           //na pilha1 agora será o primeiro a sair na pilha2.
        if (pilha2.isEmpty()){
            throw new Exception("A fila está vazia.");
        }

        return pilha2.pop();
    }

    @Override
    public void enqueue(Filme_IF elemento) {
        pilha1.push(elemento);
    }

    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty() && pilha2.isEmpty();
    }

    @Override
    public Filme_IF head() throws Exception {

        if (pilha2.isEmpty()){
            while (!pilha1.isEmpty()){
                pilha2.push(pilha1.pop()); //Inverte a ordem da pilha 1 na pilha 2. Mesmo procedimento
            }                              //do dequeue
        }

        if (pilha2.isEmpty()){
            throw new Exception("A fila está vazia.");
        }

        return pilha2.top();
    }
}

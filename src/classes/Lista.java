package classes;

import interfaces.Filme_IF;
import interfaces.Lista_IF;

public class Lista implements Lista_IF {

    private Node head;
    private Node tail;
    private int size;


    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public Filme_IF remove(long id) throws Exception {
        Node current = head;
        Node previous = null;

        while (current != null && current.film.getID() != id) {
            previous = current;
            current = current.right;
        }

        if (current == null) {
            return null;
        }

        if (previous == null) {
            head = current.right;
        } else {
            previous.right = current.right;
        }

        return current.film;
    }

    //Levando em conta que só tem um insert, o filme é adicionado no final da lista.
    @Override
    public void insert(Filme_IF elemento) {
        Node newNode = new Node(elemento);

        if(isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            this.tail.right = newNode;
            newNode.left = tail;
            this.tail = newNode;
        }
        this.size += 1;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (id < 0 || id >= size)
            throw new Exception("Fora do escopo da lista.");

        Node aux = this.head;

        for (int i = 0; i < id; i++)
            aux = aux.right;

        return aux.film;
    }

    @Override
    public Filme_IF head() throws Exception {
        if (isEmpty()) throw new Exception();
        return this.head.film;
    }

    @Override
    public Filme_IF tail() throws Exception {
        if (isEmpty()) throw new Exception();
        return this.tail.film;
    }

    @Override
    public int size() {
        return this.size;
    }

    //MÉTODOS / FUNÇÕES CRIADAS QUE NÃO ESTAVAM NO ESCOPO DA INTERFACE.

    public Filme_IF removeFirst() throws Exception {
        if (isEmpty()) throw new Exception();

        Filme_IF v = this.head.film;

        if (this.head.right == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.right;
            this.head.left = null;
        }

        size -= 1;
        return v;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public Filme_IF removeLast() throws Exception {
        if (isEmpty()) throw new Exception("Está vazia.");

        Filme_IF v = this.tail.film;

        if (this.head.right == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.left;
            this.tail.right = null;
        }

        size -= 1;
        return v;
    }

    public Node getHead() {
        return this.head;
    }
}

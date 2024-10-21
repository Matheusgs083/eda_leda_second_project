package classes;

import interfaces.Filme_IF;

public class Node {
    Filme_IF film;
    Node right;
    Node left;

    public Node(Filme_IF film){
        this.film = film;
        right = left = null;
    }
}

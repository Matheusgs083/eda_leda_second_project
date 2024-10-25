import classes.*;
import interfaces.*;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Criando filmes com valores definidos (não aleatórios)
        Filme_IF filme1 = new Filme("Era do Gelo", 4, 2002);
        Filme_IF filme2 = new Filme("Piratas do Caribe", 5, 2003);
        Filme_IF filme3 = new Filme("Rei Leão", 3, 1994);
        Filme_IF filme4 = new Filme("Velozes e Furiosos", 4, 2001);
        Filme_IF filme5 = new Filme("Mad Max", 5, 2015);

        // Inserindo os filmes na árvore BST
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);
        bst.insert(filme4);
        bst.insert(filme5);

        // Imprimindo os filmes inseridos
        System.out.println("Filmes inseridos:");
        System.out.println(filme1);
        System.out.println(filme2);
        System.out.println(filme3);
        System.out.println(filme4);
        System.out.println(filme5);

        Filme_IF[] preOrderArray = bst.preOrder();
        System.out.println("\nTravessia Pré-Ordem:");
        for (Filme_IF filme : preOrderArray) {
            System.out.println(filme);
        }

        Filme_IF[] postOrderArray = bst.postOrder();
        System.out.println("\nTravessia Post-Ordem:");
        for (Filme_IF filme : postOrderArray) {
            System.out.println(filme);
        }

        Filme_IF[] OrderArray = bst.order();
        System.out.println("\nTravessia In-Ordem:");
        for (Filme_IF filme : OrderArray) {
            System.out.println(filme);
        }
    }
}


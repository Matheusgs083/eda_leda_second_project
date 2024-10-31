package classes;

import interfaces.BST_IF;
import interfaces.Filme_IF;

import java.util.Scanner;

public class BST implements BST_IF {
    Node root;

    public BST() {
        root = null;
    }

    @Override
    public Filme_IF remove(long id) {
        Filme_IF[] removedFilm = new Filme_IF[1];

        try {
            root = rec_Remove(root, id, removedFilm);

            if (removedFilm[0] == null) {
                throw new Exception("ID: " + id + " not found!");
            }

            return removedFilm[0];

        } catch (Exception e) {
            System.out.println("Error while removing film: " + e.getMessage());
            return null;
        }
    }

    private Node rec_Remove(Node root, long id, Filme_IF[] removedFilm) {
        if (root == null) {
            return null;  // Caso base: nó não encontrado
        }

        if (id < root.film.getID()) {
            root.left = rec_Remove(root.left, id, removedFilm);  // Busca no lado esquerdo
        } else if (id > root.film.getID()) {
            root.right = rec_Remove(root.right, id, removedFilm);  // Busca no lado direito
        } else {
            // Filme encontrado
            removedFilm[0] = root.film;  // Guarda o filme que será removido

            // Caso 1: Nó com um único filho ou nenhum filho
            if (root.left == null) {
                return root.right;  // Retorna o filho direito
            } else if (root.right == null) {
                return root.left;  // Retorna o filho esquerdo
            }

            // Caso 2: Nó com dois filhos
            root.film = minValue(root.right);  // Substitui pelo menor filme da subárvore direita
            root.right = rec_Remove(root.right, root.film.getID(), removedFilm);  // Remove o nó duplicado
        }
        return root;  // Retorna o nó atualizado
    }

    private Filme_IF minValue(Node root) {

        Filme_IF minFilm = root.film;
        while (root.left != null) {
            minFilm = root.left.film;
            root = root.left;
        }
        return minFilm;
    }

    @Override
    public void insert(Filme_IF elemento) {
        root = rec_Insert(root, elemento);
    }

    private Node rec_Insert(Node root, Filme_IF film) {
        if (root == null) {

            root = new Node(film);
            return root;
        }
        if (film.getID() < root.film.getID()) {
            root.left = rec_Insert(root.left, film);

        } else if (film.getID() > root.film.getID()) {
            root.right = rec_Insert(root.right, film);

        }
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        Filme_IF film = rec_Search(root, id);

        try {
            if (film == null) {
                throw new Exception("Id: " + id + " not founded!");
            }
            return film;
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private Filme_IF rec_Search(Node root, long id){
        if (root == null){
            return null;
        }

        if (root.film.getID() == id){
            return root.film;
        }

        if (id < root.film.getID()){
            return rec_Search(root.left, id);
        }
        else{
            return rec_Search(root.right, id);
        }
    }

    @Override
    public Filme_IF root() throws Exception {
        if (root == null) {
            throw new Exception("Empty tree!");
        }
        return root.film;
    }

    @Override
    public int height() {
        return rec_Height(root);
    }

    private int rec_Height(Node root) {
        if (root == null) {
            return -1;
        }
        int left_height = rec_Height(root.left);
        int right_height = rec_Height(root.right);
        return Math.max(left_height, right_height) + 1;
    }

    @Override
    public int size() {
        return rec_Size(root);
    }

    private int rec_Size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + rec_Size(root.left) + rec_Size(root.right);
    }

    @Override
    public boolean isComplete() {
        int size = size();
        return rec_isComplete(root, 0, size);
    }

    private boolean rec_isComplete(Node root, int index, int size) {
        if (root == null) {
            return true;
        }
        if (index >= size) {
            return false;
        }
        return rec_isComplete(root.left, 2 * index + 1, size) && rec_isComplete(root.right, 2 * index + 2, size);
    }

        @Override
        public Filme_IF[] preOrder() {
            int size = size();
            Filme_IF[] preOrderArray = new Filme_IF[size];
            preOrder_aux(preOrderArray, root, new int[]{0});
            return preOrderArray;
        }

        private void preOrder_aux(Filme_IF[] preOrderArray, Node root, int[] index) {
            if (root == null) {
                return;
            }
            preOrderArray[index[0]++] = root.film;
            preOrder_aux(preOrderArray, root.left, index);
            preOrder_aux(preOrderArray, root.right, index);
        }

    @Override
    public Filme_IF[] order() {
        int size = size();
        Filme_IF[] OrderArray = new Filme_IF[size];
        Order_aux(OrderArray, root, new int[]{0});
        return OrderArray;
    }

    private void Order_aux(Filme_IF[] OrderArray, Node root, int[] index) {
        if (root == null) {
            return;
        }
        Order_aux(OrderArray, root.left, index);
        OrderArray[index[0]++] = root.film;
        Order_aux(OrderArray, root.right, index);
    }


    @Override
    public Filme_IF[] postOrder() {
        int size = size();
        Filme_IF[] postOrderArray = new Filme_IF[size];
        postOrder_aux(postOrderArray, root, new int[]{0});
        return postOrderArray;
    }

    private void postOrder_aux(Filme_IF[] postOrderArray, Node root, int[] index) {
        if (root == null) {
            return;
        }
        postOrder_aux(postOrderArray, root.left, index);
        postOrder_aux(postOrderArray, root.right, index);
        postOrderArray[index[0]++] = root.film;

    }

    public void print() throws Exception {

        try {
            if (isEmpty()) {
                throw new Exception("Empty Tree!");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Chose print method:
                    1- In Order
                    2- Pre Order
                    3- Post Order""");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("In Order:");
                    Filme_IF[] inOrderArray = order();
                    for (Filme_IF film : inOrderArray) {
                        System.out.print("\n" + film);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Pre Order");
                    Filme_IF[] preOrderArray = preOrder();
                    for (Filme_IF film : preOrderArray) {
                        System.out.print("\n" + film);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Post Order:");
                    Filme_IF[] postOrderArray = postOrder();
                    for (Filme_IF film : postOrderArray) {
                        System.out.print("\n" + film);
                    }
                    System.out.println();
                    break;
                default:
                    System.out.print("Invalid choice. Please try again.\n");
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

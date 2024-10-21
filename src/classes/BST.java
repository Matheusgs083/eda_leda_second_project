package classes;

import interfaces.BST_IF;
import interfaces.Filme_IF;

public class BST implements BST_IF {

    Node root;

    public BST() {
        root = null;
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
       root = rec_Remove(root,id);
        return null;
    }

    private Node rec_Remove(Node root, long id) {

        if (root == null) {
            return root;
        }

        if (id < root.film.getID()) {
            root.left = rec_Remove(root.left, id);
        }

        else if (id > root.film.getID()) {
            root.right = rec_Remove(root.right, id);
        }

        else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }


            root.film = minValue(root.right);
            root.right = rec_Remove(root.right, root.film.getID());
        }

        return root;
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
        rec_Isert(root, elemento);
    }

    private Node rec_Isert(Node root, Filme_IF film) {
        if (root == null) {
            root = new Node(film);
            return root;
        }
        if (film.getID() < root.film.getID()) {
            root.left = rec_Isert(root.left, film);
        } else if (film.getID() > root.film.getID()) {
            root.right = rec_Isert(root.right, film);
        }

        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        return null;
    }

    @Override
    public Filme_IF root() throws Exception {
        if (root == null) {
            throw new Exception("Emity tree!");
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

        if (left_height > right_height) {
            return left_height + 1;
        } else {
            return right_height + 1;
        }

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

        if ( index >= size){
            return false;
        }

        return rec_isComplete(root.left, 2 * index + 1, size) && rec_isComplete(root.right, 2 * index + 2, size);

    }

    @Override
    public Filme_IF[] preOrder() {
        return new Filme_IF[0];
    }

    @Override
    public Filme_IF[] order() {
        return new Filme_IF[0];
    }

    @Override
    public Filme_IF[] postOrder() {
        return new Filme_IF[0];
    }
}

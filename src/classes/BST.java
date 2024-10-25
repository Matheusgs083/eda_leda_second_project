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
        root = rec_Remove(root, id);
        return null;
    }

    private Node rec_Remove(Node root, long id) {
        if (root == null) {
            return root;
        }
        if (id < root.film.getID()) {
            root.left = rec_Remove(root.left, id);
        } else if (id > root.film.getID()) {
            root.right = rec_Remove(root.right, id);
        } else {
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
        root = rec_Insert(root, elemento);
    }

    private Node rec_Insert(Node root, Filme_IF film) {
        if (root == null) {
            System.out.println("Inserido " + film + " Na raiz.");
            root = new Node(film);
            return root;
        }
        if (film.compareTo(root.film) > 0) {
            System.out.println("Inserindo " + film + " à esquerda de " + root.film);
            root.left = rec_Insert(root.left, film);
        } else if (film.compareTo(root.film) < 0) {
            System.out.println("Inserindo " + film + " à direita de " + root.film);
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
        return null;
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
        Order_aux(OrderArray, root.right, index);
        OrderArray[index[0]++] = root.film;
        Order_aux(OrderArray, root.left, index);
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
        postOrderArray[index[0]++] = root.film;
        postOrder_aux(postOrderArray, root.right, index);
        postOrder_aux(postOrderArray, root.left, index);
    }
}

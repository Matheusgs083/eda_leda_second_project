
<<<<<<< HEAD
public class Main{
    public static void main(String[] args) throws Exception {
=======
import classes.*;
import interfaces.*;
>>>>>>> df0225b50ad3df1b24a52cb23229fb2aed54dd15

public class Main {
    public static void main(String[] args) {
        try {
            // Cria a árvore binária de busca
            BST bst = new BST();

            // Criação de alguns filmes
            Filme_IF filme1 = new Filme("Velozes e Furiosos", 4, 2001, 15);
            Filme_IF filme2 = new Filme("O Senhor dos Anéis", 5, 2001, 10);
            Filme_IF filme3 = new Filme("Matrix", 5, 1999, 20);
            Filme_IF filme4 = new Filme("Star Wars", 4, 1977, 5);
            Filme_IF filme5 = new Filme("Interstellar", 5, 2014, 30);

            // Inserindo filmes na árvore
            bst.insert(filme1);
            bst.insert(filme2);
            bst.insert(filme3);
            bst.insert(filme4);
            bst.insert(filme5);

            // Exibindo o tamanho da árvore
            System.out.println("Tamanho da árvore: " + bst.size());

            // Buscando um filme
            long searchId = 20;
            Filme_IF searchedFilm = bst.search(searchId);
            System.out.println("Filme encontrado: " + searchedFilm);

            // Removendo um filme
            long removeId = 10;
            Filme_IF removedFilm = bst.remove(removeId);
            System.out.println("Filme removido: " + removedFilm);

            // Tentando buscar um filme removido
            try {
                bst.search(removeId);
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Exibindo a exceção
            }

            // Exibindo o tamanho da árvore após remoção
            System.out.println("Tamanho da árvore após remoção: " + bst.size());

            // Exibindo todos os filmes na ordem
            Filme_IF[] allFilms = bst.order();
            System.out.println("Filmes na árvore (em ordem):");
            for (Filme_IF filme : allFilms) {
                System.out.println(filme);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

        System.out.println("IDs dos filmes disponíveis:");
        System.out.println(table.print());

        table.remove(34);
        table.remove(54);
        table.remove(13);

        System.out.println("IDs dos filmes após remoções:");
        System.out.println(table.print());
    }
}
=======
>>>>>>> df0225b50ad3df1b24a52cb23229fb2aed54dd15

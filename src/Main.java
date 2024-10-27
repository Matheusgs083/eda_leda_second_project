
import classes.*;
import interfaces.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Cria a árvore binária de busca
            BST bst = new BST();
            TabelaHash hash = new TabelaHash(101);

            // Criação de alguns filmes
            Filme_IF filme1 = new Filme(hash);
            Filme_IF filme2 = new Filme(hash);
            Filme_IF filme3 = new Filme(hash);
            Filme_IF filme4 = new Filme(hash);
            Filme_IF filme5 = new Filme(hash);

            // Inserindo filmes na árvore
            bst.insert(filme1);
            bst.insert(filme2);
            bst.insert(filme3);
            bst.insert(filme4);
            bst.insert(filme5);

            // Exibindo o tamanho da árvore
            System.out.println("Tamanho da árvore: " + bst.size());

//            // Buscando um filme
//            long searchId = 20;
//            Filme_IF searchedFilm = bst.search(searchId);
//            System.out.println("Filme encontrado: " + searchedFilm);
//
//            // Removendo um filme
//            long removeId = 10;
//            Filme_IF removedFilm = bst.remove(removeId);
//            System.out.println("Filme removido: " + removedFilm);

//            // Tentando buscar um filme removido
//            try {
//                bst.search(removeId);
//            } catch (Exception e) {
//                System.out.println(e.getMessage()); // Exibindo a exceção
//            }

//            // Exibindo o tamanho da árvore após remoção
//            System.out.println("Tamanho da árvore após remoção: " + bst.size());

            // Exibindo todos os filmes na ordem
            Filme_IF[] allFilms = bst.order();
            System.out.println("Filmes na árvore (em ordem):");
            for (Filme_IF filme : allFilms) {
                System.out.println(filme);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

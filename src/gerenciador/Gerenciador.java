package gerenciador;

import classes.BST;
import classes.Filme;
import classes.TabelaHash;
import interfaces.Filme_IF;

import java.util.Scanner;

public class Gerenciador {

    public static final Scanner leitor = new Scanner(System.in);
    public static int menu;
    public static final TabelaHash IDS = new TabelaHash(101);

    public static void gerenciador() throws Exception {

        TabelaHash table = new TabelaHash(0);
        BST bst = new BST();

        label:
        while (true){

            System.out.println("1 - Insert film." +
                               "\n2 - Search film." +
                               "\n3 - Remove film." +
                               "\n4 - Print films");

            menu = leitor.nextInt();

            switch (menu) {
                case 1:
                    insertFilm(bst, table);
                case 2:
                    searchFilm(bst, table);
                case 3:
                    removeFilm(bst,table);
                case 4:
            }
        }


    }

    public static void searchFilm(BST bst, TabelaHash table) throws Exception {

        System.out.println("Inform the movie's ID: ");
        long id = leitor.nextLong();

        System.out.println("Inform the film's location:" +
                           "\n1 - BST" +
                           "\n2 - HashTable");

        int option = leitor.nextInt();

        if (option == 1){ bst.search(id);} else {table.search(id);}
    }

    public static void insertFilm(BST bst, TabelaHash tabela){

        Filme_IF filme = readFilm();

        System.out.println("Escolha a estrutura para armazenar o filme: " +
                           "1 - BST" +
                           "2 - TabelaHash");

        int opcao = leitor.nextInt();

        if (opcao == 1 ){
            bst.insert(filme);
        } else {
            tabela.insert(filme);
        }
    }

    public static Filme_IF readFilm(){


        System.out.println("Nome: ");
        String nome = leitor.nextLine();

        System.out.println("Nota: ");
        int nota = leitor.nextInt();

        System.out.println("Ano: ");
        int ano = leitor.nextInt();

        return new Filme(nome, nota, ano, IDS);
    }

    public static void removeFilm(BST bst, TabelaHash table) throws Exception {

        System.out.println("Inform the film's ID that you want to remove: ");
        long id = leitor.nextLong();

        System.out.println("Inform the structure that the film is in:" +
                           "\n1 - BST" +
                           "\n2 - HashTable");

        int option = leitor.nextInt();

        if (option == 1){ bst.remove(id);} else {table.remove(id);}
    }

    public static void printFilm(BST bst, TabelaHash table){

        System.out.println("Inform the structure you want to print: " +
                           "\n 1 - BST" +
                           "\n 2 - HashTable");

        int option = leitor.nextInt();

        if (option == 1){} else { table.print();}
    }
}

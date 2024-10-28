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

            System.out.println("""
                    1 - Insert film.
                    2 - Search film.
                    3 - Remove film.
                    4 - Print films
                    5 - Generate films (for tests)
                    6 - Close program""");

            menu = leitor.nextInt();

            switch (menu) {
                case 1:
                    insertFilm(bst, table);
                    break;
                case 2:
                    searchFilm(bst, table);
                    break;
                case 3:
                    removeFilm(bst, table);
                    break;
                case 4:
                    printFilm(bst, table);
                    break;
                case 5:
                    generateFilms(bst, table);
                    break;
                case 6:
                    break  label;
            }
        }


    }

    public static void searchFilm(BST bst, TabelaHash table) throws Exception {

        System.out.println("Inform the film's ID: ");
        long id = leitor.nextLong();

        System.out.println("""
                Select the structure to search in:
                1 - BST
                2 - HashTable""");

        int option = leitor.nextInt();

        if (option == 1){ bst.search(id);} else {table.search(id);}
    }

    public static void insertFilm(BST bst, TabelaHash tabela){

        Filme_IF filme = readFilm();

        System.out.println("""
                Select the structure to store the film:\s
                1 - BST
                2 - Hash Table""");

        int opcao = leitor.nextInt();

        if (opcao == 1 ){
            bst.insert(filme);
        } else {
            tabela.insert(filme);
        }
    }

    public static Filme_IF readFilm(){
        Scanner leitorInt = new Scanner(System.in);

        System.out.println("Nome: ");
        leitor.nextLine();
        String nome = leitor.nextLine();

        System.out.println("Nota: ");
        int nota = leitorInt.nextInt();

        System.out.println("Ano: ");
        int ano = leitorInt.nextInt();

        return new Filme(nome, nota, ano, IDS);
    }

    public static void removeFilm(BST bst, TabelaHash table) throws Exception {

        System.out.println("Inform the film's ID that you want to remove: ");
        long id = leitor.nextLong();

        System.out.println("""
                Inform the structure that the film is in:
                1 - BST
                2 - HashTable""");

        int option = leitor.nextInt();

        if (option == 1){ bst.remove(id);} else {table.remove(id);}
    }

    public static void printFilm(BST bst, TabelaHash table){

        System.out.println("""
                Inform the structure you want to print:\s
                 1 - BST
                 2 - HashTable""");

        int option = leitor.nextInt();

        if (option == 1){bst.print();} else { table.print();}
    }

    public static void generateFilms(BST bst, TabelaHash table){


        System.out.println("Enter the number of films to be generated: ");
        int quantity = leitor.nextInt();

        System.out.println("""
                Enter the structure to store the films:\s
                1 - BST
                2 - Hash Table""");

        int option = leitor.nextInt();

        if (option == 1){

            for (int i = 0; i < quantity; i++){

                Filme film = new Filme(table);
                bst.insert(film);

            }
        } else {

            for (int i = 0; i < quantity; i++){

                Filme film = new Filme(table);
                table.insert(film);

            }
        }
    }
}

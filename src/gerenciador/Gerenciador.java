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

        TabelaHash table = new TabelaHash(10);
        BST bst = new BST();

        label:
        while (true) {

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
                    break label;
            }
        }


    }

    public static void searchFilm(BST bst, TabelaHash table) throws Exception {

        if (bst.isEmpty() && table.isEmpty()) {
            System.out.println("Both structures are empty. No films to remove.");
            return;
        }

        long id;
        Filme_IF film;

        while(true){

            System.out.println("""
                Select the structure to search in:
                1 - BST
                2 - HashTable
                3 - Back to Menu""");

            int choice = leitor.nextInt();
            if (choice == 3){break;}

            switch (choice){
                case 1:
                    if(bst.isEmpty()){
                        System.out.println("Empty Tree");
                    }
                    else {
                        System.out.println("Inform the film's ID that you want to search: ");
                        id = leitor.nextLong();
                        film = bst.search(id);
                        if (film == null) {
                            break;
                        }
                        System.out.println("Film ID: " + id  + " founded: " + film);
                    }
                    break;
                case 2:
                    if(table.isEmpty()){
                        System.out.println("Empty Hash Table");
                    }
                    else {
                        System.out.println("Inform the film's ID that you want to search: ");
                        id = leitor.nextLong();
                        film = table.search(id);
                        if (film == null) {
                            break;
                        }
                        System.out.println("Film ID: " + id  + " founded: " + film);
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }

    public static void insertFilm(BST bst, TabelaHash table) {

        Filme_IF filme = readFilm();

        System.out.println("""
                Select the structure to store the film:
                1 - BST
                2 - Hash Table""");

        int opcao = leitor.nextInt();

        if (opcao == 1) {
            bst.insert(filme);
        } else {
            table.insert(filme);
        }
    }

    public static Filme_IF readFilm() {

        System.out.println("Name: ");
        leitor.nextLine();
        String name = leitor.nextLine();

        System.out.println("Rating: ");
        int rate = leitor.nextInt();
        while ( rate < 1 || rate > 5){
            System.out.println("""
                    The rating only goes from 1 to 5.
                    Try again!
                    Rating:""");

            rate = leitor.nextInt();
        }

        System.out.println("Year: ");
        int year = leitor.nextInt();

        return new Filme(name, rate, year, IDS);
    }

    public static void removeFilm(BST bst, TabelaHash table) throws Exception {

        if (bst.isEmpty() && table.isEmpty()) {
            System.out.println("Both structures are empty. No films to remove.");
            return;
        }
        Filme_IF film;
        while (true) {
            System.out.println("""
                    Inform the structure that the film is in:
                    1 - BST
                    2 - HashTable
                    3 - Back to Menu""");


            int choice = leitor.nextInt();
            if (choice == 3){break;}

            long id;

            switch (choice) {

                case 1:
                    if(bst.isEmpty()){
                        System.out.println("Empty Tree");
                    }
                    else {
                        System.out.println("Inform the film's ID that you want to remove: ");
                        id = leitor.nextLong();
                        film = bst.remove(id);
                        if (film == null) {
                            break;
                        }
                        System.out.println("Film: " + film + " removed.");
                    }
                    break;
                case 2:
                    if(table.isEmpty()){
                        System.out.println("Empty Hash Table");
                    }
                    else {
                        System.out.println("Inform the film's ID that you want to remove: ");
                        id = leitor.nextLong();
                        film = table.remove(id);
                        if (film == null) {
                            break;
                        }
                        System.out.println("Film: " + film + " removed.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void printFilm(BST bst, TabelaHash table) throws Exception {

        if (bst.isEmpty() && table.isEmpty()) {
            System.out.println("Both structures are empty. No films to remove.");
            return;
        }

        label:
        while(true){
            System.out.println("""
                Inform the structure you want to print:\s
                 1 - BST
                 2 - HashTable
                 3 - Back to Menu""");

            int option = leitor.nextInt();

            switch (option){
                case 1:
                    bst.print();
                    break;
                case 2:
                    System.out.println(table.print());
                    break;
                case 3:
                    break label;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


            public static void generateFilms (BST bst, TabelaHash table){


                System.out.println("Enter the number of films to be generated: ");
                int quantity = leitor.nextInt();

                System.out.println("""
                        Enter the structure to store the films:\s
                        1 - BST
                        2 - Hash Table""");

                int option = leitor.nextInt();

                if (option == 1) {

                    for (int i = 0; i < quantity; i++) {

                        Filme film = new Filme(table);
                        bst.insert(film);

                    }
                } else {

                    for (int i = 0; i < quantity; i++) {

                        Filme film = new Filme(table);
                        table.insert(film);
                    }
                }
            }
    }
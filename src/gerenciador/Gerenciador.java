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

            System.out.println("1 - Inserir filme." +
                               "\n2 - Buscar filme." +
                               "\n3 - Remover filme." +
                               "\n4 - Printar filmes");

            menu = leitor.nextInt();

            switch (menu) {
                case 1:
                    insereFilme(table, bst);
            }
        }


    }

    public static void insereFilme(TabelaHash tabela, BST bst){

        Filme_IF filme = leFilme();

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

    public static Filme_IF leFilme(){


        System.out.println("Nome: ");
        String nome = leitor.nextLine();

        System.out.println("Nota: ");
        int nota = leitor.nextInt();

        System.out.println("Ano: ");
        int ano = leitor.nextInt();

        return new Filme(nome, nota, ano, IDS);
    }
}

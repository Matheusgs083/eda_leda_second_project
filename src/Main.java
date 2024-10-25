import classes.Filme;
import classes.TabelaHash;

public class Main{
    public static void main(String[] args){

        TabelaHash table = new TabelaHash(10);

        for (int i = 0; i < 60; i++){
            Filme filme = new Filme();
            table.insert(filme);
        }

        System.out.println("IDs dos filmes disponíveis:");
        System.out.println(table.print());



    }
}
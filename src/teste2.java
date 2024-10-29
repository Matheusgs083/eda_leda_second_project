import classes.Filme;
import classes.TabelaHash;

public class teste2 {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(10);

        for (int i = 0; i < 100; i++){

            Filme filme = new Filme(tabela);
            tabela.insert(filme);
        }

        System.out.println(tabela.print());
    }
}

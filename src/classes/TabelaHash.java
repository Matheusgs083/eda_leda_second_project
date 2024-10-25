package classes;

import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

public class TabelaHash implements TabelaHash_IF {

    private Lista[] tabela;
    private int size;

    private int hash(long chave) {
        return (int) (chave % this.tabela.length);
    }

    @Override
    public Filme_IF remove(long id) throws Exception {

        int index = hash(id);

        Filme_IF removedFilm = tabela[index].remove(id);

        if (removedFilm != null){size -= 1;}

        return removedFilm;
    }

    @Override
    public void insert(Filme_IF elemento) {

        long id = elemento.getID();

        int index = hash(id);

        tabela[index].insert(elemento);

        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Filme_IF search(long id) throws Exception {

        int index = hash(id);

        Filme_IF filme = tabela[index].search(id);

        if (filme == null) throw new Exception("Filme não existe.");

        return filme;
    }

    @Override
    public String print() {
        String result = "";

        for (int i = 0; i < tabela.length; i++) {
            result += i + ": ";
            if (!tabela[i].isEmpty()) {
                Node current = tabela[i].getHead();
                while (current != null) {
                    result += current.film.getID(); // Assume que Filme_IF tem um método getID()
                    if (current.right != null) {
                        result += ", ";
                    }
                    current = current.right;
                }
            }
            result += "\n";
        }

        return result;
    }
}

package classes;

import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TabelaHash implements TabelaHash_IF {

    private Lista[] tabela;
    private int size;

    public TabelaHash(int capacidade) {

        this.tabela = new Lista[capacidade];

        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new Lista();
        }

        this.size = 0;
    }

    private int hash(long chave) {
        return (int) (chave % this.tabela.length);
    }

    @Override
    public Filme_IF remove(long id) throws Exception {

        int index = hash(id);

        Filme_IF removedFilm = tabela[index].remove(id);

        if (removedFilm != null) {
            size -= 1;
        }

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

    private boolean contains(long id) {
        try {
            return search(id) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public long generateUniqueID() {
        long ID;
        do {  //Por algum motivo para aumentar o número de filmes inseridos na tabela hash tem que aumentar
            ID = ThreadLocalRandom.current().nextLong(1, 1000000); //o bound dessa variavel.
        }
        while (contains(ID));

        return ID;
    }

    public String printOrdered() {
        List<Long> ids = new ArrayList<>();

        // Coleta todos os IDs
        for (Lista lista : tabela) {
            Node current = lista.getHead();
            while (current != null) {
                ids.add(current.film.getID());
                current = current.right;
            }
        }

        // Ordena os IDs
        Collections.sort(ids);

        // Monta a string ordenada
        StringBuilder result = new StringBuilder();
        for (long id : ids) {
            result.append(id).append(", ");
        }

        // Remove a última vírgula e espaço, se existirem
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }

        return result.toString();
    }
}

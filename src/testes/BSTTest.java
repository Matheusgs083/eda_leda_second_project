package testes;

import classes.Filme;
import classes.BST;
import interfaces.Filme_IF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    private BST bst;

    @BeforeEach
    public void setUp() {
        bst = new BST();
    }

    @Test
    void testInserirFilme() throws Exception {
        Filme filme1 = new Filme("Filme 1", 10, 1999, 0);
        Filme filme2 = new Filme("Filme 2", 5, 2020, 1);

        bst.insert(filme1);
        bst.insert(filme2);

        assertNotNull(bst.search(0), "Filme A deveria estar presente na árvore.");
        assertNotNull(bst.search(1), "Filme B deveria estar presente na árvore.");
    }

    @Test
    void testBuscarFilme() throws Exception {
        Filme filme1 = new Filme("Filme A", 10, 1999, 0);
        Filme filme2 = new Filme("Filme B", 5, 2020, 1);

        bst.insert(filme1);
        bst.insert(filme2);

        assertNotNull(bst.search(0), "Buscar deveria retornar o Filme A.");
        assertEquals("Filme B", bst.search(1).getNome(), "Deveria retornar o Filme B.");
        assertNull(bst.search(999), "Filme inexistente não deveria estar presente.");
    }

    @Test
    void testRemoverFilme() throws Exception {

        Filme filme1 = new Filme("Filme 1", 10, 1999, 0);
        Filme filme2 = new Filme("Filme 2", 5, 2020, 1);
        Filme filme3 = new Filme("Filme 3", 10, 2010, 2);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertNotNull(bst.remove(0), "Deveria remover o Filme A.");
        assertNull(bst.search(0), "Filme A não deveria estar na árvore após a remoção.");

        assertNotNull(bst.remove(2), "Deveria remover o Filme C.");
        assertNull(bst.search(2), "Filme C não deveria estar na árvore após a remoção.");

        assertNull(bst.remove(999), "Remover um filme inexistente deveria retornar null.");
    }

    @Test
    void testExibirFilmes() {
        Filme filme1 = new Filme("Filme 1", 10, 1999, 0);
        Filme filme2 = new Filme("Filme 2", 5, 2020, 1);
        Filme filme3 = new Filme("Filme 3", 10, 2010, 2);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Captura a lista de filmes exibidos em ordem
        Filme_IF[] filmesExibidosArray = bst.order();
        List<Filme_IF> filmesExibidos = Arrays.asList(filmesExibidosArray);

        assertEquals(3, filmesExibidos.size());
        assertEquals("Filme 3", filmesExibidos.get(0).getNome(), "Primeiro filme deve ser o Filme 1.");
        assertEquals("Filme 2", filmesExibidos.get(1).getNome(), "Segundo filme deve ser o Filme 2.");
        assertEquals("Filme 1", filmesExibidos.get(2).getNome(), "Terceiro filme deve ser o Filme 3.");
    }



}
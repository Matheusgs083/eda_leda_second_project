package testes;

import classes.Filme;
import classes.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    private BST bst;
    private Filme filme1, filme2, filme3;

    @BeforeEach
    public void setUp() {
        bst = new BST(); // Removido o `private`

        // Criando filmes com valores distintos para testes
        Filme filme1 = new Filme("Filme 1", 10, 1999, 1);
        Filme filme2 = new Filme("Filme 2", 5, 2020, 2);
        Filme filme3 = new Filme("Filme 3", 10, 2010, 3);
    }

    @Test
    void testInserirFilme() throws Exception {
        Filme filme1 = new Filme("Filme 1", 10, 1999, 0);
        Filme filme2 = new Filme("Filme 2", 5, 2020, 1);

        bst.insert(filme1);
        bst.insert(filme2);

        assertTrue(bst.search(0) != null, "Filme A deveria estar presente na árvore.");
        assertTrue(bst.search(1) != null, "Filme B deveria estar presente na árvore.");
    }

    @Test
    void testBuscarFilme() throws Exception {
        Filme filme1 = new Filme("Filme A", 10, 1999, 0);
        Filme filme2 = new Filme("Filme B", 5, 2020, 1);

        bst.insert(filme1);
        bst.insert(filme2);

        assertTrue(bst.search(0) != null, "Buscar deveria retornar o Filme A.");
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

        assertTrue(bst.remove(0) != null, "Deveria remover o Filme A.");
        assertNull(bst.search(0), "Filme A não deveria estar na árvore após a remoção.");

        assertTrue(bst.remove(2) != null, "Deveria remover o Filme C.");
        assertNull(bst.search(2), "Filme C não deveria estar na árvore após a remoção.");

        assertNull(bst.remove(999), "Remover um filme inexistente deveria retornar null.");
    }

   /* @Test
    void testExibirFilmes() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Captura a lista de filmes exibidos em ordem
        List<Filme> filmesExibidos = bst.or();

        assertEquals(3, filmesExibidos.size(), "Deveria exibir três filmes.");
        assertEquals("Filme A", filmesExibidos.get(0).getNome(), "Primeiro filme deve ser o Filme A.");
        assertEquals("Filme B", filmesExibidos.get(1).getNome(), "Segundo filme deve ser o Filme B.");
        assertEquals("Filme C", filmesExibidos.get(2).getNome(), "Terceiro filme deve ser o Filme C.");
    } */
}

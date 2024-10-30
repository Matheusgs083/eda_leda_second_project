package testes;

import classes.Filme;
import classes.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    private BST bst;
    private Filme filme1, filme2, filme3;

    @BeforeEach
    public void setUp() {
        private bst = new BST();

        // Criando filmes com valores distintos para testes
        filme1 = new Filme(1, "Filme A", 8.5);
        filme2 = new Filme(2, "Filme B", 9.2);
        filme3 = new Filme(3, "Filme C", 7.4);
    }

    @Test
    void testInserirFilme() {
        bst.insert(filme1);
        bst.insert(filme2);

        assertTrue(bst.search(1).isPresent(), "Filme A deveria estar presente na árvore.");
        assertTrue(bst.search(2).isPresent(), "Filme B deveria estar presente na árvore.");
    }

    @Test
    void testBuscarFilme() {
        bst.insert(filme1);
        bst.insert(filme2);

        assertTrue(bst.search(1).isPresent(), "Buscar deveria retornar o Filme A.");
        assertEquals("Filme B", bst.search(2).get().getNome(), "Deveria retornar o Filme B.");
        assertFalse(bst.search(999).isPresent(), "Filme inexistente não deveria estar presente.");
    }

    @Test
    void testRemoverFilme() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertTrue(bst.remove(1), "Deveria remover o Filme A.");
        assertFalse(bst.search(1).isPresent(), "Filme A não deveria estar na árvore após a remoção.");

        assertTrue(bst.remove(3), "Deveria remover o Filme C.");
        assertFalse(bst.search(3).isPresent(), "Filme C não deveria estar na árvore após a remoção.");

        assertFalse(bst.remove(999), "Remover um filme inexistente deveria retornar false.");
    }

    @Test
    void testExibirFilmes() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Captura a lista de filmes exibidos em ordem
        List<Filme> filmesExibidos = bstFilme.exibirEmOrdem();

        assertEquals(3, filmesExibidos.size(), "Deveria exibir três filmes.");
        assertEquals("Filme A", filmesExibidos.get(0).getNome(), "Primeiro filme deve ser o Filme A.");
        assertEquals("Filme B", filmesExibidos.get(1).getNome(), "Segundo filme deve ser o Filme B.");
        assertEquals("Filme C", filmesExibidos.get(2).getNome(), "Terceiro filme deve ser o Filme C.");
    }


}
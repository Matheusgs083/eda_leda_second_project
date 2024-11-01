package testes;

import classes.Filme;
import classes.Lista;
import interfaces.Filme_IF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaTest {

    private Lista lista;
    private Filme filme1;
    private Filme filme2;
    private Filme filme3;

    @BeforeEach
    void setUp() {
        lista = new Lista();
        filme1 = new Filme("Viva a vida é uma festa", 11, 2017, 0);
        filme2 = new Filme("Big Hero 6", 10, 2014, 1);
        filme3 = new Filme("Ratatouille", 10, 2007, 2);
    }

    @Test
    void testIsEmpty() {
        assertTrue(lista.isEmpty(), "A lista deve estar vazia inicialmente.");
    }

    @Test
    void testInsert() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);

        assertFalse(lista.isEmpty(), "A lista não deve estar vazia após inserções.");
        assertEquals(2, lista.size(), "O tamanho da lista deve ser 2 após duas inserções.");
        assertEquals(filme1, lista.head().getID() == 0 ? filme1 : null, "O primeiro filme deve ser o filme1.");
        assertEquals(filme2, lista.tail().getID() == 1 ? filme2 : null, "O último filme deve ser o filme2.");
    }

    @Test
    void testRemoveFirst() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);
        lista.insert(filme3);

        Filme_IF removido = lista.removeFirst();
        assertEquals(filme1, removido, "O primeiro filme removido deve ser `filme1`.");
        assertEquals(2, lista.size(), "O tamanho da lista deve ser 2 após remover o primeiro filme.");
        assertEquals(filme2, lista.head(), "O novo primeiro filme deve ser `filme2`.");
    }

    @Test
    void testRemoveLast() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);
        lista.insert(filme3);

        Filme_IF removido = lista.removeLast();
        assertEquals(filme3, removido, "O último filme removido deve ser `filme3`.");
        assertEquals(2, lista.size(), "O tamanho da lista deve ser 2 após remover o último filme.");
        assertEquals(filme2, lista.tail(), "O novo último filme deve ser `filme2`.");
    }

    @Test
    void testHeadAndTail() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);

        assertEquals(filme1, lista.head(), "O primeiro filme deve ser `filme1`.");
        assertEquals(filme2, lista.tail(), "O último filme deve ser `filme2`.");
    }

    @Test
    void testSearch() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);
        lista.insert(filme3);

        assertEquals(filme1, lista.search(filme1.getID()), "A busca deve encontrar `filme1` pelo ID.");
        assertEquals(filme3, lista.search(filme3.getID()), "A busca deve encontrar `filme3` pelo ID.");
        assertThrows(Exception.class, () -> lista.search(999), "A busca deve lançar exceção para ID inexistente.");
    }

    @Test
    void testSize() {
        assertEquals(0, lista.size(), "O tamanho inicial da lista deve ser 0.");
        lista.insert(filme1);
        assertEquals(1, lista.size(), "O tamanho da lista deve ser 1 após uma inserção.");
        lista.insert(filme2);
        lista.insert(filme3);
        assertEquals(3, lista.size(), "O tamanho da lista deve ser 3 após três inserções.");
    }

    @Test
    void testExceptions() {
        assertThrows(Exception.class, () -> lista.head(), "Acessar `head` de uma lista vazia deve lançar exceção.");
        assertThrows(Exception.class, () -> lista.tail(), "Acessar `tail` de uma lista vazia deve lançar exceção.");
        assertThrows(Exception.class, () -> lista.removeFirst(), "Remover o primeiro elemento de uma lista vazia deve lançar exceção.");
        assertThrows(Exception.class, () -> lista.removeLast(), "Remover o último elemento de uma lista vazia deve lançar exceção.");
        assertThrows(Exception.class, () -> lista.search(-1), "Buscar um ID negativo deve lançar exceção.");
    }

}

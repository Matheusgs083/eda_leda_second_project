package testes;

import classes.Filme;
import classes.Pilha;
import interfaces.Filme_IF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaTest {

    private Pilha pilha;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @BeforeEach
    void setUp() {
        pilha = new Pilha();
        filme1 = new Filme("Filme 1", 4, 2000, 0);
        filme2 = new Filme("Filme 2", 5, 2010, 1);
        filme3 = new Filme("Filme 3", 3, 2020, 2);
    }

    @Test
    void testPushAndTop() throws Exception {
        pilha.push(filme1);
        assertEquals(filme1, pilha.top(), "O topo da pilha deve ser `filme1` após inseri-lo.");

        pilha.push(filme2);
        assertEquals(filme2, pilha.top(), "O topo da pilha deve ser `filme2` após inseri-lo.");

        pilha.push(filme3);
        assertEquals(filme3, pilha.top(), "O topo da pilha deve ser `filme3` após inseri-lo.");
    }

    @Test
    void testPop() throws Exception {
        pilha.push(filme1);
        pilha.push(filme2);
        pilha.push(filme3);

        assertEquals(filme3, pilha.pop(), "O pop deve remover e retornar `filme3`, que é o topo.");
        assertEquals(filme2, pilha.pop(), "O pop deve remover e retornar `filme2`, que é o novo topo.");
        assertEquals(filme1, pilha.pop(), "O pop deve remover e retornar `filme1`, que é o novo topo.");

        assertTrue(pilha.isEmpty(), "A pilha deve estar vazia após remover todos os elementos.");
    }

    @Test
    void testIsEmpty() throws Exception {
        assertTrue(pilha.isEmpty(), "A pilha deve estar vazia ao ser inicializada.");

        pilha.push(filme1);
        assertFalse(pilha.isEmpty(), "A pilha não deve estar vazia após adicionar um elemento.");

        pilha.pop();
        assertTrue(pilha.isEmpty(), "A pilha deve estar vazia após remover o único elemento.");
    }

    @Test
    void testTopThrowsExceptionWhenEmpty() {
        Exception exception = assertThrows(Exception.class, () -> pilha.top(), "Deve lançar exceção ao acessar o topo de uma pilha vazia.");
        assertEquals("A pilha está vazia.", exception.getMessage());
    }

    @Test
    void testPopThrowsExceptionWhenEmpty() {
        Exception exception = assertThrows(Exception.class, () -> pilha.pop(), "Deve lançar exceção ao remover de uma pilha vazia.");
        assertEquals("A pilha está vazia.", exception.getMessage());
    }
}

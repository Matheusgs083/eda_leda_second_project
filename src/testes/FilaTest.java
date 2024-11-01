package testes;

import classes.Filme;
import classes.Fila;
import interfaces.Filme_IF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {

    private Fila fila;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @BeforeEach
    void setUp() {
        fila = new Fila();
        filme1 = new Filme("Filme 1", 4, 2000, 0);
        filme2 = new Filme("Filme 2", 5, 2010, 1);
        filme3 = new Filme("Filme 3", 3, 2020, 2);
    }

    @Test
    void testEnqueueAndHead() throws Exception {
        fila.enqueue(filme1);
        assertEquals(filme1, fila.head(), "O primeiro elemento da fila deve ser `filme1` após enfileirá-lo.");

        fila.enqueue(filme2);
        assertEquals(filme1, fila.head(), "O primeiro elemento da fila deve continuar sendo `filme1` após enfileirar `filme2`.");

        fila.enqueue(filme3);
        assertEquals(filme1, fila.head(), "O primeiro elemento da fila deve continuar sendo `filme1` após enfileirar `filme3`.");
    }

    @Test
    void testDequeue() throws Exception {
        fila.enqueue(filme1);
        fila.enqueue(filme2);
        fila.enqueue(filme3);

        assertEquals(filme1, fila.dequeue(), "O elemento removido deve ser `filme1`, o primeiro enfileirado.");
        assertEquals(filme2, fila.dequeue(), "O elemento removido deve ser `filme2`, agora o primeiro.");
        assertEquals(filme3, fila.dequeue(), "O elemento removido deve ser `filme3`, o último da fila.");

        assertTrue(fila.isEmpty(), "A fila deve estar vazia após remover todos os elementos.");
    }

    @Test
    void testIsEmpty() {
        assertTrue(fila.isEmpty(), "A fila deve estar vazia ao ser inicializada.");

        fila.enqueue(filme1);
        assertFalse(fila.isEmpty(), "A fila não deve estar vazia após adicionar um elemento.");

        try {
            fila.dequeue();
        } catch (Exception e) {
            fail("Não deve lançar exceção ao remover um elemento.");
        }
        assertTrue(fila.isEmpty(), "A fila deve estar vazia após remover o único elemento.");
    }

    @Test
    void testHeadThrowsExceptionWhenEmpty() {
        Exception exception = assertThrows(Exception.class, () -> fila.head(), "Deve lançar exceção ao acessar o primeiro elemento de uma fila vazia.");
        assertEquals("A fila está vazia.", exception.getMessage());
    }

    @Test
    void testDequeueThrowsExceptionWhenEmpty() {
        Exception exception = assertThrows(Exception.class, () -> fila.dequeue(), "Deve lançar exceção ao remover de uma fila vazia.");
        assertEquals("A fila está vazia.", exception.getMessage());
    }

}

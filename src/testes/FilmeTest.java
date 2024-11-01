package testes;

import classes.Filme;
import interfaces.Filme_IF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {

    private Filme filme1;
    private Filme filme2;

    @BeforeEach
    void setUp() {
        filme1 = new Filme("Viva a vida é uma festa", 11, 2017, 0);
        filme2 = new Filme("Big Hero 6", 10, 2014, 1);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Viva a vida é uma festa", filme1.getNome());
        assertEquals(11, filme1.getNota());
        assertEquals(2017, filme1.getAno());
        assertEquals(0, filme1.getID());

        filme1.setNome("Ratatouille");
        filme1.setNota(10);
        filme1.setAno(2007);
        filme1.setID(2);

        assertEquals("Ratatouille", filme1.getNome());
        assertEquals(10, filme1.getNota());
        assertEquals(2007, filme1.getAno());
        assertEquals(2, filme1.getID());
    }

    @Test
    void testToString() {
        String expected = "Nome: Viva a vida é uma festa (2017) Nota: 11. ID: 0";
        assertEquals(expected, filme1.toString());
    }

    @Test
    void testCompareTo_DifferentNota() {
        assertTrue(filme2.compareTo(filme1) > 0);
        assertTrue(filme1.compareTo(filme2) < 0);
    }

    @Test
    void testCompareTo_SameNotaDifferentAno() {
        Filme filme3 = new Filme("The Batman", 5, 2022, 3L);
        assertTrue(filme2.compareTo(filme3) < 0);
        assertTrue(filme3.compareTo(filme2) > 0);
    }


}

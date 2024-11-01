package testes;

import classes.Filme;
import classes.TabelaHash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TabelaHashTest  {
    private TabelaHash tabela;

    @BeforeEach
    public void setUp() {
        tabela = new TabelaHash(10); // Capacidade de 10
    }

    /* Seguindo a ideia tradicional dos testes JUnit, visamos ter impressões silenciosas no console
       quando a execução ocorre como o esperado, nada é impresso, e quando não recebemos mensagens de erro.
     */

    @Test
    public void testInserirFilme() {
        Filme filme = new Filme("Filme 1", 4, 2022, tabela);
        tabela.insert(filme);
        assertFalse(tabela.isEmpty(), "A tabela não deve estar vazia após a inserção.");
        assertEquals(1, tabela.getSize(), "Deve haver 1 filme na tabela.");
    }

    @Test
    public void testInserirFilmeComColisao() throws Exception {
        Filme filme1 = new Filme("Filme X", 4, 2022, 0);  // Suponha que ambos gerem a mesma posição hash
        Filme filme2 = new Filme("Filme Y", 5, 2023, 0);  // ID que pode colidir com filme1
        tabela.insert(filme1);
        tabela.insert(filme2);

        assertEquals(2, tabela.getSize(), "Devem haver 2 filmes na tabela após lidar com a colisão.");
        assertNotNull(tabela.search(filme1.getID()), "O filme1 deve ser encontrado após colisão.");
        assertNotNull(tabela.search(filme2.getID()), "O filme2 deve ser encontrado após colisão.");
    }

    @Test
    public void testBuscarFilme() throws Exception {
        Filme filme = new Filme("Filme 2", 5, 2023, 0);
        tabela.insert(filme);
        Filme encontrado = (Filme) tabela.search(filme.getID());
        assertNotNull(encontrado, "O filme deve ser encontrado.");
        assertEquals(filme.getNome(), encontrado.getNome(), "Os nomes dos filmes devem ser iguais.");
    }

    @Test
    public void testBuscarFilmeInexistente() {
        assertThrows(Exception.class, () -> tabela.search(999), "Deve lançar uma exceção ao buscar um ID inexistente.");
    }

    @Test
    public void testRemoverFilme() throws Exception {
        Filme filme = new Filme("Filme 3", 3, 2021, tabela);
        tabela.insert(filme);
        assertEquals(1, tabela.getSize(), "Deve haver 1 filme na tabela antes da remoção.");

        tabela.remove(filme.getID());
        assertEquals(0, tabela.getSize(), "A tabela deve estar vazia após a remoção.");
    }

    @Test
    public void testRemoverFilmeComIdNegativo() {
        assertThrows(Exception.class, () -> tabela.remove(-5), "Deve lançar uma exceção ao remover um ID inexistente.");
    }

    @Test
    public void testExibirFilmesOrdenados() {
        Filme filme1 = new Filme("Filme A", 5, 2020, 334776);
        Filme filme2 = new Filme("Filme B", 3, 2019, 747514);
        Filme filme3 = new Filme("Filme C", 4, 2021, 300747);

        tabela.insert(filme1);
        tabela.insert(filme2);
        tabela.insert(filme3);

        String resultado = tabela.printOrdered();
        assertEquals(filme3.getID() + ", " + filme1.getID() + ", " + filme2.getID(),
                resultado.trim(), "Os filmes devem ser exibidos na ordem correta.");
    }

    @Test
    public void testPrintOrderedTabelaVazia() {
        String resultado = tabela.printOrdered();
        assertEquals("", resultado.trim(), "A exibição deve ser vazia para uma tabela vazia.");
    }
}

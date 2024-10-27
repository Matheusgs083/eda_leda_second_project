package classes;


import interfaces.Filme_IF;

import java.util.concurrent.ThreadLocalRandom;

public class Filme implements Filme_IF, Comparable<Filme_IF> {

    private long ID;
    private String nome;
    private int nota;
    private int ano;

    private static final String[] Titulos = {"Era do Gelo: ", "Piratas do Caribe: ", "Rei Leão: ", "Velozes e Furiosos: ", "Mad Max: ", "O Vendedor de Linguiça: ", "Os Vingadores: ", "Tropa de Elite: ", "Cidade de Deus: ", "JheffersonKauã: ", "Transformers: ", "Ratatouille: ", "Pitú: ", "Os Trapalhões: ", "Os Minions: ", "Herbie: ","Os cara de pau: ","Carros: ","John wick","Resident evil: ","Diário de um banana: ", "Kratos: ", "Hulk: ", "Vida de Inseto: ", "La La Land: ","Lobo de Wall street: ", "O Regresso: ", "Titanic: ","Homem Aranha: "};
    private static final String[] SubTitulos = {"A História de uma abelha", "A era de ultron", "A vingança dos derrotados", "O lado escuro da lua", "Desafio na UEPB", "uma noite muito louca", "Sexo com Proteção", "Prisioneiro de Azkaban", "Câmara Secreta", "A Pedra Filosofal", "Trair é errado", "Meu fusca turbinado" , "E os 7 anões", "Guerra infinita","O Deus da guerra","","E a mãe", "Cantando estações", "De volta ao lar", "Longe de casa", "Sem volta pra casa"};

    public Filme(String nome, int nota, int ano, int ID) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
        this.ID = ID;
    }

    public Filme(TabelaHash hash){
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        this.nome = Titulos[rand.nextInt(Titulos.length)] + SubTitulos[rand.nextInt(SubTitulos.length)];
        this.ano = rand.nextInt(1980, 2025); // Gera um ano aleatório entre 1980 e 2024
        this.nota = rand.nextInt(1, 6); // Gera uma nota aleatória entre 1 e 5 (inclusive)
        this.ID = hash.generateUniqueID();
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + " (" + this.ano + ")" + " Nota: " + this.nota + ". ID: " + this.ID;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF outro_filme) {

        if (this.nota != outro_filme.getNota()) {
            return Integer.compare(outro_filme.getNota(), this.nota);
        }
        else if (this.ano != outro_filme.getAno()) {
            return Integer.compare(this.ano, outro_filme.getAno());
        }
        else if (!this.nome.equals(outro_filme.getNome())) {
            return this.nome.compareTo(outro_filme.getNome());
        }
        return Long.compare(this.ID, outro_filme.getID());
    }
}

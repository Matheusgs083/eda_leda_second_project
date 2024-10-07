package classes;

import interfaces.Filme_IF;

public class Filme implements Filme_IF {
    @Override
    public long getID() {
        return 0;
    }

    @Override
    public void setID(long ID) {

    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public void setNome(String nome) {

    }

    @Override
    public int getNota() {
        return 0;
    }

    @Override
    public void setNota(int nota) {

    }

    @Override
    public int getAno() {
        return 0;
    }

    @Override
    public void setAno(int ano) {

    }

    @Override
    public int compareTo(Filme_IF outro_filme) {
        return 0;
    }
}

package com.criticalsoftware.model;

public class Jogador {
    private String nome;
    private String posicao;
    private int idade;
    private String timeAtual;
    private int golsMarcados;

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getIdade() {
        return idade;
    }

    public String getTimeAtual() {
        return timeAtual;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTimeAtual(String timeAtual) {
        this.timeAtual = timeAtual;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", posicao='" + posicao + '\'' +
                ", idade=" + idade +
                ", timeAtual='" + timeAtual + '\'' +
                ", golsMarcados=" + golsMarcados +
                '}';
    }
}

package org.example.models;

public class Cliente {
    private String nome;
    private String tipo;
    private double fidelidade;
    private String logradouro;
    private String Bairro;
    private String Cidade;

    public Cliente(String nome, String tipo, String logradouro, String Bairro, String Cidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(double fidelidade) {
        this.fidelidade = fidelidade;
    }

    @Override
    public String toString() {
        return String.format(
                "Nome: %s, Tipo: %s, Fidelidade: %f, Logradouro: %s, Bairro: %s, Cidade: %s", nome, tipo, fidelidade, logradouro, Bairro, Cidade
        );
    }
}

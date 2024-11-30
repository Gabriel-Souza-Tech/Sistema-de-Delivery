package org.example.models;

public class Item {
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private String tipo;

    public Item(String nome, int quantidade, double valorUnitario, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public double getValorTotal() {
        return quantidade * valorUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format(
                "Item: %s, Quantidade: %d, Valor Unitario: %.2f, Tipo: %s, Valor Total: %.2f", nome, quantidade, valorUnitario, tipo, getValorTotal()
        );
    }
}

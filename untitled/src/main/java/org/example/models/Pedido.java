package org.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private ArrayList<Item> itens;
    private ArrayList<CupomDescontoEntrega> cupomDescontos;

    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente) {
        if (taxaEntrega <= 0 || dataPedido == null || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }

        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cupomDescontos = new ArrayList<CupomDescontoEntrega>();
    }

    public double getValorPedido() {
        double valorDoPedido = 0;
        for (Item item : itens) {
            valorDoPedido += item.getValorTotal();
        }

        // falta adicionar logica dos descontos, adicionado return so para retirar o erro da IDE
        return valorDoPedido + taxaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void aplicarDescontos(CupomDescontoEntrega desconto) {
        cupomDescontos.add(desconto);
    }

    public double getDescontoConcedido()    {
        double descontoTotal = 0;

        for(CupomDescontoEntrega desconto : cupomDescontos) {
            descontoTotal += desconto.getValorDesconto();
        }

        return descontoTotal;
    }

    public List<CupomDescontoEntrega> getCupomDescontos() {
        return cupomDescontos;
    }
}

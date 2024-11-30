package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private Cliente cliente;
    private ArrayList<Item> itens;
    private ArrayList<CupomDescontoEntrega> cupomDescontos;

    public Pedido(double taxaEntrega, Cliente cliente) {
        this.taxaEntrega = taxaEntrega;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cupomDescontos = new ArrayList<>();
    }

    public double getValorPedido() {
        double valorDoPedido = 0;
        for (Item item : itens) {
            valorDoPedido += item.getValorTotal();
        }

        // falta adicionar logica dos descontos, adicionado return so para retirar o erro da IDE
        return valorDoPedido;
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
        double descontoConcedido = 0;

        for(CupomDescontoEntrega desconto : cupomDescontos) {
            descontoConcedido += desconto.getValorDesconto();
        }

        return descontoConcedido;
    }

    public List<CupomDescontoEntrega> getCupomDescontos() {
        return cupomDescontos;
    }
}

package org.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private String codigoCupom;
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

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public double getValorPedido() {
        double valorDoPedido = 0;
        double descontoTotal = 0;

        for (Item item : itens) {
            valorDoPedido += item.getValorTotal();
        }

        for(CupomDescontoEntrega cupom : this.cupomDescontos)  {
            descontoTotal += cupom.getValorDesconto();
        }

        return valorDoPedido + getTaxaEntrega() - descontoTotal;
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

    public double getDescontoConcedido()    {
        double descontoTotal = 0;

        for(CupomDescontoEntrega desconto : cupomDescontos) {
            descontoTotal += desconto.getValorDesconto();
        }

        return descontoTotal;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void aplicarDescontos(CupomDescontoEntrega desconto) {
        cupomDescontos.add(desconto);
    }

    public List<CupomDescontoEntrega> getCupomDescontos() {
        return cupomDescontos;
    }

    @Override
    public String toString() {
        String itensInfo = "";
        for (Item item : itens) {
            itensInfo += item.toString() + " | ";
        }

        return String.format(
                "Cliente: %s, Data do Pedido: %s, Taxa de Entrega: %.2f, Itens: [%s], Cupons de Desconto: %d, Valor Total: %.2f",
                cliente.getNome(),
                dataPedido,
                taxaEntrega,
                itensInfo.isEmpty() ? "Nenhum item" : itensInfo,
                cupomDescontos.size(),
                getValorPedido()
        );
    }

}

package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDesconto;

    public CalculadoraDescontoService() {
        this.metodosDesconto = new ArrayList<IMetodoDescontoTaxaEntrega>();
    }

    public void calcularTaxaDesconto(Pedido pedido) {
        for(IMetodoDescontoTaxaEntrega metodo : metodosDesconto)    {
            metodo.calcularDesconto(pedido);
        }
    }

    private static List<IMetodoDescontoTaxaEntrega> getListMetodoDesconto() {
        List<IMetodoDescontoTaxaEntrega> metodosDeDesconto= new ArrayList<>();

        IMetodoDescontoTaxaEntrega metodoDescontoBairro = new MetodoDescontoPorBairro();
        IMetodoDescontoTaxaEntrega metodoDescontoTipoCliente = new MetodoDescontoTaxaTipoCliente();
        IMetodoDescontoTaxaEntrega metodoDescontoTipoItem = new MetodoDescontoTipoItem();
        IMetodoDescontoTaxaEntrega metodoDescontoValorPedido = new MetodoDescontoValorPedido();

        metodosDeDesconto.add(metodoDescontoBairro);
        metodosDeDesconto.add(metodoDescontoTipoCliente);
        metodosDeDesconto.add(metodoDescontoTipoItem);
        metodosDeDesconto.add(metodoDescontoValorPedido);

        return metodosDeDesconto;
    }

    public void adicionarMetodo(IMetodoDescontoTaxaEntrega metodoDesconto) {
        if (metodoDesconto == null) {
            return;
        }

        this.metodosDesconto.add(metodoDesconto);
    }
}

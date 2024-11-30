package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.Pedido;

public class MetodoDescontoTaxaTipoCliente implements IMetodoDescontoTaxaEntrega {
    private String tipoCliente;

    public MetodoDescontoTaxaTipoCliente(){

    }

    @Override
    public void calcularDesconto(Pedido pedido) {

    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return false;
    }
}

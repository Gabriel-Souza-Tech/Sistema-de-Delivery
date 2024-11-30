package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.Pedido;

public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    @Override
    public void calcularDesconto(Pedido pedido)  {

    }
    public boolean seAplica(Pedido pedido)   {
        return false;
    }
}

package org.example.interfaces;

import org.example.models.Pedido;

public interface IMetodoDescontoTaxaEntrega {

    void calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}

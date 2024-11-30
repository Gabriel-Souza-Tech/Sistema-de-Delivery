package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    @Override
    public void calcularDesconto(Pedido pedido)  {
        if(!seAplica(pedido))  {

        }

        Double valorDesconto = 0.0;

        if(pedido.getValorPedido() > 200.0) {
            valorDesconto = 5.0;
        }

        if(valorDesconto != 0.0) {
            pedido.aplicarDescontos(new CupomDescontoEntrega("Desconto por valor do pedido aplicado!", valorDesconto));
        }
    }
    public boolean seAplica(Pedido pedido)   {
        return pedido.getTaxaEntrega() <= 10.0;
    }
}

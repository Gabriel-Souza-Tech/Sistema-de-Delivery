package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Pedido;

import java.util.Map;

public class MetodoDescontoTaxaTipoCliente implements IMetodoDescontoTaxaEntrega {
    private Map<String,Double> categoriaCliente = Map.of(
            "Ouro", 0.3,
            "Prata", 0.2,
            "Bronze", 0.1

    );


    @Override
    public void calcularDesconto(Pedido pedido) {
            if (!seAplica(pedido)) {
                throw new IllegalArgumentException("O desconto por tipo de Cliente nao pode ser aplicado ao pedido!");
            }

            String tipoCliente = pedido.getCliente().getTipo();
            Double percentualDesconto = categoriaCliente.get(tipoCliente);

            if (percentualDesconto != 0.0) {
                double valorDesconto = pedido.getTaxaEntrega() * percentualDesconto;
                pedido.aplicarDescontos(new CupomDescontoEntrega("Desconto por tipo de Cliente", valorDesconto));

            }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return categoriaCliente.containsKey(pedido.getCliente().getTipo()) && pedido.getDescontoConcedido() <= 10.0;
    }
}

package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
import org.example.models.Item;
import org.example.models.Pedido;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoTipoItem implements IMetodoDescontoTaxaEntrega{
    private Map<String,Double> categoriaItem = Map.of(
            "Alimentacao", 0.05,
            "Educacao", 0.2,
            "Lazer", 0.15

    );

    @Override
    public void calcularDesconto(Pedido pedido){
        if(!seAplica(pedido)){
            throw new  IllegalArgumentException("O desconto por tipo de item nao pode ser aplicado ao pedido.");
        }

        double valorDesconto = 0.0;

        for(Item item : pedido.getItens()){
            String tipo = item.getTipo();
            Double descontoPercentual = categoriaItem.get(tipo);

            valorDesconto += item.getValorTotal() * descontoPercentual;
        }

        if(valorDesconto > 0){
            pedido.aplicarDescontos(new CupomDescontoEntrega("Desconto por tipo de item aplicado", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getDescontoConcedido() == 0.0 && pedido.getDescontoConcedido() <= 10.0;
    }
}

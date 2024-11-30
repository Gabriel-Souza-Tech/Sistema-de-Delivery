package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.Pedido;

import java.util.Map;

public class MetodoDescontoPorBairro implements IMetodoDescontoTaxaEntrega {
    private Map<String,Double> bairrosComtemplados = Map.of(
            "Centro", 0.2,
            "Bela Vista", 0.3,
            "Cidade Maravilhosa", 0.15
    );


    // implementando logica de calcular desconto com a validação do seAplica()
    @Override
    public void calcularDesconto(Pedido pedido)   {
        if(seAplica(pedido)) {

        } else {
            throw new RuntimeException("");
        }
    }
    @Override
    public boolean seAplica(Pedido pedido) {
        return bairrosComtemplados.containsValue(pedido.getCliente().getBairro()) && pedido.getDescontoCondedido() <= 10.0;
    }
}

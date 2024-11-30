package org.example.services;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.CupomDescontoEntrega;
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
    public void calcularDesconto(Pedido pedido) {
        if(!seAplica(pedido)) {
            throw new  IllegalArgumentException("O desconto por bairro nao pode ser apicado ao pedido.");
        }

        String bairroCliente = pedido.getCliente().getNome();
        Double percentualDesconto = bairrosComtemplados.get(bairroCliente);

        if(percentualDesconto != null) {
            double valorDesconto = pedido.getTaxaEntrega() * percentualDesconto;
            pedido.aplicarDescontos(new CupomDescontoEntrega("Desconto pelo Bairro", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return bairrosComtemplados.containsKey(pedido.getCliente().getBairro()) && pedido.getDescontoConcedido() <= 10.0;
    }
}

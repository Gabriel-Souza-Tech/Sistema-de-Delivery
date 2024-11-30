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

    public void calcularDesconto(Pedido pedido) {}
}

// preciso adicionar a lista de metodos de desconto
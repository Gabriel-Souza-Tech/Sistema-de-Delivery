package org.example;

import org.example.interfaces.IMetodoDescontoTaxaEntrega;
import org.example.models.Cliente;
import org.example.models.Item;
import org.example.models.Pedido;
import org.example.services.CalculadoraDescontoService;
import org.example.services.MetodoDescontoPorBairro;
import org.example.services.MetodoDescontoTaxaTipoCliente;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CalculadoraDescontoService calculadoraDescontoService = new CalculadoraDescontoService();

        Cliente cliente = new Cliente("Aldebaram", "Prata", "A casa de Touro", "Centro", "Alegre" );
        Item item = new Item("DogaoDuplo", 2, 8.0, "Alimentacao");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), cliente);

        pedido.adicionarItem(item);


        IMetodoDescontoTaxaEntrega metodoDescontoPorBairro = new MetodoDescontoPorBairro();
        IMetodoDescontoTaxaEntrega metodoDescontoPorTipoCliente = new MetodoDescontoTaxaTipoCliente();


        calculadoraDescontoService.adicionarMetodo(metodoDescontoPorBairro);
        calculadoraDescontoService.adicionarMetodo(metodoDescontoPorTipoCliente);

        System.out.println("\n*---* Antes do desconto *---*");
        System.out.println(pedido);

        System.out.println("\n*---* Depos do desconto *---*");
        calculadoraDescontoService.calcularTaxaDesconto(pedido);
        System.out.println(pedido);

    }
}
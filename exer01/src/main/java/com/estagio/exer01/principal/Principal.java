package com.estagio.exer01.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.estagio.exer01.model.Venda;

//Escreva um programa que:
// • Liste todas as vendas 
// • Calcule o total vendido no mês
// • Mostre o cliente que mais comprou

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private List<Venda> vendas = new ArrayList<>();

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            System.out.println("Selecione uma opção:");
            var menu = """
                    1 - Cadastrar venda
                    2 - Listar vendas
                    3 - Calcular total vendido
                    4 - Cliente que mais comprou
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1 -> cadastrarVenda();
                case 2 -> listarVendas();
                case 3 -> calcularTotalVendido();
                case 4 -> clienteQueMaisComprou();

                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");

            }
        }
    }

    private void cadastrarVenda() {
        System.out.println("Digite a data da venda (dd/MM/yyyy):");
        String dataVendaStr = leitura.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVenda = LocalDate.parse(dataVendaStr, formatter);

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = leitura.nextLine();

        System.out.println("Digite o valor da venda:");
        double valorVenda = leitura.nextDouble();

        vendas.add(new Venda(dataVenda, nomeCliente, valorVenda));
        System.out.println("Venda cadastrada com sucesso!");
    }

    private void listarVendas() {
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Vendas cadastradas no mês atual:");

        for (Venda venda : vendas) {
            if (venda.getDataVenda().getMonthValue() == dataAtual.getMonthValue()
                    && venda.getDataVenda().getYear() == dataAtual.getYear()) {
                System.out.println("Data: " + venda.getDataVenda() + ", Cliente: " + venda.getNomeCliente()
                        + ", Valor: " + venda.getValorVenda());
            }
        }
    }

    private void calcularTotalVendido() {
        LocalDate dataAtual = LocalDate.now();
        double total = 0;
        for (Venda venda : vendas) {
            if (venda.getDataVenda().getMonthValue() == dataAtual.getMonthValue()
                    && venda.getDataVenda().getYear() == dataAtual.getYear()) {
                total += venda.getValorVenda();
            }
        }
        System.out.println("Total vendido no mês atual: " + total);
    }

    private void clienteQueMaisComprou() {

        String clienteMaisComprou = "";
        double maiorValor = 0;

        for (Venda venda : vendas) {
            if (venda.getValorVenda() > maiorValor) {
                maiorValor = venda.getValorVenda();
                clienteMaisComprou = venda.getNomeCliente();
            }
        }
        System.out.println("Cliente que mais comprou: " + clienteMaisComprou + " com valor de: " + maiorValor);
    }

}

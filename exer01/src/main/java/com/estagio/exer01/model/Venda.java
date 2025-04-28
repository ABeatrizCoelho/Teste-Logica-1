package com.estagio.exer01.model;

import java.time.LocalDate;

//data da venda, nome do cliente, valor da venda
public class Venda {
    private LocalDate dataVenda;
    private String nomeCliente;
    private double valorVenda;

    public Venda(LocalDate dataVenda, String nomeCliente, double valorVenda) {
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
        this.valorVenda = valorVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
}

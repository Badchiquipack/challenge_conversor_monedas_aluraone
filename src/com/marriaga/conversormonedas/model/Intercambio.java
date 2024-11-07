package com.marriaga.conversormonedas.model;

public class Intercambio {
    private String moneda1;
    private String moneda2;
    private Double cantidad;
    private Double valor;
    private Double conversion;

    public Intercambio(String moneda1, String moneda2, Double cantidad) {
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;
        this.cantidad = cantidad;
    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    public String getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(String moneda1) {
        this.moneda1 = moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public void setMoneda2(String moneda2) {
        this.moneda2 = moneda2;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

package com.aluracursos.conversormoneda.apps;

public class ConversorMoneda {
    public ConversorMoneda() {
    }

    public double conversorMoneda(double tasaDeCambio, int opcionDeConversion, double valorAConvertir) {
        return opcionDeConversion % 2 == 0 ? valorAConvertir * tasaDeCambio : valorAConvertir / tasaDeCambio;
    }
}


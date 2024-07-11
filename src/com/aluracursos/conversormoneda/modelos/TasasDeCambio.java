package com.aluracursos.conversormoneda.modelos;

import java.util.Map;

public record TasasDeCambio(Map conversion_rates) {
    public TasasDeCambio(Map conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public Map conversion_rates() {
        return this.conversion_rates;
    }
}
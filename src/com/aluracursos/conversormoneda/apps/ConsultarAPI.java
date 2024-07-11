package com.aluracursos.conversormoneda.apps;

import com.aluracursos.conversormoneda.modelos.TasasDeCambio;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsultarAPI {
    public ConsultarAPI() {
    }

    public double consultarTasaDeCambio(int tipoDeCambio) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1c735814f009a2f8c4685989/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            TasasDeCambio tasasDeCambio = (TasasDeCambio)(new Gson()).fromJson((String)response.body(), TasasDeCambio.class);
            if (tipoDeCambio != 1 && tipoDeCambio != 2) {
                if (tipoDeCambio != 3 && tipoDeCambio != 4) {
                    if (tipoDeCambio != 5 && tipoDeCambio != 6) {
                        return 0.0;
                    } else {
                        return (Double)tasasDeCambio.conversion_rates().get("BRL");
                    }
                } else {
                    return (Double)tasasDeCambio.conversion_rates().get("ARS");
                }
            } else {
                return (Double)tasasDeCambio.conversion_rates().get("CLP");
            }
        } catch (Exception var7) {
            Exception e = var7;
            System.out.println("Ha ocurrido un error" + e.getMessage());
            return 0.0;
        }
    }
}

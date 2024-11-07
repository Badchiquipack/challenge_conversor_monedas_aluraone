package com.marriaga.conversormonedas.connection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.marriaga.conversormonedas.model.Intercambio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {

    public static Intercambio obtenerValores(Intercambio intercambio) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/38b302c29b35e5d3985c9fca/pair/" +
                intercambio.getMoneda1() + "/" + intercambio.getMoneda2() + "/" + intercambio.getCantidad();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        intercambio.setConversion(jsonObject.get("conversion_result").getAsDouble());
        intercambio.setValor(jsonObject.get("conversion_rate").getAsDouble());
        return intercambio;
    }
}

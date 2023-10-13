package com.katana.rover;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlateauApiCommand {
    public static int obtenerDatos() {

        // URL de la API a la que deseas realizar la solicitud GET
        String apiUrl = "http://localhost:8080/api/rover/roverId";

        // Crear una instancia de HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Crear una solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        Long responseBody = 0L;
        try {
            // Enviar la solicitud HTTP y recibir la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Obtener el código de respuesta HTTP y la respuesta
            int statusCode = response.statusCode();
            responseBody = Long.parseLong(response.body());

            // Manejar la respuesta según sea necesario
            System.out.println("Código de respuesta: " + statusCode);
            System.out.println("Respuesta del servidor: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Math.toIntExact(responseBody);
    }

    public static void enviarCommands(String commandElements  ) {
        // URL de la API a la que deseas enviar los datos
        String apiUrl = "http://localhost:8080/api/rover/command";
        // Crear un mapa de datos para representar los valores a enviar en JSON
        Long id_rover = (long) obtenerDatos();

        // Convertir el mapa de datos a una cadena JSON (puedes usar una biblioteca como Jackson o Gson)
        String jsonData = "{\n" +
                "  \"commandElements\":\"" + commandElements +"\",\n" +
                "  \"id_rover\":" + id_rover +"\n" +
                "}";

        System.out.println(jsonData);
        // Crear una instancia de HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Crear una solicitud HTTP POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();

        try {
            // Enviar la solicitud HTTP y recibir la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Obtener el código de respuesta HTTP y la respuesta
            int statusCode = response.statusCode();
            String responseBody = response.body();

            // Manejar la respuesta según sea necesario
            System.out.println("Código de respuesta: " + statusCode);
            System.out.println("Respuesta del servidor: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

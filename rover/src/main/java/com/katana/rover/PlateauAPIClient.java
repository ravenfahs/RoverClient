package com.katana.rover;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class  PlateauAPIClient {

    public static void enviar(int width, int height,  int numeroDeObstaculos, int tamañoGrid, int gridSize) {

        // URL de la API a la que deseas enviar los datos
        String apiUrl = "http://localhost:8080/api/rover";

        String jsonData = "{\n" +
                "  \"width\":" +width +",\n" +
                "  \"height\":" +height +",\n" +
                "  \"numeroDeObstaculos\":" +numeroDeObstaculos +",\n" +
                "  \"tamañoGrid\":" +tamañoGrid +",\n" +
                "  \"gridSize\":" +gridSize +"\n" +
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
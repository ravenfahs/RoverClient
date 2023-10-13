package com.katana.rover;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class PlateauApiRover {

    public static void enviarRover(int x, int y, String sentido, GridElementType elementType) {
        // URL de la API a la que deseas enviar los datos
        String apiUrl = "http://localhost:8080/api/rover/rover";
        // Crear un mapa de datos para representar los valores a enviar en JSON
        Long id_plateauRover = (long) PlateauAPIElements.obtenerDatos();
        // Convertir el mapa de datos a una cadena JSON (puedes usar una biblioteca como Jackson o Gson)
        String jsonData = "{\n" +
                "  \"cellXRover\":" + x +",\n" +
                "  \"cellYRover\":" + y +",\n" +
                "  \"tipo\":\""+ elementType + "\",\n" +
                "  \"sentido\":\""+ sentido + "\",\n" +
                "  \"id_plateau\":\"" + id_plateauRover +"\"\n" +
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

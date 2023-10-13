package com.katana.rover;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PlateauPing {
    public static int isServerActive() {
        String url = "http://localhost:8080/api/rover/up"; // URL del servidor que quieres pin

        try {
            URL serverUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setRequestMethod("HEAD"); // Usamos HEAD para hacer un request sin descargar el cuerpo de la respuesta

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("El servidor está activo. Código de respuesta: " + responseCode);
                return responseCode;
            } else {
                System.out.println("El servidor no está disponible. Código de respuesta: " + responseCode);
                return responseCode;
            }
        } catch (IOException e) {
            System.out.println("Error al intentar conectar con el servidor: " + e.getMessage());
            return 404;
        }
    }
}

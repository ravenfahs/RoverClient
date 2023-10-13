package com.katana.rover;

public class ValidatePlateau {
    public static boolean validateWidth(int width){
        if(width<=0){
            throw new IllegalArgumentException("El ancho de la meseta debe ser mayor que cero.");
        }
        return true;
    }

    public static boolean validateHeight(int height){
        if(height<=0){
            throw new IllegalArgumentException("El alto de la meseta debe ser mayor que cero.");
        }
        return true;
    }

    public static boolean validateGridSize(int gridSize){
        if(gridSize<=0){
            throw new IllegalArgumentException("El tamaño de la cuadrícula debe ser mayor que cero.");
        }
        return true;
    }

    public static boolean validateNumObstacles(int numObstacles){
        if(numObstacles<=0){
            throw new IllegalArgumentException("El número de obstáculos debe ser mayor que cero.");
        }
        return true;
    }
}

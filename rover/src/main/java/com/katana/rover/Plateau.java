package com.katana.rover;

import lombok.Getter;

@Getter
public class Plateau {

    private int width;
    private int height;
    private int tamañoGrid;
    private int numeroDeObstaculos;
    private  int gridSize;
    private int cellXRover;
    private int cellYRover;
    private String sentido;
    private String comandos;


    public String setComandos(String comandos) {
        this.comandos = comandos;
        return comandos;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public void setCellXRover(int cellXRover) {
        this.cellXRover = cellXRover;
    }

    public void setCellYRover(int cellYRover) {
        this.cellYRover = cellYRover;
    }

    public Plateau() {
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public void setNumeroDeObstaculos(int numeroDeObstaculos) {
        this.numeroDeObstaculos = numeroDeObstaculos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTamañoGrid(int tamañoGrid) {
        this.tamañoGrid = tamañoGrid;
    }
}

package com.katana.rover;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlateauTest {


    @Test
    public void testServerStatus() {
        // Realiza la prueba de conexión al servidor
        assertEquals(200, PlateauPing.isServerActive());
    }

    @Test
    public void testDatosDeEstradaPlateauWidth(){
        try {
            ValidatePlateau.validateWidth(0);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El ancho de la meseta debe ser mayor que cero.",e.getMessage());
        }

        try {
            ValidatePlateau.validateWidth(-5);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El ancho de la meseta debe ser mayor que cero.",e.getMessage());
        }
    }

    @Test
    public void testDatosDeEstradaPlateauHeight(){
        try {
            ValidatePlateau.validateHeight(0);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El alto de la meseta debe ser mayor que cero.",e.getMessage());
        }

        try {
            ValidatePlateau.validateHeight(-5);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El alto de la meseta debe ser mayor que cero.",e.getMessage());
        }
    }

    @Test
    public void testDatosDeEstradaPlateauGridSize(){
        try {
            ValidatePlateau.validateGridSize(0);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El tamaño de la cuadrícula debe ser mayor que cero.",e.getMessage());
        }

        try {
            ValidatePlateau.validateGridSize(-5);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El tamaño de la cuadrícula debe ser mayor que cero.",e.getMessage());
        }
    }

    @Test
    public void testDatosDeEstradaPlateauNumObstacles(){
        try {
            ValidatePlateau.validateNumObstacles(0);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El número de obstáculos debe ser mayor que cero.",e.getMessage());
        }

        try {
            ValidatePlateau.validateNumObstacles(-5);
            fail("Debería haber lanzado una excepción");
        }catch (IllegalArgumentException e){
            assertEquals("El número de obstáculos debe ser mayor que cero.",e.getMessage());
        }
    }

    @Test
    public void testIsPositionOccupied() {
        PlateauConfigurator configurator = new PlateauConfigurator();

        // Mock de la lista de elementos (usando Mockito)
        List<GridElement> elementos = new ArrayList<>();
        GridElement obstacle1 = mock(GridElement.class);
        when(obstacle1.getTipo()).thenReturn(GridElementType.OBSTACLE);
        when(obstacle1.getX()).thenReturn(3);
        when(obstacle1.getY()).thenReturn(5);
        elementos.add(obstacle1);

        // Establecer la lista de elementos en el configurador (puedes usar un constructor para esto)
        configurator.setElementos(elementos);

        // Debería devolver falso porque hay un obstáculo en esta posición
        assertTrue(configurator.isPositionOccupied(3, 5));

    }
}


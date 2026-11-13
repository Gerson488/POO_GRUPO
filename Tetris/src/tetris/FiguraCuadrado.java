/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.Arrays;
import java.util.List;

public class FiguraCuadrado extends Figura {

    public FiguraCuadrado(int fila, int columna) {
        super(fila, columna, "AMARILLO");
    }

    // + X     <- fila 0
    // X X     <- fila 1
    @Override
    public List<Celda> obtenerForma() {
        return Arrays.asList(new Celda(0, 0), new Celda(0, 1),
                             new Celda(1, 0), new Celda(1, 1));
    }

    @Override
    public void rotar() {
        // el cuadrado se ve igual al girar: no hace nada
    }

    @Override
    public void rotarInversa() {
        // igual que arriba
    }
}
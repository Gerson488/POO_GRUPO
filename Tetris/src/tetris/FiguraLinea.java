/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.Arrays;
import java.util.List;

public class FiguraLinea extends Figura {

    public FiguraLinea(int fila, int columna) {
        super(fila, columna, "CELESTE");
    }

    // X + X X     <- fila 0, columnas -1, 0, 1, 2
    @Override
    public List<Celda> obtenerForma() {
        return Arrays.asList(new Celda(0, -1), new Celda(0, 0),
                             new Celda(0, 1), new Celda(0, 2));
    }
}
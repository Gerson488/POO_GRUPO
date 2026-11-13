/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.Arrays;
import java.util.List;

public class FiguraL extends Figura {

    public FiguraL(int fila, int columna) {
        super(fila, columna, "NARANJA");
    }

    //     X       <- fila -1
    // X + X       <- fila 0
    @Override
    public List<Celda> obtenerForma() {
        return Arrays.asList(new Celda(-1, 1), new Celda(0, -1),
                             new Celda(0, 0), new Celda(0, 1));
    }
}
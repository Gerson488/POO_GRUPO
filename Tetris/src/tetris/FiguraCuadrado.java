/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.List;

public class FiguraCuadrado extends Figura {
    public FiguraCuadrado(int fila, int columna) {
        super(fila, columna);
    }

    @Override
    public List<Celda> obtenerForma() {
        return List.of(new Celda(0, 0), new Celda(0, 1), new Celda(1, 0), new Celda(1, 1));
    }

    @Override
    public void rotar() { }           // el cuadrado no cambia al girar

    @Override
    public void rotarInversa() { }
}
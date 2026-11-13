/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

public class Celda {
    private final int fila;
    private final int columna;

    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object otra) {
        if (this == otra) {
            return true;
        }
        if (otra == null || getClass() != otra.getClass()) {
            return false;
        }
        Celda c = (Celda) otra;
        return fila == c.fila && columna == c.columna;
    }

    @Override
    public int hashCode() {
        return 31 * fila + columna;
    }

    @Override
    public String toString() {
        return "(" + fila + "," + columna + ")";
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.ArrayList;
import java.util.List;

public abstract class Figura {
    private int fila;
    private int columna;
    private int rotacion;

    public Figura(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.rotacion = 0;
    }

    public abstract List<Celda> obtenerForma();

    public List<Celda> celdasActuales() {
        List<Celda> resultado = new ArrayList<>();
        for (Celda c : obtenerForma()) {
            int f = c.fila();
            int col = c.columna();
            for (int i = 0; i < rotacion; i++) {
                int nuevaFila = col;
                int nuevaColumna = -f;
                f = nuevaFila;
                col = nuevaColumna;
            }
            resultado.add(new Celda(f, col));
        }
        return resultado;
    }

    public List<Celda> celdasEnTablero() {
        List<Celda> resultado = new ArrayList<>();
        for (Celda c : celdasActuales()) {
            resultado.add(new Celda(c.fila() + fila, c.columna() + columna));
        }
        return resultado;
    }

    public void rotar()          { rotacion = (rotacion + 1) % 4; }
    public void rotarInversa()   { rotacion = (rotacion + 3) % 4; }
    public void moverIzquierda() { columna--; }
    public void moverDerecha()   { columna++; }
    public void moverAbajo()     { fila++; }

    public int getFila()    { return fila; }
    public int getColumna() { return columna; }
}
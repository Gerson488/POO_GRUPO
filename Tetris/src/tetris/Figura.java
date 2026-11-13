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
    private int rotacion;      // de 0 a 3
    private String color;

    public Figura(int fila, int columna, String color) {
        this.fila = fila;
        this.columna = columna;
        this.rotacion = 0;
        this.color = color;
    }

    public abstract List<Celda> obtenerForma();

    public List<Celda> celdasActuales() {
        List<Celda> celdas = obtenerForma();
        for (int i = 0; i < rotacion; i++) {
            List<Celda> giradas = new ArrayList<>();
            for (int j = 0; j < celdas.size(); j++) {
                Celda c = celdas.get(j);
                giradas.add(new Celda(c.getColumna(), -c.getFila()));
            }
            celdas = giradas;
        }
        return celdas;
    }

    public List<Celda> celdasEnTablero() {
        List<Celda> actuales = celdasActuales();
        List<Celda> enTablero = new ArrayList<>();
        for (int i = 0; i < actuales.size(); i++) {
            Celda c = actuales.get(i);
            enTablero.add(new Celda(fila + c.getFila(), columna + c.getColumna()));
        }
        return enTablero;
    }

    public void rotar() {
        rotacion = (rotacion + 1) % 4;
    }

    public void rotarInversa() {
        rotacion = (rotacion + 3) % 4;
    }

    public void moverIzquierda() {
        columna--;
    }

    public void moverDerecha() {
        columna++;
    }

    public void moverAbajo() {
        fila++;
    }

    public void moverArriba() {
        fila--;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getRotacion() {
        return rotacion;
    }

    public String getColor() {
        return color;
    }
}

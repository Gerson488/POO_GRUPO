/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.List;

public class Tablero {
    public static final int FILAS = 20;
    public static final int COLUMNAS = 10;
    private int[][] celdas;
public boolean filaLlena(int fila){
    for (int columna = 0; columna < COLUMNAS; columna++) {
        if (celdas[fila][columna] ==0) {
            return false; // hay un espacio , no está lleno
        }
    }
    return true;//la fila esta llena
}
public int eliminarLineasCompletas() {
    int borradas = 0;
    int fila = FILAS - 1;
    while (fila >= 0) {
        if (filaLlena(fila)) {
            for (int f = fila; f > 0; f--) {
                for (int c = 0; c < COLUMNAS; c++) {
                    celdas[f][c] = celdas[f - 1][c];
                }
            }
            for (int c = 0; c < COLUMNAS; c++) {
                celdas[0][c] = 0;
            }
            borradas++;
        } else {
            fila--;
        }
    }
    return borradas;
}
public Tablero() {
        celdas = new int[FILAS][COLUMNAS];
    }

    public boolean estaLibre(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            return false;
        }
        return celdas[fila][columna] == 0;
    }

    public boolean figuraCabe(Figura figura) {
        List<Celda> celdasFigura = figura.celdasEnTablero();
        for (int i = 0; i < celdasFigura.size(); i++) {
            Celda c = celdasFigura.get(i);
            if (!estaLibre(c.getFila(), c.getColumna())) {
                return false;
            }
        }
        return true;
    }

    public void fijarFigura(Figura figura) {
        List<Celda> celdasFigura = figura.celdasEnTablero();
        for (int i = 0; i < celdasFigura.size(); i++) {
            Celda c = celdasFigura.get(i);
            if (c.getFila() >= 0 && c.getFila() < FILAS
                    && c.getColumna() >= 0 && c.getColumna() < COLUMNAS) {
                celdas[c.getFila()][c.getColumna()] = 1;
            }
        }
    }

    public int getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    public void mostrarTablero(Figura figura) {
        List<Celda> ocupadasPorFigura = figura.celdasEnTablero();
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (ocupadasPorFigura.contains(new Celda(fila, columna))) {
                    System.out.print("X");
                } else if (celdas[fila][columna] == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
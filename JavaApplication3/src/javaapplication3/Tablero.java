/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

public class Tablero {
    private int[][]celdas;
    public Tablero(){
        celdas=new int[20][20];
    }
    public void mostrarTablero(){
        for(int fila=0;fila<celdas.length;fila++){
            for(int columna=0;columna<celdas[fila].length; columna++){
                System.out.print(".");
            }
            System.out.println();
        }
    }
}

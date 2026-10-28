/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author jhon
 */
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
        public void moverDerecha(){
  columna++; 
}
        public void moverIzquierda(){   
 columna--;           
        }

    public abstract int[][] darForma(); // da una matriz de enteros pero no define la forma 
}
   
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author jhon
 */
public class FiguraLinea extends Figura {
        public FiguraLinea(int fila, int columna){
        super (fila,columna);
    }
    @Override
    public int [][]darForma(){
    return new int[][]{
        {0,1,0},
        {0,1,0},
        {0,1,0}
    };
    }
}

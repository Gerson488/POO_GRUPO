/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

public class FiguraS extends Figura {
    public FiguraS(int fila, int columna){
        super (fila,columna);
    }
    @Override
    public int [][]darForma(){
    return new int[][]{
        {0,1,1},
        {0,1,0},
        {1,1,0}
    };
    }
}

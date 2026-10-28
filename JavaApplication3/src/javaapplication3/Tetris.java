/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author jhon
 */
public class Tetris {
    public static void main (String[]args){
      Figura figura1=new FiguraCuadrado(0,0);
      Figura figura2=new FiguraL(0,0);
      int[][]forma1=figura1.darForma();
      int[][] forma2=figura2.darForma();
       System.out.println(forma1);
    }
    
}

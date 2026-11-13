/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

record Punto(int x, int y) {}

public class Practica {
    public static void main(String[] args) {

        Punto p1 = new Punto(1, 2);
        Punto p2 = new Punto(1, 2);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}

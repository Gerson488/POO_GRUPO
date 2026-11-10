/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica;
import java.util.HashMap;
public class Practica {

    public static void main(String[] args) {
HashMap<String,Integer> notas=new HashMap();
   notas.put("A",10);
   System.out.println(notas);
   notas.put("A",20);
   System.out.println("aqui se reemplaza el a el valor "+notas);
    }
}
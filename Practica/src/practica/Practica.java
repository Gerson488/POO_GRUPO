/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.HashMap;
import java.util.Map;

public class Practica{

    public static void main(String[] args) {

        Map<String, Integer> notas = new HashMap<>();

        // 1. Agregamos estudiantes
        notas.put("Carlos", 15);
        notas.put("Maria", 18);
        notas.put("Pedro", 12);

        // 2. Consultamos una nota
        int notaMaria = notas.get("Maria");
        System.out.println("Nota de Maria: " + notaMaria);

        // 3. Modificamos la nota de Carlos
        int notaAnterior = notas.put("Carlos", 20);

        System.out.println("Nota anterior: " + notaAnterior);
        System.out.println("Nota actual: " + notas.get("Carlos"));

        // 4. Agregamos un nuevo estudiante
        Integer resultado = notas.put("Jose", 17);

        System.out.println("Resultado de Jose: " + resultado);

        // 5. Mostramos todo el Mapge
        System.out.println("Todas las notas: " + notas);
    }
}

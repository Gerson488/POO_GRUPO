/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tetris;

public class Tetris {
    public static void main(String[] args) {
        MotorJuego motor = new MotorJuego(new FiguraL(0,5));
        motor.aplicar(Accion.IZQUIERDA);
        motor.aplicar(Accion.ABAJO);
        motor.aplicar(Accion.ROTAR);
        System.out.println(motor.getFigura().celdasEnTablero());

        MotorJuego motor2 = new MotorJuego(new FiguraCuadrado(0, 0));
        motor2.aplicar(Accion.ROTAR);
        System.out.println(motor2.getFigura().celdasEnTablero());
    }
}
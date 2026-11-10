/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

public class MotorJuego {
public void aplicar(int accion) {
    switch (accion) {
        case Accion.IZQUIERDA:
            figura.moverIzquierda();
            break;
        case Accion.DERECHA:
            figura.moverDerecha();
            break;
        case Accion.ABAJO:
            figura.moverAbajo();
            break;
        case Accion.ROTAR:
            figura.rotar();
            break;
        case Accion.NINGUNA:
            break;
    }
}

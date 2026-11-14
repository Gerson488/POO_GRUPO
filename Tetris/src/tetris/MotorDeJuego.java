/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

public class MotorDeJuego {
    private Tablero tablero;
    private Figura figuraActual;
    private EstadoJuego estado;
    private GeneradorFiguras generador;

    public MotorDeJuego(GeneradorFiguras generador) {
        this.generador = generador;
        reiniciar();
    }

    public void reiniciar() {
        this.tablero = new Tablero();
        this.estado = new EstadoJuego();
        this.figuraActual = generador.siguienteFigura(tablero, estado.getNivel());
    }

    public void procesarAccion(int accion) {
        if (estado.isTerminado()) {
            return;
        }
        switch (accion) {
            case Accion.IZQUIERDA:
                figuraActual.moverIzquierda();
                if (!tablero.figuraCabe(figuraActual)) {
                    figuraActual.moverDerecha();
                }
                break;
            case Accion.DERECHA:
                figuraActual.moverDerecha();
                if (!tablero.figuraCabe(figuraActual)) {
                    figuraActual.moverIzquierda();
                }
                break;
            case Accion.ROTAR:
                figuraActual.rotar();
                if (!tablero.figuraCabe(figuraActual)) {
                    figuraActual.rotarInversa();
                }
                break;
            case Accion.ABAJO:
                avanzarTick();
                break;
            default:
                break;
        }
    }

    public void avanzarTick() {
        if (estado.isTerminado()) {
            return;
        }
        figuraActual.moverAbajo();
        if (!tablero.figuraCabe(figuraActual)) {
            figuraActual.moverArriba();
            tablero.fijarFigura(figuraActual);
            int borradas = tablero.eliminarLineasCompletas();
            estado.registrarLineas(borradas);

            figuraActual = generador.siguienteFigura(tablero, estado.getNivel());
            if (!tablero.figuraCabe(figuraActual)) {
                estado.setTerminado(true);
            }
        }
    }

    public void setGenerador(GeneradorFiguras nuevoGenerador) {
        this.generador = nuevoGenerador;
    }

    public Tablero getTablero() { return tablero; }
    public Figura getFiguraActual() { return figuraActual; }
    public EstadoJuego getEstado() { return estado; }
}

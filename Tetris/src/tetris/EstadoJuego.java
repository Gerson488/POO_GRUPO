/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

public class EstadoJuego {
    private int puntos;
    private int lineas;
    private int nivel;
    private boolean terminado;

    public EstadoJuego() {
        this.puntos = 0;
        this.lineas = 0;
        this.nivel = 1;
        this.terminado = false;
    }

    public void registrarLineas(int borradas) {
        if (borradas > 0) {
            this.lineas += borradas;
            this.puntos += borradas * 100 * nivel;
            this.nivel = (this.lineas / 10) + 1;
        }
    }

    public int getPuntos() { return puntos; }
    public int getLineas() { return lineas; }
    public int getNivel() { return nivel; }
    public boolean isTerminado() { return terminado; }
    public void setTerminado(boolean terminado) { this.terminado = terminado; }
}
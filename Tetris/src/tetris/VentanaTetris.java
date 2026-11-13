/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

public class VentanaTetris extends JPanel {
    private static final int TAM = 30;

    private Tablero tablero = new Tablero();
    private Figura figura;
    private Random random = new Random();

    public VentanaTetris() {
        setPreferredSize(new Dimension(Tablero.COLUMNAS * TAM, Tablero.FILAS * TAM));
        setFocusable(true);
        figura = nuevaFigura();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclaPresionada(e.getKeyCode());
            }
        });

        new javax.swing.Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bajar();
            }
        }).start();
    }

    private Figura nuevaFigura() {
        switch (random.nextInt(7)) {
            case 0: return new FiguraLinea(1, 5);
            case 1: return new FiguraCuadrado(1, 5);
            case 2: return new FiguraT(1, 5);
            case 3: return new FiguraS(1, 5);
            case 4: return new FiguraZ(1, 5);
            case 5: return new FiguraJ(1, 5);
            default: return new FiguraL(1, 5);
        }
    }

 private void bajar() {
    figura.moverAbajo();
    if (!tablero.figuraCabe(figura)) {
        figura.moverArriba();
        tablero.fijarFigura(figura);
        tablero.eliminarLineasCompletas();   // <- LINEA NUEVA
        figura = nuevaFigura();
        if (!tablero.figuraCabe(figura)) {
            tablero = new Tablero();   // provisional
        }
    }
    repaint();
}
    

    private void teclaPresionada(int tecla) {
        switch (tecla) {
            case KeyEvent.VK_LEFT:
                figura.moverIzquierda();
                if (!tablero.figuraCabe(figura)) {
                    figura.moverDerecha();
                }
                break;
            case KeyEvent.VK_RIGHT:
                figura.moverDerecha();
                if (!tablero.figuraCabe(figura)) {
                    figura.moverIzquierda();
                }
                break;
            case KeyEvent.VK_UP:
                figura.rotar();
                if (!tablero.figuraCabe(figura)) {
                    figura.rotarInversa();
                }
                break;
            case KeyEvent.VK_DOWN:
                bajar();
                break;
            default:
                break;
        }
        repaint();
    }

    private Color traducirColor(String nombre) {
        switch (nombre) {
            case "CELESTE": return Color.CYAN;
            case "AMARILLO": return Color.YELLOW;
            case "MORADO": return new Color(150, 0, 200);
            case "VERDE": return Color.GREEN;
            case "ROJO": return Color.RED;
            case "AZUL": return Color.BLUE;
            case "NARANJA": return Color.ORANGE;
            default: return Color.WHITE;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        g.setColor(Color.GRAY);
        for (int fila = 0; fila < Tablero.FILAS; fila++) {
            for (int columna = 0; columna < Tablero.COLUMNAS; columna++) {
                if (tablero.getCelda(fila, columna) == 1) {
                    g.fillRect(columna * TAM, fila * TAM, TAM - 1, TAM - 1);
                }
            }
        }

        g.setColor(traducirColor(figura.getColor()));
        List<Celda> celdasFigura = figura.celdasEnTablero();
        for (int i = 0; i < celdasFigura.size(); i++) {
            Celda c = celdasFigura.get(i);
            g.fillRect(c.getColumna() * TAM, c.getFila() * TAM, TAM - 1, TAM - 1);
        }
    }
}
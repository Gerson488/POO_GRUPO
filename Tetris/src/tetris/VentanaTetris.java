package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPanel;

public class VentanaTetris extends JPanel {
    private static final int TAM = 30;
    private MotorDeJuego motor;

    public VentanaTetris() {
        this.motor = new MotorDeJuego(new GeneradorBolsa());
        setPreferredSize(new Dimension(Tablero.COLUMNAS * TAM, Tablero.FILAS * TAM));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclaPresionada(e.getKeyCode());
            }
        });

        new javax.swing.Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                motor.avanzarTick();
                repaint();
            }
        }).start();
    }

    private void teclaPresionada(int tecla) {
        if (motor.getEstado().isTerminado() && tecla == KeyEvent.VK_R) {
            motor.reiniciar();
            repaint();
            return;
        }
        switch (tecla) {
            case KeyEvent.VK_LEFT:
                motor.procesarAccion(Accion.IZQUIERDA);
                break;
            case KeyEvent.VK_RIGHT:
                motor.procesarAccion(Accion.DERECHA);
                break;
            case KeyEvent.VK_UP:
                motor.procesarAccion(Accion.ROTAR);
                break;
            case KeyEvent.VK_DOWN:
                motor.procesarAccion(Accion.ABAJO);
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

        Tablero tablero = motor.getTablero();
        g.setColor(Color.GRAY);
        for (int fila = 0; fila < Tablero.FILAS; fila++) {
            for (int columna = 0; columna < Tablero.COLUMNAS; columna++) {
                if (tablero.getCelda(fila, columna) == 1) {
                    g.fillRect(columna * TAM, fila * TAM, TAM - 1, TAM - 1);
                }
            }
        }

        Figura figura = motor.getFiguraActual();
        if (figura != null) {
            g.setColor(traducirColor(figura.getColor()));
            List<Celda> celdasFigura = figura.celdasEnTablero();
            for (int i = 0; i < celdasFigura.size(); i++) {
                Celda c = celdasFigura.get(i);
                g.fillRect(c.getColumna() * TAM, c.getFila() * TAM, TAM - 1, TAM - 1);
            }
        }

        EstadoJuego estado = motor.getEstado();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Puntos: " + estado.getPuntos() + "  Lineas: " + estado.getLineas() + "  Nivel: " + estado.getNivel(), 10, 20);

        if (estado.isTerminado()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("GAME OVER (R: Reiniciar)", 15, (Tablero.FILAS * TAM) / 2);
        }
    }
}
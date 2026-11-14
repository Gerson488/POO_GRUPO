package tetris;

import java.util.Random;

public class GeneradorAleatorio implements GeneradorFiguras {
    private Random random = new Random();

    @Override
    public Figura siguienteFigura(Tablero tablero, int nivel) {
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
}
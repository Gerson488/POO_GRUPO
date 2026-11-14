package tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneradorBolsa implements GeneradorFiguras {
    private List<Integer> bolsa = new ArrayList<>();

    private void rellenarBolsa() {
        bolsa.clear();
        for (int i = 0; i < 7; i++) {
            bolsa.add(i);
        }
        Collections.shuffle(bolsa);
    }

    @Override
    public Figura siguienteFigura(Tablero tablero, int nivel) {
        if (bolsa.isEmpty()) {
            rellenarBolsa();
        }
        int tipo = bolsa.remove(0);
        switch (tipo) {
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
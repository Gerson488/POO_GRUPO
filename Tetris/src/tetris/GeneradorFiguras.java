package tetris;

public interface GeneradorFiguras {
    Figura siguienteFigura(Tablero tablero, int nivel);
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tetris;

import javax.swing.JFrame;

public class Tetris {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Tetris");
        VentanaTetris panel = new VentanaTetris();
        marco.add(panel);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        panel.requestFocusInWindow();
        
    }
}
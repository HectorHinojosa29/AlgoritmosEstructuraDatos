package Actividad2;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;

public class PythagorasTree extends JPanel {
    private int profundidad;

    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Fondo negro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Color del árbol
        g2d.setColor(Color.GREEN);

        // Llamada inicial a la función recursiva
        trazaArbol(g2d, 400, 700, 100, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;

        // Coordenadas del segundo punto de la línea
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        // Dibuja la línea
        g.drawLine(x, y, x2, y2);

        // Nuevo tamaño del lado para las ramas
        int nuevoLado = (int) (lado * 0.7);

        // Llamadas recursivas para las dos ramas
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

    // Método para mostrar la ventana con el árbol
    public static void main(String[] args) {
        JFrame frame = new JFrame("Árbol de Pitágoras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PythagorasTree(100)); // Cambiá el número para más o menos profundidad
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

package Actividad2;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Crear el frame
        JFrame ventana = new JFrame("Árbol de Pitágoras");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia del panel con profundidad deseada
        PythagorasTree arbol = new PythagorasTree(100000); // Puedes cambiar la profundidad

        // Agregar el panel al frame
        ventana.add(arbol);
        ventana.pack();
        ventana.setLocationRelativeTo(null); // Centrar la ventana
        ventana.setVisible(true);
    }
}
package matrodriguezpa.expensetracker;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JButton boton;
    private JLabel etiqueta;
    private Model modelo;

    public View(Model modelo) {
        this.modelo = modelo;
        setTitle("Ejemplo MVC con Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boton = new JButton("Presioname");
        etiqueta = new JLabel();

        // Creamos un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(boton);
        panel.add(etiqueta);

        add(panel);

        pack();
        setVisible(true);
    }

    public JButton getBoton() {
        return boton;
    }

    public void setMensaje(String mensaje) {
        etiqueta.setText(mensaje);
    }
}
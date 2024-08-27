package matrodriguezpa.expensetracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View vista;
    private Model modelo;

    public Controller(View vista, Model modelo) {
        this.vista = vista;
        this.modelo = modelo;

        vista.getBoton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBoton()) {
            vista.setMensaje(modelo.getMensaje());
        }
    }
}
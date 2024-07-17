package Controller;

import View.*;
import Model.*;
import java.awt.Color;

public class Controller {

    private Model model;
    private View view;

    public void start(View myView, Model myModel) {
        view = myView;
        model = myModel;

        view.setVisible(true);
    }

    public void cargarExcel() {
        model.setEgresos(View.selectedFile.getName());
        egresos.tm.addRow(model.getEgresos());
    }

}

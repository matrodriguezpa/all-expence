package control;

import view.*;
import model.*;

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
        //expenses.tm.addRow(model.getEgresos());
    }

}

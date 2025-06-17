package matrodriguezpa.allexpence;

import matrodriguezpa.allexpence.controller.Controller;
import matrodriguezpa.allexpence.model.model;
import matrodriguezpa.allexpence.view.View;

public class AllExpence {

    public static void main(String[] args) {
        
        model model = new model();
        View view = new View();
        Controller controller = new Controller(model, view);
        
        controller.start();
    }
}

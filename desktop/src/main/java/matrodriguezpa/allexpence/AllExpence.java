package matrodriguezpa.allexpence;

import matrodriguezpa.allexpence.controller.ProjectController;
import matrodriguezpa.allexpence.model.DatabaseModel;
import matrodriguezpa.allexpence.view.Main;

public class AllExpence {

    public static void main(String[] args) {
        DatabaseModel model = new DatabaseModel();
        Main view = new Main();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
        
    }
}

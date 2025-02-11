package matrodriguezpa.onespencer;

import matrodriguezpa.onespencer.controller.ProjectController;
import matrodriguezpa.onespencer.model.DatabaseModel;
import matrodriguezpa.onespencer.view.Main;

public class OneSpencer {

    public static void main(String[] args) {
        DatabaseModel model = new DatabaseModel();
        Main view = new Main();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
        
    }
}

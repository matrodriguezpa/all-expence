package matrodriguezpa.onespencer;

import matrodriguezpa.onespencer.controller.ProjectController;
import matrodriguezpa.onespencer.model.DatabaseModel;
import matrodriguezpa.onespencer.view.Project;

public class OneSpencer {

    public static void main(String[] args) {
        DatabaseModel model = new DatabaseModel();
        Project view = new Project();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
        
    }
}

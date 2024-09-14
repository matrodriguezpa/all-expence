package matrodriguezpa.onespencer;

import matrodriguezpa.onespencer.controller.ProjectController;
import matrodriguezpa.onespencer.model.DatabaseModel;
import matrodriguezpa.onespencer.view.ProjectView;

public class OneSpencer {

    public static void main(String[] args) {
        DatabaseModel model = new DatabaseModel();
        ProjectView view = new ProjectView();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
    }
}

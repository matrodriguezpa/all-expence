package matrodriguezpa.allexpence;

import matrodriguezpa.allexpence.controller.ProjectController;
import matrodriguezpa.allexpence.model.project;
import matrodriguezpa.allexpence.view.Main;

public class AllExpence {

    public static void main(String[] args) {
        project model = new project();
        Main view = new Main();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
        
    }
}

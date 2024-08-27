package matrodriguezpa.receiptmanager;

import matrodriguezpa.receiptmanager.controller.ProjectController;
import matrodriguezpa.receiptmanager.model.Project;
import matrodriguezpa.receiptmanager.view.MainView;

public class ReceiptManager {

    public static void main(String[] args) {
        Project model = new Project();
        MainView view = new MainView();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
    }
}

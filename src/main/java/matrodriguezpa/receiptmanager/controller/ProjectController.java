package matrodriguezpa.receiptmanager.controller;

import matrodriguezpa.receiptmanager.model.Project;
import matrodriguezpa.receiptmanager.view.MainView;

public class ProjectController {

    private Project model;
    private MainView view;
    
    public ProjectController(Project model, MainView view) {
        this.model=model;
        this.view=view;
    }

    public void start() {
        view.setVisible(true);
    }
}

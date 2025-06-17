package matrodriguezpa.allexpence;

import matrodriguezpa.allexpence.controller.MainController;
import matrodriguezpa.allexpence.model.MainModel;
import matrodriguezpa.allexpence.view.View;

public class Main {

    public static void main(String[] args) {
        
        MainModel model = new MainModel();
        View view = new View();
        MainController controller = new MainController(view, model);

        controller.start();
    }
}

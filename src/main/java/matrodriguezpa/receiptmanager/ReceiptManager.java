package matrodriguezpa.receiptmanager;

import matrodriguezpa.receiptmanager.controller.Controller;
import matrodriguezpa.receiptmanager.model.Model;
import matrodriguezpa.receiptmanager.view.View;

public class ReceiptManager {

    public static void main(String[] args) {
        
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        
        controller.start();
    }
}


import View.*;
import Controller.*;
import Model.*;

public class Main {

    public static void main(String[] args) {
        View myView = new View();
        Controller myController = new Controller();
        HomeModel myModel = new HomeModel();

        myController.start(myView, myModel);
    }

}

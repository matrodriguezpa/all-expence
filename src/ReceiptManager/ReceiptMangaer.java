package ReceiptManager;


import View.View;
import Controller.Controller;
import Model.Model;

public class ReceiptMangaer {

    public static void main(String[] args) {
        View myView = new View();
        Controller myController = new Controller();
        Model myModel = new Model();

        myController.start(myView, myModel);
    }

}

package Controller;

import View.*;
import Model.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class Controller {

    private HomeModel model;
    private View view;
    ReceiptView myReceipt = new ReceiptView();
    StatsView myStats = new StatsView();
    HistoryView myHistory = new HistoryView();

    public void start(View myView, HomeModel myModel) {
        this.view = myView;
        this.model = myModel;

        view.setVisible(true);
        //myModel.loadReceipts
        //myModel.loadData 
        //myModel.loadHistory
        
        view.Main.add(myReceipt, "Receipts");
        view.Main.add(myStats,"Stats");
        view.Main.add(myHistory,"History");
        }
    
    //Modulo de recibos
    
    
}

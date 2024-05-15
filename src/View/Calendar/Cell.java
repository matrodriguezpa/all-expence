package View.Calendar;

import java.time.*;

public class Cell extends javax.swing.JPanel {

    public LocalDateTime ldt;
    public DayOfWeek dow;
    public int dom;
    public Month month;
    public int year;
    
    public Cell() {
        initComponents();
        
        this.ldt = LocalDateTime.now();
        this.dow = ldt.getDayOfWeek();
        this.dom = ldt.getDayOfMonth();
        this.month = ldt.getMonth();
        this.year = ldt.getYear();
    }
    
    public int getMonth(){
    return dom;
    }
    
    public int getYear(){
    return year;
    }
        
    public void addDays(int daysToAdd){
        this.ldt = ldt.plusDays(daysToAdd);
        
        this.dow = ldt.getDayOfWeek();
        this.dom = ldt.getDayOfMonth();
        this.month = ldt.getMonth();
        this.year = ldt.getYear();
        
        dowText.setText(dow.toString());
        domText.setText(Integer.toString(dom));
    }
        
    public void plusWeeks(int weeksToAdd){
        this.ldt = ldt.plusWeeks(weeksToAdd);
        
        this.dow = ldt.getDayOfWeek();
        this.dom = ldt.getDayOfMonth();
        this.month = ldt.getMonth();
        this.year = ldt.getYear();
        
        dowText.setText( dow.toString());
        domText.setText(Integer.toString(dom));
    }
    
    public void minusWeeks(int weeksToRest){
        this.ldt = ldt.minusWeeks(weeksToRest);
        
        this.dow = ldt.getDayOfWeek();
        this.dom = ldt.getDayOfMonth();
        this.month = ldt.getMonth();
        this.year = ldt.getYear();
        
        dowText.setText( dow.toString());
        domText.setText(Integer.toString(dom));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dowText = new javax.swing.JLabel();
        domText = new javax.swing.JLabel();

        setBackground(java.awt.Color.darkGray);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        dowText.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        dowText.setText("dow");
        add(dowText);

        domText.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        domText.setText("dom");
        add(domText);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel domText;
    private javax.swing.JLabel dowText;
    // End of variables declaration//GEN-END:variables
}

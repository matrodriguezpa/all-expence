package IU.Calendar;

import IU.Cards.Cards;

public class Column extends javax.swing.JPanel {

   Cell cell = new Cell();
   Cards cards = new Cards();
   
    public Column() {
        initComponents();
        jPanel1.add(cell);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setBackground(null);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.darkGray, 2));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

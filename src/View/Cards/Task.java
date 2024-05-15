package View.Cards;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Task extends javax.swing.JPanel {
        
    String name;
    int label;
    Date start;
    Date end;
    String description;
    
    public Task() {
        initComponents();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getLabel() {
        return label;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getDescription() {
        return description;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(java.awt.Color.gray);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setText("Inicio - Final");
        jPanel1.add(jLabel2);

        jLabel4.setText("Descripción");
        jPanel1.add(jLabel4);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Nombre");
        jPanel2.add(jLabel1);

        jLabel3.setText("Etiqueta");
        jPanel2.add(jLabel3);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

package View.Calendar;

import java.util.ArrayList;
import java.time.*;

public class View extends javax.swing.JPanel {
    
    ArrayList<Column> week = new ArrayList<>();
    Column column;
    
    public LocalDateTime ldt;

    public View() {
        initComponents();

        for (int i = 0; i < 7; i++) {
            column = new Column();
            column.cell.addDays(i);
            Format.add(column);
            week.add(column);
        }
        MonthText.setText(column.cell.month.toString());
        YearText.setText(Integer.toString(column.cell.year) );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Format = new javax.swing.JPanel();
        CalendarNav = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        YearText = new javax.swing.JLabel();
        MonthText = new javax.swing.JLabel();
        PreviusWeek = new javax.swing.JButton();
        NextWeek = new javax.swing.JButton();

        setBackground(null);
        setLayout(new java.awt.BorderLayout());

        Format.setBackground(java.awt.Color.gray);
        Format.setLayout(new java.awt.GridLayout(1, 7));
        add(Format, java.awt.BorderLayout.CENTER);

        CalendarNav.setBackground(new java.awt.Color(0, 153, 153));
        CalendarNav.setLayout(new javax.swing.BoxLayout(CalendarNav, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        YearText.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        YearText.setForeground(java.awt.Color.white);
        YearText.setText("Year");
        jPanel1.add(YearText);

        MonthText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MonthText.setForeground(java.awt.Color.white);
        MonthText.setText("Month");
        jPanel1.add(MonthText);

        CalendarNav.add(jPanel1);

        PreviusWeek.setBackground(new java.awt.Color(0, 153, 153));
        PreviusWeek.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        PreviusWeek.setForeground(java.awt.Color.white);
        PreviusWeek.setText("Previus");
        PreviusWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviusWeekActionPerformed(evt);
            }
        });
        CalendarNav.add(PreviusWeek);

        NextWeek.setBackground(new java.awt.Color(0, 153, 153));
        NextWeek.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NextWeek.setForeground(java.awt.Color.white);
        NextWeek.setText("Next");
        NextWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextWeekActionPerformed(evt);
            }
        });
        CalendarNav.add(NextWeek);

        add(CalendarNav, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void PreviusWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviusWeekActionPerformed
        for(Column column:week){
            column.cell.minusWeeks(1);
            MonthText.setText(column.cell.month.toString());
            YearText.setText(Integer.toString(column.cell.year) );
        }
    }//GEN-LAST:event_PreviusWeekActionPerformed

    private void NextWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextWeekActionPerformed
        for(Column column:week){
            column.cell.plusWeeks(1);
            MonthText.setText(column.cell.month.toString());
            YearText.setText(Integer.toString(column.cell.year) );
        }
    }//GEN-LAST:event_NextWeekActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CalendarNav;
    private javax.swing.JPanel Format;
    private javax.swing.JLabel MonthText;
    private javax.swing.JButton NextWeek;
    private javax.swing.JButton PreviusWeek;
    private javax.swing.JLabel YearText;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}


package View.Screen;

import View.Screen.Budget;
import View.Calendar.Calendar;
import View.Screen.Home;
import View.Screen.Record;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends javax.swing.JPanel implements ActionListener{

    Home home = new Home();
    Calendar calendar = new Calendar();
    Budget budget = new Budget();
    Record record = new Record();
    
    public Screen() {
        initComponents();
        
        Main.add(home);
        home.setVisible(true);
        
        ButtonHome.addActionListener(this);
        ButtonCalendar.addActionListener(this);
        ButtonBudget.addActionListener(this);
        ButtonRecord.addActionListener(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroupScreenNavigation = new javax.swing.ButtonGroup();
        Main = new javax.swing.JPanel();
        NavitagionMenu = new javax.swing.JPanel();
        ButtonHome = new javax.swing.JRadioButton();
        ButtonCalendar = new javax.swing.JRadioButton();
        ButtonBudget = new javax.swing.JRadioButton();
        ButtonRecord = new javax.swing.JRadioButton();

        setLayout(new java.awt.BorderLayout());

        Main.setBackground(java.awt.Color.white);
        Main.setLayout(new java.awt.BorderLayout());

        NavitagionMenu.setBackground(new java.awt.Color(0, 153, 153));
        NavitagionMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 20));
        NavitagionMenu.setLayout(new javax.swing.BoxLayout(NavitagionMenu, javax.swing.BoxLayout.Y_AXIS));

        ButtonGroupScreenNavigation.add(ButtonHome);
        ButtonHome.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonHome.setForeground(java.awt.Color.white);
        ButtonHome.setSelected(true);
        ButtonHome.setText("Inicio");
        ButtonHome.setToolTipText("");
        ButtonHome.setIconTextGap(0);
        ButtonHome.setMaximumSize(new java.awt.Dimension(200, 20));
        ButtonHome.setMinimumSize(new java.awt.Dimension(20, 20));
        ButtonHome.setName(""); // NOI18N
        ButtonHome.setPreferredSize(new java.awt.Dimension(80, 20));
        ButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHomeActionPerformed(evt);
            }
        });
        NavitagionMenu.add(ButtonHome);

        ButtonGroupScreenNavigation.add(ButtonCalendar);
        ButtonCalendar.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonCalendar.setForeground(java.awt.Color.white);
        ButtonCalendar.setText("Calendario");
        NavitagionMenu.add(ButtonCalendar);

        ButtonGroupScreenNavigation.add(ButtonBudget);
        ButtonBudget.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonBudget.setForeground(java.awt.Color.white);
        ButtonBudget.setText("Presupuesto");
        NavitagionMenu.add(ButtonBudget);

        ButtonGroupScreenNavigation.add(ButtonRecord);
        ButtonRecord.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonRecord.setForeground(java.awt.Color.white);
        ButtonRecord.setText("Recibos");
        NavitagionMenu.add(ButtonRecord);

        Main.add(NavitagionMenu, java.awt.BorderLayout.LINE_START);

        add(Main, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ButtonBudget;
    private javax.swing.JRadioButton ButtonCalendar;
    private javax.swing.ButtonGroup ButtonGroupScreenNavigation;
    private javax.swing.JRadioButton ButtonHome;
    private javax.swing.JRadioButton ButtonRecord;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel NavitagionMenu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object evt = e.getSource();
        if (evt.equals(ButtonHome)){
            
            home.setVisible(true);
            calendar.setVisible(false);
            budget.setVisible(false);
            budget.setVisible(false);
            
            Main.add(home);
            Main.validate();
            
        }
        else if (evt.equals(ButtonCalendar)){
            
            home.setVisible(false);
            calendar.setVisible(true);
            budget.setVisible(false);
            record.setVisible(false);
            
            Main.add(calendar);
            Main.validate();
            
        }
        else if (evt.equals(ButtonBudget)){
            
            home.setVisible(false);
            calendar.setVisible(false);
            budget.setVisible(true);
            record.setVisible(false);
            
            Main.add(budget);
            Main.validate();
            
        }
        else if (evt.equals(ButtonRecord)){
            
            home.setVisible(false);
            calendar.setVisible(false);
            budget.setVisible(false);
            record.setVisible(true);
            
            Main.add(record);
            Main.validate();
            
        }
        
    }
}

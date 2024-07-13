package View;

public class Screen extends javax.swing.JFrame{
    
    public Screen() {
        initComponents(); 
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainNavigation = new javax.swing.ButtonGroup();
        Main = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        Tittle = new javax.swing.JLabel();
        ButtonSettings = new javax.swing.JButton();
        Sidebar = new javax.swing.JPanel();
        ButtonCalendar = new javax.swing.JRadioButton();
        ButtonBudget = new javax.swing.JRadioButton();
        ButtonRecord = new javax.swing.JRadioButton();
        ScrollPane = new javax.swing.JScrollPane();
        Welcome = new javax.swing.JPanel();
        WelcomeMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 450));

        Main.setBackground(java.awt.Color.white);
        Main.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(153, 153, 255));
        Header.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Header.setLayout(new java.awt.BorderLayout());

        Tittle.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        Tittle.setForeground(new java.awt.Color(0, 0, 0));
        Tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tittle.setText("Receipt Manager");
        Header.add(Tittle, java.awt.BorderLayout.CENTER);

        ButtonSettings.setBackground(new java.awt.Color(0, 102, 102));
        ButtonSettings.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ButtonSettings.setForeground(java.awt.Color.white);
        ButtonSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Settings.png"))); // NOI18N
        ButtonSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainNavigation.add(ButtonSettings);
        ButtonSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonSettings.setMaximumSize(new java.awt.Dimension(40, 40));
        ButtonSettings.setMinimumSize(new java.awt.Dimension(40, 40));
        ButtonSettings.setPreferredSize(new java.awt.Dimension(40, 40));
        ButtonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSettingsActionPerformed(evt);
            }
        });
        Header.add(ButtonSettings, java.awt.BorderLayout.EAST);

        Main.add(Header, java.awt.BorderLayout.PAGE_START);

        Sidebar.setBackground(new java.awt.Color(204, 204, 255));
        Sidebar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODULOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(102, 102, 102)), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10))); // NOI18N
        Sidebar.setLayout(new javax.swing.BoxLayout(Sidebar, javax.swing.BoxLayout.Y_AXIS));

        MainNavigation.add(ButtonCalendar);
        ButtonCalendar.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonCalendar.setForeground(new java.awt.Color(0, 0, 0));
        ButtonCalendar.setText("Recibos");
        ButtonCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCalendarActionPerformed(evt);
            }
        });
        Sidebar.add(ButtonCalendar);

        MainNavigation.add(ButtonBudget);
        ButtonBudget.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonBudget.setForeground(new java.awt.Color(0, 0, 0));
        ButtonBudget.setText("Estadísticas");
        Sidebar.add(ButtonBudget);

        MainNavigation.add(ButtonRecord);
        ButtonRecord.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        ButtonRecord.setForeground(new java.awt.Color(0, 0, 0));
        ButtonRecord.setText("Historial");
        ButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecordActionPerformed(evt);
            }
        });
        Sidebar.add(ButtonRecord);

        Main.add(Sidebar, java.awt.BorderLayout.WEST);

        ScrollPane.setBorder(null);

        Welcome.setBackground(java.awt.Color.white);
        Welcome.setLayout(new java.awt.BorderLayout());

        WelcomeMessage.setForeground(java.awt.Color.black);
        WelcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeMessage.setText("Bienvenido, seleccione  un modulo para empezar");
        Welcome.add(WelcomeMessage, java.awt.BorderLayout.CENTER);

        ScrollPane.setViewportView(Welcome);

        Main.add(ScrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSettingsActionPerformed

    private void ButtonCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCalendarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCalendarActionPerformed

    private void ButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ButtonBudget;
    private javax.swing.JRadioButton ButtonCalendar;
    private javax.swing.JRadioButton ButtonRecord;
    private javax.swing.JButton ButtonSettings;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.ButtonGroup MainNavigation;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JLabel Tittle;
    private javax.swing.JPanel Welcome;
    private javax.swing.JLabel WelcomeMessage;
    // End of variables declaration//GEN-END:variables

}


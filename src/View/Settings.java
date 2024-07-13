
package View;

public class Settings extends javax.swing.JPanel {

    
    public Settings() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroupSettingsNavigation = new javax.swing.ButtonGroup();
        SettingsScreens = new javax.swing.JPanel();
        Account = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Desing = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        Error = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setLayout(new java.awt.BorderLayout());

        SettingsScreens.setBackground(new java.awt.Color(255, 255, 255));
        SettingsScreens.setForeground(new java.awt.Color(51, 51, 51));
        SettingsScreens.setLayout(new javax.swing.BoxLayout(SettingsScreens, javax.swing.BoxLayout.Y_AXIS));

        Account.setBackground(new java.awt.Color(255, 255, 255));
        Account.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Opciones de cuenta");
        Account.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        SettingsScreens.add(Account);

        Desing.setBackground(new java.awt.Color(255, 255, 255));
        Desing.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Opciones de diseño");
        Desing.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Modo de pantalla");
        jPanel5.add(jLabel4);

        jRadioButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton5.setText("Claro");
        jPanel5.add(jRadioButton5);

        jRadioButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton4.setText("Oscuro");
        jPanel5.add(jRadioButton4);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fuente de texto");
        jPanel6.add(jLabel6);

        jRadioButton11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton11.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton11.setText("Fuente 1");
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton11);

        jRadioButton10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton10.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton10.setText("Fuente 2");
        jPanel6.add(jRadioButton10);

        jRadioButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton9.setText("Fuente 3");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton9);

        jPanel2.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tamaño de texto");
        jPanel7.add(jLabel5);

        jRadioButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton6.setText("Pequeño");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton6);

        jRadioButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton7.setText("Mediano");
        jPanel7.add(jRadioButton7);

        jRadioButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton8.setText("Grande");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton8);

        jPanel2.add(jPanel7);

        Desing.add(jPanel2, java.awt.BorderLayout.CENTER);

        SettingsScreens.add(Desing);

        Error.setBackground(new java.awt.Color(255, 255, 255));
        Error.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Notificar un error");
        Error.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        SettingsScreens.add(Error);

        add(SettingsScreens, java.awt.BorderLayout.CENTER);

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Guardar cambios");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Account;
    private javax.swing.ButtonGroup ButtonGroupSettingsNavigation;
    private javax.swing.JPanel Desing;
    private javax.swing.JPanel Error;
    private javax.swing.JPanel SettingsScreens;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}


package View;

public class matriz extends javax.swing.JPanel {

    public matriz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        top = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jComboBox2 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        center = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        bottom = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 50));
        top.setRightComponent(jLabel1);

        jToolBar2.setRollover(true);
        jToolBar2.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setMinimumSize(new java.awt.Dimension(150, 22));
        jComboBox2.setPreferredSize(new java.awt.Dimension(150, 20));
        jToolBar2.add(jComboBox2);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Primer trimestre");
        jRadioButton1.setFocusable(false);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton1.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jRadioButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Segundo trimestre");
        jRadioButton2.setFocusable(false);
        jRadioButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton2.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jRadioButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jRadioButton2);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Tercer trimestre");
        jRadioButton3.setFocusable(false);
        jRadioButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton3.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jRadioButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jRadioButton3);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Todos los meses");
        jRadioButton4.setFocusable(false);
        jRadioButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jRadioButton4);

        top.setLeftComponent(jToolBar2);

        add(top, java.awt.BorderLayout.PAGE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(460, 400));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre en especial"));
        jScrollPane2.setInheritsPopupMenu(true);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(1200, 200));
        jScrollPane2.setName(""); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable2.setName("NOMBRE"); // NOI18N
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre en especial"));
        jScrollPane4.setInheritsPopupMenu(true);
        jScrollPane4.setMaximumSize(new java.awt.Dimension(1200, 200));
        jScrollPane4.setName(""); // NOI18N

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable4.setName("NOMBRE"); // NOI18N
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre en especial"));
        jScrollPane5.setInheritsPopupMenu(true);
        jScrollPane5.setMaximumSize(new java.awt.Dimension(1200, 200));
        jScrollPane5.setName(""); // NOI18N

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable5.setName("NOMBRE"); // NOI18N
        jScrollPane5.setViewportView(jTable5);

        jPanel1.add(jScrollPane5);

        center.setViewportView(jPanel1);

        add(center, java.awt.BorderLayout.CENTER);

        bottom.setMaximumSize(new java.awt.Dimension(32767, 40));
        bottom.setPreferredSize(new java.awt.Dimension(452, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bottom.setViewportView(jTable1);

        add(bottom, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bottom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane center;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JSplitPane top;
    // End of variables declaration//GEN-END:variables
}


package view;


public class Resume extends javax.swing.JPanel {

    public Resume() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JToolBar();
        gasto = new javax.swing.JComboBox<>();
        matriz = new javax.swing.JComboBox<>();
        razonSocial = new javax.swing.JComboBox<>();
        monto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
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

        top.setBackground(java.awt.Color.white);
        top.setBorder(null);

        gasto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        top.add(gasto);

        matriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        top.add(matriz);

        razonSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        top.add(razonSocial);

        monto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        top.add(monto);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total General: 9999");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 50, 0, 50));
        top.add(jLabel4);

        add(top, java.awt.BorderLayout.NORTH);

        center.setMaximumSize(new java.awt.Dimension(32767, 900));

        jPanel1.setPreferredSize(new java.awt.Dimension(490, 400));
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

        bottom.setBackground(java.awt.Color.white);
        bottom.setMaximumSize(new java.awt.Dimension(32767, 40));
        bottom.setPreferredSize(new java.awt.Dimension(452, 40));

        jTable1.setBackground(java.awt.Color.white);
        jTable1.setForeground(java.awt.Color.lightGray);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(java.awt.Color.white);
        bottom.setViewportView(jTable1);

        add(bottom, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bottom;
    private javax.swing.JScrollPane center;
    private javax.swing.JComboBox<String> gasto;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JComboBox<String> matriz;
    private javax.swing.JComboBox<String> monto;
    private javax.swing.JComboBox<String> razonSocial;
    private javax.swing.JToolBar top;
    // End of variables declaration//GEN-END:variables
}

package view;

public class Transfers extends javax.swing.JPanel {

    
    public Transfers() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        left = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        center = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rigth = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("TABLA DE MESES (FECHA)");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Julio");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Junio");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTree1.setPreferredSize(new java.awt.Dimension(160, 56));
        left.setViewportView(jTree1);

        add(left, java.awt.BorderLayout.WEST);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        center.setViewportView(jTable1);

        add(center, java.awt.BorderLayout.CENTER);

        rigth.setBackground(java.awt.Color.white);
        rigth.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar datos"));
        rigth.setForeground(java.awt.Color.white);
        rigth.setName(""); // NOI18N
        rigth.setPreferredSize(new java.awt.Dimension(200, 259));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0};
        jPanel1Layout.rowHeights = new int[] {0, 20, 0, 20, 0, 20, 0, 20, 0};
        rigth.setLayout(jPanel1Layout);

        jTextField3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Gasto:")));
        jTextField3.setPreferredSize(new java.awt.Dimension(140, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        rigth.add(jTextField3, gridBagConstraints);

        jTextField2.setToolTipText("$0");
        jTextField2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Establecimiento:")));
        jTextField2.setDisabledTextColor(java.awt.Color.gray);
        jTextField2.setPreferredSize(new java.awt.Dimension(140, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        rigth.add(jTextField2, gridBagConstraints);
        jTextField2.getAccessibleContext().setAccessibleDescription("");

        jTextField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Cantidad:")));
        jTextField1.setPreferredSize(new java.awt.Dimension(140, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        rigth.add(jTextField1, gridBagConstraints);

        jDateChooser1.setMinimumSize(new java.awt.Dimension(120, 22));
        jDateChooser1.setPreferredSize(new java.awt.Dimension(140, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        rigth.add(jDateChooser1, gridBagConstraints);

        jButton1.setText("Add");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        rigth.add(jButton1, gridBagConstraints);

        add(rigth, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane center;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTree jTree1;
    private javax.swing.JScrollPane left;
    private javax.swing.JPanel rigth;
    // End of variables declaration//GEN-END:variables
}

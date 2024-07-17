package View;

import javax.swing.table.DefaultTableModel;

public class egresos extends javax.swing.JPanel {

    public static DefaultTableModel tm = new DefaultTableModel();

    public egresos() {
        initComponents();

        String ids[] = {"Fecha", "Razón social", "Monto", "Gasto", "Matriz", "Medio de pago"};
        tm.setColumnIdentifiers(ids);
        tablaEgresos.setModel(tm);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("TABLA DE FECHAS");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Enero");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        
        //construir arbol
        treeNode1.add(treeNode2);
        treeNode2.add(treeNode3);
        
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Febrero");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fecha");
        
        treeNode1.add(treeNode2);
        treeNode2.add(treeNode3);
        

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        left = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        center = new javax.swing.JScrollPane();
        tablaEgresos = new javax.swing.JTable();
        rigth = new javax.swing.JPanel();
        monto = new javax.swing.JTextField();
        razonSocial = new javax.swing.JTextField();
        gasto = new javax.swing.JTextField();
        addReceiptButton = new javax.swing.JButton();
        medioPago = new javax.swing.JTextField();
        matriz = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JCalendar();

        jMenuItem2.setText("Delete");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Close");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jInternalFrame1.setVisible(true);

        setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTree1.setPreferredSize(new java.awt.Dimension(160, 56));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        left.setViewportView(jTree1);

        add(left, java.awt.BorderLayout.WEST);

        tablaEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tablaEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEgresosMouseClicked(evt);
            }
        });
        center.setViewportView(tablaEgresos);

        add(center, java.awt.BorderLayout.CENTER);

        rigth.setBackground(java.awt.Color.white);
        rigth.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar datos"));
        rigth.setForeground(java.awt.Color.white);
        rigth.setMinimumSize(new java.awt.Dimension(200, 384));
        rigth.setName(""); // NOI18N
        rigth.setPreferredSize(new java.awt.Dimension(240, 259));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0};
        jPanel1Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        rigth.setLayout(jPanel1Layout);

        monto.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Monto:")));
        monto.setMinimumSize(new java.awt.Dimension(180, 39));
        monto.setPreferredSize(new java.awt.Dimension(180, 40));
        monto.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        rigth.add(monto, gridBagConstraints);

        razonSocial.setToolTipText("$0");
        razonSocial.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Razón Social:")));
        razonSocial.setDisabledTextColor(java.awt.Color.gray);
        razonSocial.setMinimumSize(new java.awt.Dimension(180, 39));
        razonSocial.setPreferredSize(new java.awt.Dimension(180, 40));
        razonSocial.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        rigth.add(razonSocial, gridBagConstraints);
        razonSocial.getAccessibleContext().setAccessibleDescription("");

        gasto.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Gasto:")));
        gasto.setMinimumSize(new java.awt.Dimension(180, 39));
        gasto.setPreferredSize(new java.awt.Dimension(180, 40));
        gasto.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        rigth.add(gasto, gridBagConstraints);

        addReceiptButton.setText("Add");
        addReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReceiptButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        rigth.add(addReceiptButton, gridBagConstraints);

        medioPago.setToolTipText("$0");
        medioPago.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Medio de Pago:")));
        medioPago.setDisabledTextColor(java.awt.Color.gray);
        medioPago.setMinimumSize(new java.awt.Dimension(180, 39));
        medioPago.setPreferredSize(new java.awt.Dimension(180, 40));
        medioPago.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        rigth.add(medioPago, gridBagConstraints);

        matriz.setToolTipText("$0");
        matriz.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("Matriz:")));
        matriz.setDisabledTextColor(java.awt.Color.gray);
        matriz.setMinimumSize(new java.awt.Dimension(180, 39));
        matriz.setPreferredSize(new java.awt.Dimension(180, 40));
        matriz.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        rigth.add(matriz, gridBagConstraints);

        fecha.setBackground(java.awt.Color.white);
        fecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha:"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        rigth.add(fecha, gridBagConstraints);

        add(rigth, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void addReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReceiptButtonActionPerformed

        int day = fecha.getDayChooser().getDay();
        int month = fecha.getMonthChooser().getMonth() + 1;
        int year = fecha.getYearChooser().getYear();

        String fechaCompleta = (day + "/" + month + "/" + year);
        String rs = razonSocial.getText();
        int mt = Integer.parseInt(monto.getText());
        String gt = gasto.getText();
        String mz = matriz.getText();
        String mp = medioPago.getText();

        tm.addRow(new Object[]{fechaCompleta, rs, mt, gt, mz, mp});

        razonSocial.setText(null);
        monto.setText(null);
        gasto.setText(null);
        matriz.setText(null);
        medioPago.setText(null);
        System.out.println("Recibo nuevo agregado.");
    }//GEN-LAST:event_addReceiptButtonActionPerformed

    private void tablaEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEgresosMouseClicked
        jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_tablaEgresosMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        String dato = jTree1.getLastSelectedPathComponent().toString();
        System.out.println("Seleccionado: " + dato);
        if (dato.equals("Mes2")) {
        }
    }//GEN-LAST:event_jTree1ValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReceiptButton;
    public javax.swing.JScrollPane center;
    private com.toedter.calendar.JCalendar fecha;
    public javax.swing.JTextField gasto;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTree jTree1;
    private javax.swing.JScrollPane left;
    public javax.swing.JTextField matriz;
    public javax.swing.JTextField medioPago;
    public javax.swing.JTextField monto;
    public javax.swing.JTextField razonSocial;
    private javax.swing.JPanel rigth;
    public javax.swing.JTable tablaEgresos;
    // End of variables declaration//GEN-END:variables
}

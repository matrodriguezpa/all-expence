/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package matrodriguezpa.receiptmanager.view;

/**
 *
 * @author Usuario
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftSideBar = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        main = new javax.swing.JTabbedPane();
        rightSideBar = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        bottom = new javax.swing.JToolBar();
        jLabel9 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leftSideBar.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        leftSideBar.setMaximumSize(new java.awt.Dimension(300, 32767));
        leftSideBar.setMinimumSize(new java.awt.Dimension(200, 200));
        leftSideBar.setPreferredSize(new java.awt.Dimension(200, 200));

        jScrollPane1.setViewportView(jTree1);

        leftSideBar.addTab("tab1", jScrollPane1);

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        jLabel1.setText("Cuenta");
        jToolBar1.add(jLabel1);

        jLabel2.setText("Ciudad");
        jToolBar1.add(jLabel2);

        leftSideBar.addTab("tab2", jToolBar1);

        getContentPane().add(leftSideBar, java.awt.BorderLayout.LINE_START);
        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        rightSideBar.setFloatable(true);
        rightSideBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        rightSideBar.setRollover(true);
        rightSideBar.setMaximumSize(new java.awt.Dimension(200, 200));
        rightSideBar.setMinimumSize(new java.awt.Dimension(200, 200));
        rightSideBar.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel3.setText("jLabel3");
        rightSideBar.add(jLabel3);

        jTextField1.setText("jTextField1");
        rightSideBar.add(jTextField1);

        jLabel4.setText("jLabel3");
        rightSideBar.add(jLabel4);

        jTextField2.setText("jTextField1");
        rightSideBar.add(jTextField2);

        jLabel5.setText("jLabel3");
        rightSideBar.add(jLabel5);

        jTextField3.setText("jTextField1");
        rightSideBar.add(jTextField3);

        jLabel6.setText("jLabel3");
        rightSideBar.add(jLabel6);

        jTextField4.setText("jTextField1");
        rightSideBar.add(jTextField4);

        jLabel7.setText("jLabel3");
        rightSideBar.add(jLabel7);

        jTextField5.setText("jTextField1");
        rightSideBar.add(jTextField5);

        jLabel8.setText("jLabel3");
        rightSideBar.add(jLabel8);

        jTextField6.setText("jTextField1");
        rightSideBar.add(jTextField6);

        getContentPane().add(rightSideBar, java.awt.BorderLayout.EAST);

        bottom.setRollover(true);

        jLabel9.setText("jLabel9");
        bottom.add(jLabel9);

        getContentPane().add(bottom, java.awt.BorderLayout.SOUTH);

        jToolBar2.setFloatable(true);
        jToolBar2.setRollover(true);

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton1);

        jToggleButton2.setText("jToggleButton1");
        jToggleButton2.setFocusable(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton2);

        jToggleButton3.setText("jToggleButton1");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton3);

        jToggleButton4.setText("jToggleButton1");
        jToggleButton4.setFocusable(false);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton4);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("File");
        menuBar.add(jMenu1);

        jMenu2.setText("Edit");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar bottom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTabbedPane leftSideBar;
    private javax.swing.JTabbedPane main;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToolBar rightSideBar;
    // End of variables declaration//GEN-END:variables
}

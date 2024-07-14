package View;

public class View extends javax.swing.JFrame{
    
    public View() {
        initComponents(); 
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Receipt Manager");
        setMinimumSize(new java.awt.Dimension(890, 450));

        Main.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("Settings");
        jMenuBar1.add(jMenu5);

        jMenu4.setText("Help");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane Main;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

}


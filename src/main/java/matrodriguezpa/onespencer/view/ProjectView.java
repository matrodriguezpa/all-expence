package matrodriguezpa.onespencer.view;

import javax.swing.ImageIcon; // Para cargar el icono de la aplicaciòn
import javax.swing.UIManager; // Para mostrar el icono
import javax.swing.UnsupportedLookAndFeelException; // Expepsiones el cargar los estilos
import com.formdev.flatlaf.FlatLightLaf; //Generar estilos de la aplicaciòn
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;

public class ProjectView extends javax.swing.JFrame {

    ImageIcon icon = new ImageIcon("src\\main\\resources\\Images\\Logo.png"); //Icono de la aplicación
    FlatLightLaf style = new FlatLightLaf();

    public ProjectView() {
        try {
            UIManager.setLookAndFeel(style);
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    //GETTERS & SETTERS
    public JMenuItem getNewProjectItem() {
        return this.newProjectItem;
    }

    public JMenuItem getOpenProjectItem() {
        return this.openProjectItem;
    }

    public JMenuItem getAboutItem() {
        return aboutItem;
    }

    public JMenuItem getCloseProjectItem() {
        return closeProjectItem;
    }

    public JMenuItem getDocumentationItem() {
        return documentationItem;
    }

    public JMenuItem getExitProgramItem() {
        return exitProgramItem;
    }

    public JMenuItem getExportItem() {
        return exportItem;
    }


    public JButton getAddExpense() {
        return addExpense;
    }
    
    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public Object getjPanel4() {
        return jPanel4;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public JTree getLeftNavigation() {
        return leftNavigation;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public JButton getAddWorkBook() {
        return addWorkBook;
    }

    public JButton getAddWorkBook1() {
        return addWorkBook1;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }
    
    //for new expenses

    public JDateChooser getExpenseDate() {
        return expenseDate;
    }

    public JTextField getAmount() {
        return amount;
    }

    public JTextField getCompanyName() {
        return companyName;
    }

    public JComboBox<String> getExpense() {
        return expense;
    }

    public JComboBox<String> getMatrix() {
        return matrix;
    }

    public JComboBox<String> getPaymentMethod() {
        return paymentMethod;
    }

    public JTable getMainTable() {
        return mainTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        addWorkbookLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        addWorkbookLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        rightSideBar = new javax.swing.JToolBar();
        expenseDate = new com.toedter.calendar.JDateChooser();
        companyName = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        expense = new javax.swing.JComboBox<>();
        matrix = new javax.swing.JComboBox<>();
        paymentMethod = new javax.swing.JComboBox<>();
        addExpense = new javax.swing.JButton();
        footer = new javax.swing.JToolBar();
        programVersion = new javax.swing.JLabel();
        leftSibeBar = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        leftScroll = new javax.swing.JScrollPane();
        leftNavigation = new javax.swing.JTree();
        main = new javax.swing.JPanel();
        mainTableScroll = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        bottomBar = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(250, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        addYearWorkbook = new javax.swing.JToolBar();
        addWorkBook = new javax.swing.JButton();
        addWorkBook1 = new javax.swing.JButton();
        autoMonthlyBoudget = new javax.swing.JToolBar();
        autoBudgetLabel = new javax.swing.JLabel();
        autoBudgetCheckBox = new javax.swing.JCheckBox();
        monthlyBudget = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        openProjectItem = new javax.swing.JMenuItem();
        closeProjectItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exportItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitProgramItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        documentationItem = new javax.swing.JMenuItem();
        javadocItem = new javax.swing.JMenuItem();
        aboutItem = new javax.swing.JMenuItem();

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        addWorkbookLabel1.setText("Nombre del proyecto *");
        jPanel2.add(addWorkbookLabel1);
        jPanel2.add(jTextField1);

        addWorkbookLabel2.setText("No. de cuenta");
        jPanel2.add(addWorkbookLabel2);
        jPanel2.add(jTextField2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Selecionar proyectos");
        jPanel3.add(jLabel1);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Proyecto");
        jPanel4.add(jLabel4);

        jPanel6.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));
        jPanel4.add(jPanel6);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Selecionar mes");
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox1.setMaximumSize(new java.awt.Dimension(100, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("One spencer -test project");
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(960, 540));

        rightSideBar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(null, "Add expense", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP)));
        rightSideBar.setFloatable(true);
        rightSideBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        rightSideBar.setRollover(true);
        rightSideBar.setMaximumSize(new java.awt.Dimension(200, 200));
        rightSideBar.setMinimumSize(new java.awt.Dimension(200, 200));
        rightSideBar.setPreferredSize(new java.awt.Dimension(200, 200));

        expenseDate.setMaximumSize(new java.awt.Dimension(120, 30));
        rightSideBar.add(expenseDate);

        companyName.setMaximumSize(new java.awt.Dimension(120, 30));
        companyName.setPreferredSize(new java.awt.Dimension(30, 10));
        rightSideBar.add(companyName);

        amount.setMaximumSize(new java.awt.Dimension(120, 30));
        amount.setPreferredSize(new java.awt.Dimension(30, 10));
        rightSideBar.add(amount);

        expense.setEditable(true);
        expense.setMaximumSize(new java.awt.Dimension(120, 30));
        expense.setMinimumSize(new java.awt.Dimension(20, 20));
        expense.setPreferredSize(new java.awt.Dimension(80, 20));
        rightSideBar.add(expense);

        matrix.setEditable(true);
        matrix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        matrix.setSelectedIndex(-1);
        matrix.setMaximumSize(new java.awt.Dimension(120, 30));
        matrix.setMinimumSize(new java.awt.Dimension(20, 20));
        matrix.setPreferredSize(new java.awt.Dimension(80, 20));
        rightSideBar.add(matrix);

        paymentMethod.setMaximumSize(new java.awt.Dimension(120, 30));
        paymentMethod.setMinimumSize(new java.awt.Dimension(20, 20));
        paymentMethod.setPreferredSize(new java.awt.Dimension(80, 20));
        paymentMethod.setRequestFocusEnabled(false);
        rightSideBar.add(paymentMethod);

        addExpense.setBackground(new java.awt.Color(51, 102, 255));
        addExpense.setForeground(new java.awt.Color(255, 255, 255));
        addExpense.setText("Add");
        addExpense.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addExpense.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rightSideBar.add(addExpense);

        getContentPane().add(rightSideBar, java.awt.BorderLayout.EAST);

        footer.setBackground(new java.awt.Color(229, 229, 229));
        footer.setRollover(true);

        programVersion.setText("One Spencer v0.1 beta");
        footer.add(programVersion);

        getContentPane().add(footer, java.awt.BorderLayout.SOUTH);

        leftSibeBar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20), javax.swing.BorderFactory.createTitledBorder("Project Navigation")));
        leftSibeBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        leftSibeBar.setRollover(true);
        leftSibeBar.setMaximumSize(new java.awt.Dimension(140, 140));
        leftSibeBar.setPreferredSize(new java.awt.Dimension(200, 140));

        jLabel3.setText("---");
        leftSibeBar.add(jLabel3);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Unset");
        leftNavigation.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        leftScroll.setViewportView(leftNavigation);

        leftSibeBar.add(leftScroll);

        getContentPane().add(leftSibeBar, java.awt.BorderLayout.LINE_START);

        main.setLayout(new java.awt.BorderLayout());

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expense date", "Company name", "Amount", "Expense", "Matrix", "Payment Method"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mainTable.setEnabled(false);
        mainTableScroll.setViewportView(mainTable);

        main.add(mainTableScroll, java.awt.BorderLayout.CENTER);

        bottomBar.setRollover(true);
        bottomBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        bottomBar.setEnabled(false);
        bottomBar.add(filler1);

        main.add(bottomBar, java.awt.BorderLayout.PAGE_END);

        addYearWorkbook.setRollover(true);
        addYearWorkbook.setMaximumSize(new java.awt.Dimension(150, 30));
        addYearWorkbook.setMinimumSize(new java.awt.Dimension(150, 30));
        addYearWorkbook.setPreferredSize(new java.awt.Dimension(150, 30));
        addYearWorkbook.setRequestFocusEnabled(false);

        addWorkBook.setBackground(new java.awt.Color(51, 102, 255));
        addWorkBook.setForeground(new java.awt.Color(255, 255, 255));
        addWorkBook.setText("AddProyect");
        addWorkBook.setFocusable(false);
        addWorkBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addYearWorkbook.add(addWorkBook);

        addWorkBook1.setBackground(new java.awt.Color(51, 102, 255));
        addWorkBook1.setForeground(new java.awt.Color(255, 255, 255));
        addWorkBook1.setText("AddMonth");
        addWorkBook1.setFocusable(false);
        addWorkBook1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkBook1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addWorkBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkBook1ActionPerformed(evt);
            }
        });
        addYearWorkbook.add(addWorkBook1);

        autoMonthlyBoudget.setRollover(true);
        autoMonthlyBoudget.setMaximumSize(new java.awt.Dimension(200, 30));
        autoMonthlyBoudget.setMinimumSize(new java.awt.Dimension(200, 30));
        autoMonthlyBoudget.setPreferredSize(new java.awt.Dimension(200, 30));

        autoBudgetLabel.setText("Auto Monthly budget");
        autoMonthlyBoudget.add(autoBudgetLabel);

        autoBudgetCheckBox.setSelected(true);
        autoBudgetCheckBox.setFocusable(false);
        autoBudgetCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        autoBudgetCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        autoMonthlyBoudget.add(autoBudgetCheckBox);

        monthlyBudget.setMaximumSize(new java.awt.Dimension(80, 30));
        monthlyBudget.setMinimumSize(new java.awt.Dimension(80, 26));
        monthlyBudget.setPreferredSize(new java.awt.Dimension(80, 10));
        autoMonthlyBoudget.add(monthlyBudget);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(addYearWorkbook, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(autoMonthlyBoudget, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addYearWorkbook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoMonthlyBoudget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        main.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        fileMenu.setBackground(new java.awt.Color(51, 102, 255));
        fileMenu.setText("File");

        newProjectItem.setText("New project");
        newProjectItem.setFocusable(true);
        fileMenu.add(newProjectItem);
        fileMenu.add(jSeparator1);

        openProjectItem.setText("Open project");
        fileMenu.add(openProjectItem);

        closeProjectItem.setText("Close project");
        fileMenu.add(closeProjectItem);
        fileMenu.add(jSeparator2);

        exportItem.setText("Export");
        fileMenu.add(exportItem);
        fileMenu.add(jSeparator3);

        exitProgramItem.setText("Exit program");
        fileMenu.add(exitProgramItem);

        menuBar.add(fileMenu);

        helpMenu.setBackground(new java.awt.Color(51, 102, 255));
        helpMenu.setText("Help");

        documentationItem.setText("Documentation");
        helpMenu.add(documentationItem);

        javadocItem.setText("Javadoc");
        helpMenu.add(javadocItem);

        aboutItem.setText("About");
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void addWorkBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkBook1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addWorkBook1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JButton addExpense;
    private javax.swing.JButton addWorkBook;
    private javax.swing.JButton addWorkBook1;
    private javax.swing.JLabel addWorkbookLabel1;
    private javax.swing.JLabel addWorkbookLabel2;
    private javax.swing.JToolBar addYearWorkbook;
    private javax.swing.JTextField amount;
    private javax.swing.JCheckBox autoBudgetCheckBox;
    private javax.swing.JLabel autoBudgetLabel;
    private javax.swing.JToolBar autoMonthlyBoudget;
    private javax.swing.JToolBar bottomBar;
    private javax.swing.JMenuItem closeProjectItem;
    private javax.swing.JTextField companyName;
    private javax.swing.JMenuItem documentationItem;
    private javax.swing.JMenuItem exitProgramItem;
    private javax.swing.JComboBox<String> expense;
    private com.toedter.calendar.JDateChooser expenseDate;
    private javax.swing.JMenuItem exportItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JToolBar footer;
    private javax.swing.JMenu helpMenu;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuItem javadocItem;
    private javax.swing.JTree leftNavigation;
    private javax.swing.JScrollPane leftScroll;
    private javax.swing.JToolBar leftSibeBar;
    private javax.swing.JPanel main;
    private javax.swing.JTable mainTable;
    private javax.swing.JScrollPane mainTableScroll;
    private javax.swing.JComboBox<String> matrix;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField monthlyBudget;
    private javax.swing.JMenuItem newProjectItem;
    private javax.swing.JMenuItem openProjectItem;
    private javax.swing.JComboBox<String> paymentMethod;
    private javax.swing.JLabel programVersion;
    private javax.swing.JToolBar rightSideBar;
    // End of variables declaration//GEN-END:variables

}

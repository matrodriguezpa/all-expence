package matrodriguezpa.onespencer.view;

import javax.swing.ImageIcon; // Para cargar el icono de la aplicaciòn
import javax.swing.UIManager; // Para mostrar el icono
import javax.swing.UnsupportedLookAndFeelException; // Expepsiones el cargar los estilos
import com.formdev.flatlaf.FlatLightLaf; //Generar estilos de la aplicaciòn
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    public void setNewProjectItem(JMenuItem newProjectItem) {
        this.newProjectItem = newProjectItem;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
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
        projectAccountName = new javax.swing.JLabel();
        leftScroll = new javax.swing.JScrollPane();
        leftNavigation = new javax.swing.JTree();
        main = new javax.swing.JPanel();
        mainTableScroll = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        bottomBar = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(250, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        addYearWorkbook = new javax.swing.JToolBar();
        addWorkbookLabel = new javax.swing.JLabel();
        workbookName = new javax.swing.JTextField();
        workbookAccount = new javax.swing.JTextField();
        addWorkBook = new javax.swing.JButton();
        autoMonthlyBoudget = new javax.swing.JToolBar();
        autoBudgetLabel = new javax.swing.JLabel();
        autoBudgetCheckBox = new javax.swing.JCheckBox();
        monthlyBudget = new javax.swing.JTextField();
        header = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        openProjectItem = new javax.swing.JMenuItem();
        closeProjectItem = new javax.swing.JMenuItem();
        saveProjectItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        importItem = new javax.swing.JMenuItem();
        exportItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitProgramItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoItem = new javax.swing.JMenuItem();
        redoItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        cutItem = new javax.swing.JMenuItem();
        copyItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        deleteItem = new javax.swing.JMenuItem();
        findItem = new javax.swing.JMenuItem();
        windowMenu = new javax.swing.JMenu();
        fullScreenItem = new javax.swing.JMenuItem();
        minScreenItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        configureViewItem = new javax.swing.JMenuItem();
        configureLanguageItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        resetScreenItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        shortcutsItem = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        documentationItem = new javax.swing.JMenuItem();
        javadocItem = new javax.swing.JMenuItem();
        aboutItem = new javax.swing.JMenuItem();

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        addWorkbookLabel1.setText("New workbook");
        jPanel2.add(addWorkbookLabel1);

        jTextField1.setText("jTextField1");
        jPanel2.add(jTextField1);

        addWorkbookLabel2.setText("New workbook");
        jPanel2.add(addWorkbookLabel2);

        jTextField2.setText("jTextField2");
        jPanel2.add(jTextField2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Selecionar proyectos");
        jPanel3.add(jLabel1);

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

        projectAccountName.setText("Unset");
        leftSibeBar.add(projectAccountName);

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

        addWorkbookLabel.setText("New workbook");
        addYearWorkbook.add(addWorkbookLabel);

        workbookName.setMaximumSize(new java.awt.Dimension(120, 30));
        workbookName.setPreferredSize(new java.awt.Dimension(30, 10));
        addYearWorkbook.add(workbookName);

        workbookAccount.setMaximumSize(new java.awt.Dimension(120, 30));
        workbookAccount.setPreferredSize(new java.awt.Dimension(30, 10));
        addYearWorkbook.add(workbookAccount);

        addWorkBook.setBackground(new java.awt.Color(51, 102, 255));
        addWorkBook.setForeground(new java.awt.Color(255, 255, 255));
        addWorkBook.setText("Add");
        addWorkBook.setFocusable(false);
        addWorkBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWorkBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addYearWorkbook.add(addWorkBook);

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
                .addComponent(addYearWorkbook, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(autoMonthlyBoudget, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        header.setRollover(true);

        jButton1.setText("Open");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        header.add(jButton1);

        jButton2.setText("Undo");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        header.add(jButton2);

        jButton3.setText("Redo");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        header.add(jButton3);

        jButton4.setText("Save");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        header.add(jButton4);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

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

        saveProjectItem.setText("Save project");
        fileMenu.add(saveProjectItem);
        fileMenu.add(jSeparator2);

        importItem.setText("Import");
        fileMenu.add(importItem);

        exportItem.setText("Export");
        fileMenu.add(exportItem);
        fileMenu.add(jSeparator3);

        exitProgramItem.setText("Exit program");
        fileMenu.add(exitProgramItem);

        menuBar.add(fileMenu);

        editMenu.setBackground(new java.awt.Color(51, 102, 255));
        editMenu.setText("Edit");

        undoItem.setText("Undo");
        editMenu.add(undoItem);

        redoItem.setText("Redo");
        editMenu.add(redoItem);
        editMenu.add(jSeparator4);

        cutItem.setText("Cut");
        editMenu.add(cutItem);

        copyItem.setText("Copy");
        editMenu.add(copyItem);

        pasteItem.setText("Paste");
        editMenu.add(pasteItem);
        editMenu.add(jSeparator5);

        deleteItem.setText("Delete");
        editMenu.add(deleteItem);

        findItem.setText("Find");
        editMenu.add(findItem);

        menuBar.add(editMenu);

        windowMenu.setBackground(new java.awt.Color(51, 102, 255));
        windowMenu.setText("Window");

        fullScreenItem.setText("Full screen");
        windowMenu.add(fullScreenItem);

        minScreenItem.setText("Min screen");
        windowMenu.add(minScreenItem);
        windowMenu.add(jSeparator6);

        configureViewItem.setText("Configure view");
        windowMenu.add(configureViewItem);

        configureLanguageItem.setText("Configure language");
        windowMenu.add(configureLanguageItem);
        windowMenu.add(jSeparator7);

        resetScreenItem.setText("Reset screen");
        windowMenu.add(resetScreenItem);

        menuBar.add(windowMenu);

        helpMenu.setBackground(new java.awt.Color(51, 102, 255));
        helpMenu.setText("Help");

        shortcutsItem.setText("Shortcuts");
        helpMenu.add(shortcutsItem);
        helpMenu.add(jSeparator8);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JButton addExpense;
    private javax.swing.JButton addWorkBook;
    private javax.swing.JLabel addWorkbookLabel;
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
    private javax.swing.JMenuItem configureLanguageItem;
    private javax.swing.JMenuItem configureViewItem;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JMenuItem documentationItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitProgramItem;
    private javax.swing.JComboBox<String> expense;
    private com.toedter.calendar.JDateChooser expenseDate;
    private javax.swing.JMenuItem exportItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenuItem findItem;
    private javax.swing.JToolBar footer;
    private javax.swing.JMenuItem fullScreenItem;
    private javax.swing.JToolBar header;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
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
    private javax.swing.JMenuItem minScreenItem;
    private javax.swing.JTextField monthlyBudget;
    private javax.swing.JMenuItem newProjectItem;
    private javax.swing.JMenuItem openProjectItem;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JComboBox<String> paymentMethod;
    private javax.swing.JLabel programVersion;
    private javax.swing.JLabel projectAccountName;
    private javax.swing.JMenuItem redoItem;
    private javax.swing.JMenuItem resetScreenItem;
    private javax.swing.JToolBar rightSideBar;
    private javax.swing.JMenuItem saveProjectItem;
    private javax.swing.JMenuItem shortcutsItem;
    private javax.swing.JMenuItem undoItem;
    private javax.swing.JMenu windowMenu;
    private javax.swing.JTextField workbookAccount;
    private javax.swing.JTextField workbookName;
    // End of variables declaration//GEN-END:variables
}

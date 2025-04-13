package matrodriguezpa.allexpence.view;

import javax.swing.ImageIcon; // Para cargar el icono de la aplicaciòn
import javax.swing.UIManager; // Para mostrar el icono
import javax.swing.UnsupportedLookAndFeelException; // Expepsiones el cargar los estilos
import com.formdev.flatlaf.FlatLightLaf; //Generar estilos de la aplicaciòn
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;

public class Main extends javax.swing.JFrame {

    ImageIcon icon = new ImageIcon("src\\main\\resources\\Images\\Logo.png"); //Icono de la aplicación
    FlatLightLaf style = new FlatLightLaf();

    public Main() {
        try {
            UIManager.setLookAndFeel(style);
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }

        // Create loading window
        JFrame loadingFrame = new JFrame("Loading");
        loadingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadingFrame.setUndecorated(true); // Removes window decorations

        Loading loadingPanel = new Loading();
        loadingFrame.getContentPane().add(loadingPanel);
        loadingFrame.pack(); // Sizes frame to fit the loading panel
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setVisible(true);

        try {
            Thread.sleep(2500); // Wait for 1 second
            loadingFrame.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Initialize components after loading
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
    public JPanel getNewProjectJPanel() {
        return NewProject;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.NewProject = jPanel2;
    }

    public Object getCreateNewMonth() {
        return CreateNewMonth;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.newProjectName = jTextField1;
    }

    public JTextField getjTextField1() {
        return newProjectName;
    }

    public JTextField getjTextField2() {
        return newProjectYear;
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

    public JPanel getProyectListJpanel() {
        return proyectList;
    }

    public JButton getAddWorkBook() {
        return addWorkBook;
    }

    public JButton getAddWorkBook1() {
        return addWorkBook1;
    }

    public JSpinner getExpenseDate2() {
        return expenseDate2;
    }
    
    public JSpinner getExpenseDate1() {
        return expenseDate1;
    }

    //for new expenses
    public JSpinner getExpenseDate() {
        return expenseDate;
    }

    public JTextField getAmount() {
        return amount;
    }


    public JComboBox<String> getExpense() {
        return expense;
    }

    public JComboBox<String> getMatrix() {
        return matrix;
    }

    public JTable getMainTable() {
        return mainTable;
    }

    public JMenuItem getPreviewItem() {
        return previewItem;
    }

    public JPanel getjPanel12() {
        return jPanel12;
    }

    public void setjPanel12(JPanel jPanel12) {
        this.jPanel12 = jPanel12;
    }

    public JComboBox<String> getCompany() {
        return company;
    }

    public void setCompany(JComboBox<String> company) {
        this.company = company;
    }

    public JComboBox<String> getPayment() {
        return payment;
    }

    public void setPayment(JComboBox<String> payment) {
        this.payment = payment;
    }

    public JButton getAddExpense() {
        return addExpense;
    }

    public JTextField getAddExpenseDataJText() {
        return addExpenseDataJText;
    }

    public JComboBox<String> getAddExpensedata() {
        return addExpensedata;
    }

    public JButton getAddCompanyButton() {
        return addCompanyButton;
    }

    public JButton getAddMatrixButton() {
        return addMatrixButton;
    }

    public JButton getAddPaymentButton() {
        return addPaymentButton;
    }

    public JButton getAddExpenseButton() {
        return addExpensebutton;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewProject = new javax.swing.JPanel();
        addWorkbookLabel1 = new javax.swing.JLabel();
        newProjectName = new javax.swing.JTextField();
        addWorkbookLabel2 = new javax.swing.JLabel();
        newProjectYear = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CreateNewMonth = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        proyectList = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        addExpensedata = new javax.swing.JComboBox<>();
        addExpenseDataJText = new javax.swing.JTextField();
        rightSideBar = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        expenseDate2 = new javax.swing.JSpinner();
        expenseDate1 = new javax.swing.JSpinner();
        expenseDate = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        company = new javax.swing.JComboBox<>();
        addCompanyButton = new javax.swing.JButton();
        amount = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        expense = new javax.swing.JComboBox<>();
        addExpensebutton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        matrix = new javax.swing.JComboBox<>();
        addMatrixButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        payment = new javax.swing.JComboBox<>();
        addPaymentButton = new javax.swing.JButton();
        addExpense = new javax.swing.JButton();
        footer = new javax.swing.JToolBar();
        programVersion = new javax.swing.JLabel();
        leftSibeBar = new javax.swing.JToolBar();
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
        helpMenu1 = new javax.swing.JMenu();
        previewItem = new javax.swing.JMenuItem();
        helpMenu2 = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        documentationItem = new javax.swing.JMenuItem();
        javadocItem = new javax.swing.JMenuItem();
        aboutItem = new javax.swing.JMenuItem();

        NewProject.setLayout(new javax.swing.BoxLayout(NewProject, javax.swing.BoxLayout.Y_AXIS));

        addWorkbookLabel1.setText("Name*");
        NewProject.add(addWorkbookLabel1);
        NewProject.add(newProjectName);

        addWorkbookLabel2.setText("Year");
        NewProject.add(addWorkbookLabel2);

        newProjectYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectYearActionPerformed(evt);
            }
        });
        NewProject.add(newProjectYear);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Selecionar proyectos");
        jPanel3.add(jLabel1);

        CreateNewMonth.setLayout(new javax.swing.BoxLayout(CreateNewMonth, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Seleccionar año");
        CreateNewMonth.add(jLabel4);

        proyectList.setMinimumSize(new java.awt.Dimension(50, 50));
        proyectList.setLayout(new javax.swing.BoxLayout(proyectList, javax.swing.BoxLayout.Y_AXIS));
        CreateNewMonth.add(proyectList);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Seleccionar mes");
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CreateNewMonth.add(jLabel2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox1.setMaximumSize(new java.awt.Dimension(100, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        CreateNewMonth.add(jComboBox1);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        addExpensedata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Company", "expense", "Matrix", "Payment" }));
        addExpensedata.setMaximumSize(new java.awt.Dimension(140, 30));
        addExpensedata.setMinimumSize(new java.awt.Dimension(140, 30));
        addExpensedata.setPreferredSize(new java.awt.Dimension(140, 30));
        addExpensedata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpensedataActionPerformed(evt);
            }
        });
        jPanel12.add(addExpensedata);

        addExpenseDataJText.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addExpenseDataJText.setMaximumSize(new java.awt.Dimension(140, 30));
        addExpenseDataJText.setMinimumSize(new java.awt.Dimension(140, 30));
        addExpenseDataJText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpenseDataJTextActionPerformed(evt);
            }
        });
        jPanel12.add(addExpenseDataJText);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("One spencer");
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(960, 540));

        rightSideBar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(null, "Add expense", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP)));
        rightSideBar.setFloatable(true);
        rightSideBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        rightSideBar.setRollover(true);
        rightSideBar.setMaximumSize(new java.awt.Dimension(220, 200));
        rightSideBar.setMinimumSize(new java.awt.Dimension(220, 200));
        rightSideBar.setPreferredSize(new java.awt.Dimension(220, 200));

        jPanel2.setMaximumSize(new java.awt.Dimension(170, 30));
        jPanel2.setMinimumSize(new java.awt.Dimension(170, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 30));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        expenseDate2.setModel(new javax.swing.SpinnerNumberModel(2025, 0, 3000, 1));
        expenseDate2.setMaximumSize(new java.awt.Dimension(65, 30));
        expenseDate2.setMinimumSize(new java.awt.Dimension(65, 30));
        expenseDate2.setPreferredSize(new java.awt.Dimension(65, 30));
        jPanel2.add(expenseDate2);

        expenseDate1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        expenseDate1.setMaximumSize(new java.awt.Dimension(50, 30));
        expenseDate1.setMinimumSize(new java.awt.Dimension(50, 30));
        expenseDate1.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel2.add(expenseDate1);

        expenseDate.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        expenseDate.setMaximumSize(new java.awt.Dimension(50, 30));
        expenseDate.setMinimumSize(new java.awt.Dimension(50, 30));
        expenseDate.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel2.add(expenseDate);

        rightSideBar.add(jPanel2);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        company.setEditable(true);
        company.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "opcion1", "opcion2" }));
        company.setMaximumSize(new java.awt.Dimension(120, 30));
        company.setMinimumSize(new java.awt.Dimension(20, 20));
        company.setPreferredSize(new java.awt.Dimension(80, 20));
        jPanel8.add(company);

        addCompanyButton.setText("+");
        addCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel8.add(addCompanyButton);

        rightSideBar.add(jPanel8);

        amount.setText("1000");
        amount.setMaximumSize(new java.awt.Dimension(140, 30));
        amount.setPreferredSize(new java.awt.Dimension(30, 10));
        rightSideBar.add(amount);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        expense.setEditable(true);
        expense.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personal", "Trabajo" }));
        expense.setMaximumSize(new java.awt.Dimension(120, 30));
        expense.setMinimumSize(new java.awt.Dimension(20, 20));
        expense.setPreferredSize(new java.awt.Dimension(80, 20));
        jPanel9.add(expense);

        addExpensebutton.setText("+");
        addExpensebutton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addExpensebutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel9.add(addExpensebutton);

        rightSideBar.add(jPanel9);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        matrix.setEditable(true);
        matrix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Universidad" }));
        matrix.setMaximumSize(new java.awt.Dimension(120, 30));
        matrix.setMinimumSize(new java.awt.Dimension(20, 20));
        matrix.setPreferredSize(new java.awt.Dimension(80, 20));
        jPanel10.add(matrix);

        addMatrixButton.setText("+");
        addMatrixButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addMatrixButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel10.add(addMatrixButton);

        rightSideBar.add(jPanel10);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        payment.setEditable(true);
        payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta", "Efectivo" }));
        payment.setMaximumSize(new java.awt.Dimension(120, 30));
        payment.setMinimumSize(new java.awt.Dimension(20, 20));
        payment.setPreferredSize(new java.awt.Dimension(80, 20));
        jPanel11.add(payment);

        addPaymentButton.setText("+");
        addPaymentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addPaymentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel11.add(addPaymentButton);

        rightSideBar.add(jPanel11);

        addExpense.setBackground(new java.awt.Color(51, 102, 255));
        addExpense.setForeground(new java.awt.Color(255, 255, 255));
        addExpense.setText("Add");
        addExpense.setAlignmentX(0.5F);
        addExpense.setAlignmentY(1.0F);
        addExpense.setFocusable(false);
        addExpense.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addExpense.setMargin(new java.awt.Insets(1, 1, 1, 1));
        addExpense.setMaximumSize(new java.awt.Dimension(50, 30));
        addExpense.setMinimumSize(new java.awt.Dimension(50, 30));
        addExpense.setPreferredSize(new java.awt.Dimension(50, 30));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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

        helpMenu1.setBackground(new java.awt.Color(51, 102, 255));
        helpMenu1.setText("Preview");

        previewItem.setText("Preview export");
        previewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewItemActionPerformed(evt);
            }
        });
        helpMenu1.add(previewItem);

        menuBar.add(helpMenu1);

        helpMenu2.setBackground(new java.awt.Color(51, 102, 255));
        helpMenu2.setText("Settings");
        menuBar.add(helpMenu2);

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

    private void previewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_previewItemActionPerformed

    private void newProjectYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProjectYearActionPerformed

    private void addExpenseDataJTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpenseDataJTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addExpenseDataJTextActionPerformed

    private void addExpensedataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpensedataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addExpensedataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateNewMonth;
    private javax.swing.JPanel NewProject;
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JButton addCompanyButton;
    private javax.swing.JButton addExpense;
    private javax.swing.JTextField addExpenseDataJText;
    private javax.swing.JButton addExpensebutton;
    private javax.swing.JComboBox<String> addExpensedata;
    private javax.swing.JButton addMatrixButton;
    private javax.swing.JButton addPaymentButton;
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
    private javax.swing.JComboBox<String> company;
    private javax.swing.JMenuItem documentationItem;
    private javax.swing.JMenuItem exitProgramItem;
    private javax.swing.JComboBox<String> expense;
    private javax.swing.JSpinner expenseDate;
    private javax.swing.JSpinner expenseDate1;
    private javax.swing.JSpinner expenseDate2;
    private javax.swing.JMenuItem exportItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JToolBar footer;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu helpMenu1;
    private javax.swing.JMenu helpMenu2;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
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
    private javax.swing.JTextField newProjectName;
    private javax.swing.JTextField newProjectYear;
    private javax.swing.JMenuItem openProjectItem;
    private javax.swing.JComboBox<String> payment;
    private javax.swing.JMenuItem previewItem;
    private javax.swing.JLabel programVersion;
    private javax.swing.JPanel proyectList;
    private javax.swing.JToolBar rightSideBar;
    // End of variables declaration//GEN-END:variables

    public Object getAutoBudgetCheckBox() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

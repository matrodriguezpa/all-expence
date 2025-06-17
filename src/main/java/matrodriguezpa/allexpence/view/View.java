package matrodriguezpa.allexpence.view;

import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View extends javax.swing.JFrame {

    ImageIcon icon = new ImageIcon("src\\main\\resources\\Images\\Logo.png"); //Icono de la aplicación

    public View() {
        initComponents();
        showLoadingScreen();
        applyFlatLaf();         // now force FlatLaf onto existing components
    }

    private void showLoadingScreen() {
        // Create loading window
        JFrame loadingFrame = new JFrame();
        loadingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadingFrame.setUndecorated(true); // Removes window decorations

        loadingFrame.getContentPane().add(this.loadingPanel);
        loadingFrame.pack(); // Sizes frame to fit the loading panel
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setVisible(true);
        
        try {
            Thread.sleep(2500); // Wait for 1 second
            loadingFrame.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void applyFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        SwingUtilities.updateComponentTreeUI(this);
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

    public JMenuItem getExitProgramItem() {
        return exitProgramItem;
    }

    public JPanel getNewProject() {
        return NewProject;
    }

    public void setNewProject(JPanel newProject) {
        this.NewProject = newProject;
    }

    public Object getCreateNewMonth() {
        return CreateNewMonth;
    }

    public void setNewProjectName(JTextField newProjectName) {
        this.newProjectName = newProjectName;
    }

    public JTextField getNewProjectName() {
        return newProjectName;
    }

    public JTextField getNewProjectYear() {
        return newProjectYear;
    }

    public JComboBox getMonthsList() {
        return monthsList;
    }

    public JTree getLeftNavigation() {
        return leftNavigation;
    }

    public JPanel getProjectList() {
        return projectList;
    }

    public JButton getAddProject() {
        return addProject;
    }

    public JButton getAddMonth() {
        return addMonth;
    }

    public JSpinner getExpenseDateYear() {
        return expenseDateYear;
    }

    public JSpinner getExpenseDateMonth() {
        return expenseDateMonth;
    }

    //for new expenses
    public JSpinner getExpenseDateDay() {
        return expenseDateDay;
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

    public JPanel getAbout() {
        return About;
    }

    public JPanel getExpenseDataLoader() {
        return expenseDataLoader;
    }

    public void setExpenseDataLoader(JPanel expenseDataLoader) {
        this.expenseDataLoader = expenseDataLoader;
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

    public JTextField getNewExpenseData() {
        return newExpenseData;
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
        return addExpenseButton;
    }

    public ButtonGroup getAddExpenseButtonGroup() {
        return addExpenseButtonGroup;
    }

    public JMenuItem getJavadocItem() {
        return javadocItem;
    }

    public JMenuItem getUserDocItem() {
        return userDocItem;
    }

    public JLabel getWarning() {
        return warning;
    }

    public JLabel getAddNewYearProjectName() {
        return addNewYearProjectName;
    }

    public JPanel getNewYear() {
        return NewYear;
    }

    public JTextField getNewYearProject() {
        return newYearProject;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewProject = new javax.swing.JPanel();
        addWorkbookLabel1 = new javax.swing.JLabel();
        newProjectName = new javax.swing.JTextField();
        addWorkbookLabel2 = new javax.swing.JLabel();
        newProjectYear = new javax.swing.JTextField();
        warning = new javax.swing.JLabel();
        CreateNewMonth = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        projectList = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        monthsList = new javax.swing.JComboBox<>();
        expenseDataLoader = new javax.swing.JPanel();
        addExpensedata = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        newExpenseData = new javax.swing.JTextField();
        addExpenseButtonGroup = new javax.swing.ButtonGroup();
        About = new javax.swing.JPanel();
        GitHub = new javax.swing.JLabel();
        Copyrigth = new javax.swing.JLabel();
        NewYear = new javax.swing.JPanel();
        addWorkbookLabel3 = new javax.swing.JLabel();
        addNewYearProjectName = new javax.swing.JLabel();
        addWorkbookLabel4 = new javax.swing.JLabel();
        newYearProject = new javax.swing.JTextField();
        warning1 = new javax.swing.JLabel();
        loadingPanel = new javax.swing.JPanel();
        loadingImage = new javax.swing.JLabel();
        loadingFooter = new javax.swing.JSplitPane();
        author = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        rightSideBar = new javax.swing.JToolBar();
        newExpenseAddDate = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        expenseDateYear = new javax.swing.JSpinner();
        expenseDateMonth = new javax.swing.JSpinner();
        expenseDateDay = new javax.swing.JSpinner();
        newExpenseAddCompany = new javax.swing.JPanel();
        companyLabel = new javax.swing.JLabel();
        company = new javax.swing.JComboBox<>();
        addCompanyButton = new javax.swing.JButton();
        newExpenseAddAmount = new javax.swing.JPanel();
        Amount = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        newExpenseAddExpense = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        expense = new javax.swing.JComboBox<>();
        addExpenseButton = new javax.swing.JButton();
        newExpenseAddMatrix = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        matrix = new javax.swing.JComboBox<>();
        addMatrixButton = new javax.swing.JButton();
        newExpenseAddPayment = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
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
        mainTableHeader = new javax.swing.JToolBar();
        addProject = new javax.swing.JButton();
        addMonth = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        openProjectItem = new javax.swing.JMenuItem();
        closeProjectItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitProgramItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        userDocItem = new javax.swing.JMenuItem();
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

        warning.setForeground(java.awt.Color.red);
        NewProject.add(warning);

        CreateNewMonth.setLayout(new javax.swing.BoxLayout(CreateNewMonth, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Seleccionar año");
        CreateNewMonth.add(jLabel4);

        projectList.setMinimumSize(new java.awt.Dimension(50, 50));
        projectList.setLayout(new javax.swing.BoxLayout(projectList, javax.swing.BoxLayout.Y_AXIS));
        CreateNewMonth.add(projectList);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Seleccionar mes");
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CreateNewMonth.add(jLabel2);

        monthsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        monthsList.setMaximumSize(new java.awt.Dimension(100, 30));
        monthsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthsListActionPerformed(evt);
            }
        });
        CreateNewMonth.add(monthsList);

        expenseDataLoader.setLayout(new javax.swing.BoxLayout(expenseDataLoader, javax.swing.BoxLayout.Y_AXIS));

        addExpensedata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Company", "expense", "Matrix", "Payment" }));
        addExpensedata.setMaximumSize(new java.awt.Dimension(140, 30));
        addExpensedata.setMinimumSize(new java.awt.Dimension(140, 30));
        addExpensedata.setPreferredSize(new java.awt.Dimension(140, 30));
        addExpensedata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpensedataActionPerformed(evt);
            }
        });
        expenseDataLoader.add(addExpensedata);
        expenseDataLoader.add(jLabel10);

        newExpenseData.setMargin(new java.awt.Insets(0, 0, 0, 0));
        newExpenseData.setMaximumSize(new java.awt.Dimension(140, 30));
        newExpenseData.setMinimumSize(new java.awt.Dimension(140, 30));
        newExpenseData.setPreferredSize(new java.awt.Dimension(140, 30));
        newExpenseData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newExpenseDataActionPerformed(evt);
            }
        });
        expenseDataLoader.add(newExpenseData);

        GitHub.setText("matrodriguezpa on Github");

        Copyrigth.setText("All expencer copygith");

        javax.swing.GroupLayout AboutLayout = new javax.swing.GroupLayout(About);
        About.setLayout(AboutLayout);
        AboutLayout.setHorizontalGroup(
            AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AboutLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(GitHub)
                .addGap(56, 56, 56))
            .addGroup(AboutLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(Copyrigth)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AboutLayout.setVerticalGroup(
            AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(GitHub)
                .addGap(44, 44, 44)
                .addComponent(Copyrigth)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        NewYear.setLayout(new javax.swing.BoxLayout(NewYear, javax.swing.BoxLayout.Y_AXIS));

        addWorkbookLabel3.setText("Name*");
        NewYear.add(addWorkbookLabel3);
        NewYear.add(addNewYearProjectName);

        addWorkbookLabel4.setText("Year");
        NewYear.add(addWorkbookLabel4);

        newYearProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newYearProjectActionPerformed(evt);
            }
        });
        NewYear.add(newYearProject);

        warning1.setForeground(java.awt.Color.red);
        NewYear.add(warning1);

        loadingPanel.setBackground(new java.awt.Color(255, 102, 153));
        loadingPanel.setLayout(new java.awt.BorderLayout());

        loadingImage.setBackground(new java.awt.Color(255, 51, 153));
        loadingImage.setForeground(new java.awt.Color(255, 51, 102));
        loadingImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Tittle.png"))); // NOI18N
        loadingPanel.add(loadingImage, java.awt.BorderLayout.CENTER);

        loadingFooter.setBackground(new java.awt.Color(255, 51, 102));
        loadingFooter.setDividerLocation(150);
        loadingFooter.setDividerSize(0);

        author.setForeground(new java.awt.Color(255, 255, 255));
        author.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        author.setText("By matrodriguezpa");
        loadingFooter.setRightComponent(author);

        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("v0.1 beta");
        loadingFooter.setLeftComponent(version);

        loadingPanel.add(loadingFooter, java.awt.BorderLayout.SOUTH);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("One spencer");
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(960, 540));

        rightSideBar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(null, "Add expense", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP)));
        rightSideBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        rightSideBar.setRollover(true);
        rightSideBar.setMaximumSize(new java.awt.Dimension(300, 300));
        rightSideBar.setMinimumSize(new java.awt.Dimension(300, 300));
        rightSideBar.setPreferredSize(new java.awt.Dimension(300, 300));

        newExpenseAddDate.setMaximumSize(new java.awt.Dimension(200, 30));
        newExpenseAddDate.setMinimumSize(new java.awt.Dimension(200, 30));
        newExpenseAddDate.setPreferredSize(new java.awt.Dimension(200, 30));
        newExpenseAddDate.setLayout(new javax.swing.BoxLayout(newExpenseAddDate, javax.swing.BoxLayout.LINE_AXIS));

        Date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Date.setText("Date");
        Date.setMaximumSize(new java.awt.Dimension(35, 30));
        Date.setMinimumSize(new java.awt.Dimension(35, 30));
        Date.setPreferredSize(new java.awt.Dimension(35, 30));
        newExpenseAddDate.add(Date);

        expenseDateYear.setModel(new javax.swing.SpinnerNumberModel(2025, null, null, 1));
        expenseDateYear.setEnabled(false);
        expenseDateYear.setMaximumSize(new java.awt.Dimension(65, 30));
        expenseDateYear.setMinimumSize(new java.awt.Dimension(65, 30));
        expenseDateYear.setPreferredSize(new java.awt.Dimension(65, 30));
        newExpenseAddDate.add(expenseDateYear);

        expenseDateMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        expenseDateMonth.setEnabled(false);
        expenseDateMonth.setFocusable(false);
        expenseDateMonth.setMaximumSize(new java.awt.Dimension(50, 30));
        expenseDateMonth.setMinimumSize(new java.awt.Dimension(50, 30));
        expenseDateMonth.setPreferredSize(new java.awt.Dimension(50, 30));
        newExpenseAddDate.add(expenseDateMonth);

        expenseDateDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        expenseDateDay.setMaximumSize(new java.awt.Dimension(50, 30));
        expenseDateDay.setMinimumSize(new java.awt.Dimension(50, 30));
        expenseDateDay.setPreferredSize(new java.awt.Dimension(50, 30));
        newExpenseAddDate.add(expenseDateDay);

        rightSideBar.add(newExpenseAddDate);

        newExpenseAddCompany.setMaximumSize(new java.awt.Dimension(200, 30));
        newExpenseAddCompany.setMinimumSize(new java.awt.Dimension(200, 30));
        newExpenseAddCompany.setPreferredSize(new java.awt.Dimension(200, 30));
        newExpenseAddCompany.setLayout(new javax.swing.BoxLayout(newExpenseAddCompany, javax.swing.BoxLayout.LINE_AXIS));

        companyLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyLabel.setText("Company");
        companyLabel.setMaximumSize(new java.awt.Dimension(80, 30));
        companyLabel.setMinimumSize(new java.awt.Dimension(80, 30));
        companyLabel.setPreferredSize(new java.awt.Dimension(80, 30));
        newExpenseAddCompany.add(companyLabel);

        company.setEditable(true);
        company.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "opcion1", "opcion2" }));
        company.setMaximumSize(new java.awt.Dimension(120, 30));
        company.setMinimumSize(new java.awt.Dimension(20, 20));
        company.setPreferredSize(new java.awt.Dimension(80, 20));
        newExpenseAddCompany.add(company);

        addCompanyButton.setBackground(new java.awt.Color(102, 102, 255));
        addCompanyButton.setForeground(new java.awt.Color(255, 255, 255));
        addCompanyButton.setText("+");
        addExpenseButtonGroup.add(addCompanyButton);
        addCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCompanyButton.setMaximumSize(new java.awt.Dimension(30, 30));
        addCompanyButton.setMinimumSize(new java.awt.Dimension(30, 30));
        addCompanyButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newExpenseAddCompany.add(addCompanyButton);

        rightSideBar.add(newExpenseAddCompany);

        newExpenseAddAmount.setMaximumSize(new java.awt.Dimension(200, 30));
        newExpenseAddAmount.setMinimumSize(new java.awt.Dimension(200, 30));
        newExpenseAddAmount.setLayout(new javax.swing.BoxLayout(newExpenseAddAmount, javax.swing.BoxLayout.LINE_AXIS));

        Amount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Amount.setText("Amount");
        Amount.setMaximumSize(new java.awt.Dimension(80, 30));
        Amount.setMinimumSize(new java.awt.Dimension(80, 30));
        Amount.setPreferredSize(new java.awt.Dimension(80, 30));
        newExpenseAddAmount.add(Amount);

        amount.setText("1000");
        amount.setMaximumSize(new java.awt.Dimension(120, 30));
        amount.setMinimumSize(new java.awt.Dimension(120, 30));
        amount.setPreferredSize(new java.awt.Dimension(120, 30));
        newExpenseAddAmount.add(amount);

        rightSideBar.add(newExpenseAddAmount);

        newExpenseAddExpense.setMaximumSize(new java.awt.Dimension(200, 30));
        newExpenseAddExpense.setMinimumSize(new java.awt.Dimension(200, 30));
        newExpenseAddExpense.setPreferredSize(new java.awt.Dimension(200, 30));
        newExpenseAddExpense.setLayout(new javax.swing.BoxLayout(newExpenseAddExpense, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Expense");
        jLabel6.setMaximumSize(new java.awt.Dimension(80, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(80, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 30));
        newExpenseAddExpense.add(jLabel6);

        expense.setEditable(true);
        expense.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personal", "Trabajo" }));
        expense.setMaximumSize(new java.awt.Dimension(120, 30));
        expense.setMinimumSize(new java.awt.Dimension(20, 20));
        expense.setPreferredSize(new java.awt.Dimension(80, 20));
        newExpenseAddExpense.add(expense);

        addExpenseButton.setBackground(new java.awt.Color(102, 102, 255));
        addExpenseButton.setForeground(new java.awt.Color(255, 255, 255));
        addExpenseButton.setText("+");
        addExpenseButtonGroup.add(addExpenseButton);
        addExpenseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addExpenseButton.setMaximumSize(new java.awt.Dimension(30, 30));
        addExpenseButton.setMinimumSize(new java.awt.Dimension(30, 30));
        addExpenseButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addExpenseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newExpenseAddExpense.add(addExpenseButton);

        rightSideBar.add(newExpenseAddExpense);

        newExpenseAddMatrix.setMaximumSize(new java.awt.Dimension(200, 30));
        newExpenseAddMatrix.setMinimumSize(new java.awt.Dimension(200, 30));
        newExpenseAddMatrix.setPreferredSize(new java.awt.Dimension(200, 30));
        newExpenseAddMatrix.setLayout(new javax.swing.BoxLayout(newExpenseAddMatrix, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Matrix");
        jLabel7.setMaximumSize(new java.awt.Dimension(80, 30));
        jLabel7.setMinimumSize(new java.awt.Dimension(80, 30));
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 30));
        newExpenseAddMatrix.add(jLabel7);

        matrix.setEditable(true);
        matrix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Universidad" }));
        matrix.setMaximumSize(new java.awt.Dimension(120, 30));
        matrix.setMinimumSize(new java.awt.Dimension(20, 20));
        matrix.setPreferredSize(new java.awt.Dimension(80, 20));
        newExpenseAddMatrix.add(matrix);

        addMatrixButton.setBackground(new java.awt.Color(102, 102, 255));
        addMatrixButton.setForeground(new java.awt.Color(255, 255, 255));
        addMatrixButton.setText("+");
        addExpenseButtonGroup.add(addMatrixButton);
        addMatrixButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addMatrixButton.setMaximumSize(new java.awt.Dimension(30, 30));
        addMatrixButton.setMinimumSize(new java.awt.Dimension(30, 30));
        addMatrixButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addMatrixButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newExpenseAddMatrix.add(addMatrixButton);

        rightSideBar.add(newExpenseAddMatrix);

        newExpenseAddPayment.setMaximumSize(new java.awt.Dimension(200, 30));
        newExpenseAddPayment.setMinimumSize(new java.awt.Dimension(200, 30));
        newExpenseAddPayment.setPreferredSize(new java.awt.Dimension(200, 30));
        newExpenseAddPayment.setLayout(new javax.swing.BoxLayout(newExpenseAddPayment, javax.swing.BoxLayout.LINE_AXIS));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Payment");
        jLabel8.setMaximumSize(new java.awt.Dimension(80, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(80, 30));
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 30));
        newExpenseAddPayment.add(jLabel8);

        payment.setEditable(true);
        payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta", "Efectivo" }));
        payment.setMaximumSize(new java.awt.Dimension(120, 30));
        payment.setMinimumSize(new java.awt.Dimension(20, 20));
        payment.setPreferredSize(new java.awt.Dimension(80, 20));
        newExpenseAddPayment.add(payment);

        addPaymentButton.setBackground(new java.awt.Color(102, 102, 255));
        addPaymentButton.setForeground(new java.awt.Color(255, 255, 255));
        addPaymentButton.setText("+");
        addExpenseButtonGroup.add(addPaymentButton);
        addPaymentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addPaymentButton.setMaximumSize(new java.awt.Dimension(30, 30));
        addPaymentButton.setMinimumSize(new java.awt.Dimension(30, 30));
        addPaymentButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addPaymentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newExpenseAddPayment.add(addPaymentButton);

        rightSideBar.add(newExpenseAddPayment);

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

        mainTableHeader.setRollover(true);
        mainTableHeader.setMaximumSize(new java.awt.Dimension(150, 30));
        mainTableHeader.setMinimumSize(new java.awt.Dimension(150, 30));
        mainTableHeader.setPreferredSize(new java.awt.Dimension(150, 30));
        mainTableHeader.setRequestFocusEnabled(false);

        addProject.setBackground(new java.awt.Color(51, 102, 255));
        addProject.setForeground(new java.awt.Color(255, 255, 255));
        addProject.setText("AddProject");
        addProject.setFocusable(false);
        addProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainTableHeader.add(addProject);

        addMonth.setBackground(new java.awt.Color(51, 102, 255));
        addMonth.setForeground(new java.awt.Color(255, 255, 255));
        addMonth.setText("AddMonth");
        addMonth.setFocusable(false);
        addMonth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addMonth.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMonthActionPerformed(evt);
            }
        });
        mainTableHeader.add(addMonth);

        main.add(mainTableHeader, java.awt.BorderLayout.PAGE_START);

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

        exitProgramItem.setText("Exit program");
        fileMenu.add(exitProgramItem);

        menuBar.add(fileMenu);

        helpMenu.setBackground(new java.awt.Color(51, 102, 255));
        helpMenu.setText("Help");

        userDocItem.setText("Documentation");
        helpMenu.add(userDocItem);

        javadocItem.setText("Javadoc");
        helpMenu.add(javadocItem);

        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthsListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthsListActionPerformed

    private void addMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMonthActionPerformed

    private void newProjectYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProjectYearActionPerformed

    private void newExpenseDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newExpenseDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newExpenseDataActionPerformed

    private void addExpensedataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpensedataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addExpensedataActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutItemActionPerformed

    private void newYearProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newYearProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newYearProjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel About;
    private javax.swing.JLabel Amount;
    private javax.swing.JLabel Copyrigth;
    private javax.swing.JPanel CreateNewMonth;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel GitHub;
    private javax.swing.JPanel NewProject;
    private javax.swing.JPanel NewYear;
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JButton addCompanyButton;
    private javax.swing.JButton addExpense;
    private javax.swing.JButton addExpenseButton;
    private javax.swing.ButtonGroup addExpenseButtonGroup;
    private javax.swing.JComboBox<String> addExpensedata;
    private javax.swing.JButton addMatrixButton;
    private javax.swing.JButton addMonth;
    private javax.swing.JLabel addNewYearProjectName;
    private javax.swing.JButton addPaymentButton;
    private javax.swing.JButton addProject;
    private javax.swing.JLabel addWorkbookLabel1;
    private javax.swing.JLabel addWorkbookLabel2;
    private javax.swing.JLabel addWorkbookLabel3;
    private javax.swing.JLabel addWorkbookLabel4;
    private javax.swing.JTextField amount;
    private javax.swing.JLabel author;
    private javax.swing.JMenuItem closeProjectItem;
    private javax.swing.JComboBox<String> company;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JMenuItem exitProgramItem;
    private javax.swing.JComboBox<String> expense;
    private javax.swing.JPanel expenseDataLoader;
    private javax.swing.JSpinner expenseDateDay;
    private javax.swing.JSpinner expenseDateMonth;
    private javax.swing.JSpinner expenseDateYear;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JToolBar footer;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem javadocItem;
    private javax.swing.JTree leftNavigation;
    private javax.swing.JScrollPane leftScroll;
    private javax.swing.JToolBar leftSibeBar;
    private javax.swing.JSplitPane loadingFooter;
    private javax.swing.JLabel loadingImage;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JPanel main;
    private javax.swing.JTable mainTable;
    private javax.swing.JToolBar mainTableHeader;
    private javax.swing.JScrollPane mainTableScroll;
    private javax.swing.JComboBox<String> matrix;
    private javax.swing.JMenuBar menuBar;
    public javax.swing.JComboBox<String> monthsList;
    private javax.swing.JPanel newExpenseAddAmount;
    private javax.swing.JPanel newExpenseAddCompany;
    private javax.swing.JPanel newExpenseAddDate;
    private javax.swing.JPanel newExpenseAddExpense;
    private javax.swing.JPanel newExpenseAddMatrix;
    private javax.swing.JPanel newExpenseAddPayment;
    private javax.swing.JTextField newExpenseData;
    private javax.swing.JMenuItem newProjectItem;
    private javax.swing.JTextField newProjectName;
    private javax.swing.JTextField newProjectYear;
    private javax.swing.JTextField newYearProject;
    private javax.swing.JMenuItem openProjectItem;
    private javax.swing.JComboBox<String> payment;
    private javax.swing.JLabel programVersion;
    private javax.swing.JPanel projectList;
    private javax.swing.JToolBar rightSideBar;
    private javax.swing.JMenuItem userDocItem;
    private javax.swing.JLabel version;
    private javax.swing.JLabel warning;
    private javax.swing.JLabel warning1;
    // End of variables declaration//GEN-END:variables
}

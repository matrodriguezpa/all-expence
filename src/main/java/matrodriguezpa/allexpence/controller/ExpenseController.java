package matrodriguezpa.allexpence.controller;

import java.awt.Component;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import matrodriguezpa.allexpence.dao.ExpenseDAO;
import matrodriguezpa.allexpence.dao.MonthDAO;
import matrodriguezpa.allexpence.dao.ProjectDAO;
import matrodriguezpa.allexpence.model.Expense;
import matrodriguezpa.allexpence.model.Month;
import matrodriguezpa.allexpence.model.Project;
import matrodriguezpa.allexpence.view.View;

public class ExpenseController {

    View view;

    ProjectDAO projectDao = new ProjectDAO();
    MonthDAO monthDao = new MonthDAO();
    ExpenseDAO expenseDao = new ExpenseDAO();

    public ExpenseController(View view) {
        view.getAddMonth().addActionListener(e -> createMonth());
        view.getAddExpense().addActionListener(e -> createExpense());
        view.getAddCompanyButton().addActionListener(e -> expeseAddButton(0));
        view.getAddExpenseButton().addActionListener(e -> expeseAddButton(1));
        view.getAddMatrixButton().addActionListener(e -> expeseAddButton(2));
        view.getAddPaymentButton().addActionListener(e -> expeseAddButton(3));
    }

    private void createMonth() {
        // Fetch all projects via DAO
        List<Project> projects = projectDao.findAll();

        // Prepare UI container
        ButtonGroup buttonGroup = new ButtonGroup();
        JPanel projectListPanel = view.getProjectList();
        projectListPanel.removeAll();             // clear existing components

        // For each project, if its name matches, add a radio button + label
        for (Project proj : projects) {
            if (proj.getName().equals(MainController.projectName)) {
                JPanel panelButtonList = new JPanel();
                JLabel label = new JLabel(proj.getName());
                JRadioButton radioButton = new JRadioButton(String.valueOf(proj.getYear()));

                buttonGroup.add(radioButton);
                panelButtonList.add(label);
                panelButtonList.add(radioButton);

                projectListPanel.add(panelButtonList);
            }
        }

        // Mostrar el diálogo para crear el mes
        int result = JOptionPane.showConfirmDialog(view, view.getCreateNewMonth(), "Create Month", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener el mes seleccionado
            int month = view.getMonthsList().getSelectedIndex() + 1;

            // Buscar en cada sub-panel la etiqueta y el botón de opción seleccionado
            for (Component comp : view.getProjectList().getComponents()) {
                if (comp instanceof JPanel panel) {
                    String labelText = null;
                    String selectedRadioText = null;

                    for (Component sub : panel.getComponents()) {
                        if (sub instanceof JLabel label) {
                            labelText = label.getText();
                        } else if (sub instanceof JRadioButton radio && radio.isSelected()) {
                            selectedRadioText = radio.getText();
                        }
                    }

                    if (labelText != null && selectedRadioText != null) {
                        MainController.projectName = labelText;
                        MainController.projectYear = selectedRadioText;
                        break;
                    }
                }
            }

            if (MainController.projectName != null && MainController.projectYear != null) {
                //la tabla se crea automaticamente
                //createProjectMonthTable(projectName, Integer.parseInt(projectYear), month);
                //insertNewMonth(month, projectName);

                Project project = projectDao.findByName(MainController.projectName);

                Month newMonth = Month.builder()
                        .MONTH(month)
                        .project(project)
                        .build();

                monthDao.save(newMonth); //insertar mes
            }
        }
        MainController.updateNavigationTree();
    }

    private void createExpense() {
        // Establecer los valores para cada columna (ajustar según los tipos de datos de las columnas)
        int year = (int) view.getExpenseDateYear().getValue();
        int month = (int) view.getExpenseDateMonth().getValue();
        int day = (int) view.getExpenseDateDay().getValue();
        System.out.println("Fecha insertada:" + year + "-" + month + "-" + day);
        Expense.validateDate(month, day);

        int index = view.getExpense().getSelectedIndex();
        String company = view.getCompany().getItemAt(index);  // Razon social

        Double amount = Double.valueOf(view.getAmount().getText()); // Monto
        Expense.validateAmount(amount);

        index = view.getExpense().getSelectedIndex();
        String expense = view.getExpense().getItemAt(index); // Gasto

        index = view.getMatrix().getSelectedIndex();
        String matrix = view.getMatrix().getItemAt(index); // Matriz

        index = view.getPayment().getSelectedIndex();
        String payment = view.getPayment().getItemAt(index); // Forma de pago

        //encontrar a que mesId pertenece
        Project project = projectDao.findByName(MainController.projectName);
        Month foundMonth = null;
        List<Month> projectMonths = project.getMonth();
        for (Month i : projectMonths) {
            if (i.getMONTH() == month) {
                foundMonth = i;
            }
        }

        Expense newExpense = Expense.builder()
                .YEAR(year)
                .MONTH(month)
                .DAY(day)
                .company(company)
                .amount(amount)
                .type(expense)
                .matrix(matrix)
                .payment(payment)
                .month(foundMonth)
                .build();

        expenseDao.save(newExpense);

        MainController.updateMainTable();
        JOptionPane.showMessageDialog(null, "Inserción exitosa.");
    }

    //agregar datos para el usuario visualizar
    private void expeseAddButton(int index) {//el indice seleccionadode la lista company, expense, matrix, payment

        view.getAddExpensedata().setSelectedIndex(index);

        int result = JOptionPane.showConfirmDialog(
                null,
                view.getExpenseDataLoader(),
                "Enter Expense",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String resultado = view.getNewExpenseData().getText();
            switch (index) {
                case 0 ->
                    view.getCompany().addItem(resultado);
                case 1 ->
                    view.getExpense().addItem(resultado);
                case 2 ->
                    view.getMatrix().addItem(resultado);
                case 3 ->
                    view.getPayment().addItem(resultado);

            }
        }
    }

    /*private void createProjectMonthTable(String projectName, int projectYear, int projectMonth) {
        // Sanitize or validate table name inputs to avoid SQL injection
        String monthTableName = projectName + "_" + projectYear + "_" + projectMonth; // ex:teo_2024_1 Use underscore as a separator

        String sql = "CREATE TABLE IF NOT EXISTS " + monthTableName + " ("
                + "date VARCHAR(255), " // Using VARCHAR for strings
                + "company VARCHAR(255), " // Adjusting types based on SQL standards
                + "amount REAL, " // 'REAL' is fine for floating-point numbers
                + "expense VARCHAR(255), "
                + "matrix VARCHAR(255), "
                + "payment VARCHAR(255));";

        try {
            model.executeUpdate(sql);
            JOptionPane.showMessageDialog(view, "Month in a Project table: '" + monthTableName + "' created.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creando la tabla: " + e.getMessage());
        }
    }
     *//*
    private void insertNewMonth(int monthNumber, String projectName) {
        if (monthNumber < 1 || monthNumber > 12) {
            JOptionPane.showMessageDialog(view, "Invalid month number.");
            return;
        }

        String monthColumn = "month_" + monthNumber;
        String sql = "UPDATE projects SET " + monthColumn + " = ? WHERE name = ?";

        try {
            model.executeUpdateProjectMonthBudget(sql, "1", projectName);
            JOptionPane.showMessageDialog(view, "Month " + monthNumber + " added for the project " + projectName + ".");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error adding month to the project: " + e.getMessage());
        }
    }
     */
    //crear insertar expense
    /*
    private void createMonth() {
        // Buscar los proyectos de usuario
        ResultSet resul = null;
        try {
            resul = model.executeQuery("SELECT * FROM projects");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        ButtonGroup buttonGroup = new ButtonGroup();
        view.getProjectList().removeAll(); // Clear existing components before adding new ones

        try {
            // Crear un botón de opción por cada name encontrado
            while (resul.next()) {
                String projectNamelist = resul.getString(1);
                String projectYearlist = resul.getString(2);

                // Create a new panel for each model-year entry
                if (projectNamelist.equals(projectName)) {
                    JPanel panelButtonList = new JPanel();

                    JLabel label = new JLabel(projectNamelist);
                    JRadioButton radioButton = new JRadioButton(projectYearlist);

                    buttonGroup.add(radioButton);
                    panelButtonList.add(label);
                    panelButtonList.add(radioButton);

                    // Add directly to view's panel
                    view.getProjectList().add(panelButtonList);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Mostrar el diálogo para crear el mes
        int result = JOptionPane.showConfirmDialog(view, view.getCreateNewMonth(), "Create Month", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener el mes seleccionado
            int month = view.getMonthsList().getSelectedIndex() + 1;

            // Buscar en cada sub-panel la etiqueta y el botón de opción seleccionado
            for (Component comp : view.getProjectList().getComponents()) {
                if (comp instanceof JPanel panel) {
                    String labelText = null;
                    String selectedRadioText = null;

                    for (Component sub : panel.getComponents()) {
                        if (sub instanceof JLabel label) {
                            labelText = label.getText();
                        } else if (sub instanceof JRadioButton radio && radio.isSelected()) {
                            selectedRadioText = radio.getText();
                        }
                    }

                    if (labelText != null && selectedRadioText != null) {
                        this.projectName = labelText;
                        this.projectYear = selectedRadioText;
                        break;
                    }
                }
            }

            if (projectName != null && projectYear != null) {
                createProjectMonthTable(projectName, Integer.parseInt(projectYear), month);
                insertNewMonth(month, projectName);
            }
        }
        updateNavigationTree();
    }
    private void createExpense() {
        try {

            String sql = "INSERT INTO " + projectName + "_" + projectYear + "_" + proyectMonth + " (date, company, amount, expense, matrix, payment) VALUES (?, ?, ?, ?, ?, ?)";

            // Establecer los valores para cada columna (ajustar según los tipos de datos de las columnas)
            int Year = (int) view.getExpenseDateYear().getValue();
            int Month = (int) view.getExpenseDateMonth().getValue();
            int Day = (int) view.getExpenseDateDay().getValue();
            String Date = Year + "-" + Month + "-" + Day; // Fecha
            System.out.println("Fecha insertada:" + Date);

            //validar la fecha
            if (Month == 2 && Day > 29) {
                JOptionPane.showMessageDialog(null, "Fecha invalida.");
            }

            int index = view.getExpense().getSelectedIndex();
            String Company = view.getCompany().getItemAt(index);  // Razon social

            Double Amount = Double.valueOf(view.getAmount().getText()); // Monto

            //Validación de la cantidad.
            if (Amount < 0) {
                JOptionPane.showMessageDialog(null, "Monto inválido.");
            }

            index = view.getExpense().getSelectedIndex();
            String Expense = view.getExpense().getItemAt(index); // Gasto

            index = view.getMatrix().getSelectedIndex();
            String Matrix = view.getMatrix().getItemAt(index); // Matriz

            index = view.getPayment().getSelectedIndex();
            String Payment = view.getPayment().getItemAt(index); // Forma de pago

            // Ejecutar la consulta
            model.executeUpdate4(sql, Date, Company, Amount, Expense, Matrix, Payment);
            MainController.updateMainTable();
            JOptionPane.showMessageDialog(null, "Inserción exitosa.");

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }     
     */
}

package matrodriguezpa.allexpence.controller;

import matrodriguezpa.allexpence.model.model;
import matrodriguezpa.allexpence.view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private final model model;
    private final View view;

    private String projectName;
    private String projectYear;
    private String projectMonth;

    private DefaultTableModel tableModel;
    private DefaultTreeModel treeModel;

    /*Constructor*/
    public Controller(model model, View view) {
        this.model = model;
        this.view = view;
        initController();
    }

    /*main methods*/
    public void start() {
        view.setVisible(true);
    }

    private void initController() {
        // Agregar las acciones de los botónes de la pantalla principal

        //program
        view.getExitProgramItem().addActionListener(e -> closeProgram());

        //user

        //project-period
        view.getNewProjectItem().addActionListener(e -> createProject());
        view.getOpenProjectItem().addActionListener(e -> openProject());
        view.getCloseProjectItem().addActionListener(e -> closeProject());

        //table-year
        view.getAddProject().addActionListener(e -> createYear());
        //expence-month
        view.getAddMonth().addActionListener(e -> createMonth());
        view.getAddExpense().addActionListener(e -> createExpense());
        view.getAddCompanyButton().addActionListener(e -> expeseAddButton(0));
        view.getAddExpenseButton().addActionListener(e -> expeseAddButton(1));
        view.getAddMatrixButton().addActionListener(e -> expeseAddButton(2));
        view.getAddPaymentButton().addActionListener(e -> expeseAddButton(3));

        //App info
        view.getAboutItem().addActionListener(e -> openAboutWindow());
        view.getJavadocItem().addActionListener(e -> openJavaDoc());
        view.getUserDocItem().addActionListener(e -> openDocumentation());

        view.getNewProjectName().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    showSpaceWarning();
                }
            }
        });

        //view update
        view.getLeftNavigation().addTreeSelectionListener(e -> LeftNavigationValueChanged());
        updateNavigationTree();
        setViewVisible(false);
    }

    //MODELO (CONEXION Y CREACION DE LAS TABLAS)
    /*Starting*/
    private void connectDatabase() {
        try {
            model.connect();
            JOptionPane.showMessageDialog(view, "Conexión exitosa.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void createProjectListTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS projects (name TEXT NOT NULL, year TEXT NOT NULL");

        for (int i = 1; i <= 12; i++) {
            sqlBuilder.append(String.format(", month_%d INTEGER", i));
        }

        sqlBuilder.append(");");

        try {
            model.executeUpdate(sqlBuilder.toString());
            JOptionPane.showMessageDialog(view, "List of Projects table created.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void createProjectMonthTable(String projectName, int projectYear, int projectMonth) {
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

    //MODELO (INSERSION DE DATOS)
    /*Insertions on tables*/
    private void insertNewProject(String name, String year) {
        String sql = "INSERT INTO projects (name, year) VALUES (?,?)"; // SQL para insertar solo el usuario y el nombre del name
        try {
            model.executeUpdateProjectNameAndYear(sql, name, year);
            JOptionPane.showMessageDialog(view, "Project created succesfully.", "Succes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creating the project: " + e.getMessage());
        }
    }//insert a new model on the model list table

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

    private void createProject() {
        while (true) {
            int result = JOptionPane.showConfirmDialog(
                    view,
                    view.getNewProject(),
                    "New Project",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION) {
                return;
            }

            String rawName = view.getNewProjectName().getText().trim();
            String yearText = view.getNewProjectYear().getText().trim();

            if (!validateInputs(rawName, yearText)) {
                continue;
            }

            this.projectName = rawName.replace(' ', '_');
            this.projectYear = validateYear(yearText);
            break;
        }

        connectDatabase();
        createProjectListTable();
        insertNewProject(projectName, projectYear);
        updateNavigationTree();

        if (JOptionPane.showConfirmDialog(view, "Create new month?", "New month",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            createMonth();
            updateNavigationTree();
        }
        setViewVisible(true);
        updateNavigationTree();
    }

    private boolean validateInputs(String name, String year) {
        if (name.isEmpty()) {
            showError("You must insert a project name.");
            return false;
        }

        if (!name.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            showError("The project name may only contain letters and spaces.");
            return false;
        }

        try {
            int y = Integer.parseInt(year);
            if (y < 0 || y > 9999) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showError("Project year must be a non-negative integer no greater than 9999.");
            return false;
        }

        return true;
    }

    private String validateYear(String yearText) {
        if (yearText == null || yearText.trim().isEmpty()) {
            throw new IllegalArgumentException("Year cannot be empty");
        }

        try {
            int year = Integer.parseInt(yearText);
            if (year < 0 || year > 9999) {
                throw new IllegalArgumentException("Year must be between 0-9999");
            }
            return String.valueOf(year);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number");
        }
    }

    //VIEW
    private void showError(String message) {
        JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Later in the class
    private void showSpaceWarning() {
        view.getWarning().setText("El proyecto será guardado como texto-con-espacios");
    }

    private void closeProject() {
        projectName = null;
        projectYear = null;
        projectMonth = null;

        updateMainTable();
        updateNavigationTree();

        setViewVisible(false);
    }

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
            String sql = "INSERT INTO " + projectName + "_" + projectYear + "_" + projectMonth + " (date, company, amount, expense, matrix, payment) VALUES (?, ?, ?, ?, ?, ?)";

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
            updateMainTable();
            JOptionPane.showMessageDialog(null, "Inserción exitosa.");

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void createYear() {
        while (true) {
            view.getAddNewYearProjectName().setText(projectName);

            int result = JOptionPane.showConfirmDialog(
                    view,
                    view.getNewYear(),
                    "New year",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION) {
                return;
            }

            String yearText = view.getNewYearProject().getText().trim();

            try {
                validateYear(yearText);
                this.projectYear = yearText;
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view,
                        "Please enter a valid year (0-9999)",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            insertNewProject(projectName, projectYear);
            updateNavigationTree();

            if (JOptionPane.showConfirmDialog(view, "Create new month?", "New month",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                createMonth();
            }
            updateNavigationTree();
            break;
        }

    }


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
                case 0 -> {
                    view.getCompany().addItem(resultado);
                }
                case 1 -> {
                    view.getExpense().addItem(resultado);
                }
                case 2 -> {
                    view.getMatrix().addItem(resultado);
                }
                case 3 -> {
                    view.getPayment().addItem(resultado);
                }
            }
        }
    }

    /*update view*/
    private void updateNavigationTree() {
        if (projectName == null) {
            // Clear the tree by setting an empty root
            DefaultMutableTreeNode emptyRoot = new DefaultMutableTreeNode("No Project");
            treeModel = new DefaultTreeModel(emptyRoot);
            view.getLeftNavigation().setModel(treeModel);
            return;
        }
        try {
            ResultSet resul = model.executeQuery("SELECT * FROM projects WHERE name = '" + projectName + "'");

            // Crear el nodo raíz del árbol
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(projectName);

            // Recorrer todos los proyectos
            while (resul.next()) {
                String proyecto = resul.getString(2);
                DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode(proyecto);

                // seleccionar de cada resultado donde idProyectoMesN no sea null
                for (int i = 1; i <= 12; i++) {
                    String columnIdProyectoMes = "month_" + i; // Nombre de la columna
                    if (resul.getString(columnIdProyectoMes) != null) {
                        String monthName = String.valueOf(i);
                        DefaultMutableTreeNode monthNode = new DefaultMutableTreeNode(monthName);
                        projectNode.add(monthNode);
                    }
                }

                // Agregar el name al nodo raíz
                root.add(projectNode);
            }

            // Crear el modelo del árbol con el nodo raíz
            treeModel = new DefaultTreeModel(root);
            view.getLeftNavigation().setModel(treeModel);

            // Expandir todos los nodos del árbol
            expandAllNodes(view.getLeftNavigation(), root);

            LeftNavigationValueChanged2(root);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void setViewVisible(Boolean value) {
        view.getAddProject().setEnabled(value);
        view.getAddMonth().setEnabled(value);
        view.getAddExpense().setEnabled(value);
        view.getLeftNavigation().setEnabled(value);
        view.getMainTable().setEnabled(value);
        view.getExpenseDateDay().setEnabled(value);
        view.getCompany().setEnabled(value);
        view.getAddCompanyButton().setEnabled(value);
        view.getAmount().setEnabled(value);
        view.getExpense().setEnabled(value);
        view.getAddExpense().setEnabled(value);
        view.getMatrix().setEnabled(value);
        view.getAddMatrixButton().setEnabled(value);
        view.getPayment().setEnabled(value);
        view.getAddPaymentButton().setEnabled(value);
    }

    private void expandAllNodes(JTree tree, DefaultMutableTreeNode node) {
        // Método auxiliar para expandir todos los nodos
        int row = tree.getRowForPath(new TreePath(node.getPath()));
        if (row != -1) {
            tree.expandRow(row);
            for (int i = 0; i < node.getChildCount(); i++) {
                expandAllNodes(tree, (DefaultMutableTreeNode) node.getChildAt(i));
            }
        }
    }

    //si el nodo seleccionado en la navegación cambia, actualizar la tabla principal
    private void LeftNavigationValueChanged() {
        // Obtener el nodo seleccionado del JTree
        TreePath selectedPath = view.getLeftNavigation().getSelectionPath();

        // Verificar si hay un nodo seleccionado
        if (selectedPath != null) {
            // Obtener el nodo seleccionado
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();

            // Verificar si el nodo es una hoja (nodo final)
            if (selectedNode.isLeaf()) {
                // Asignar el valor del mes correspondiente al nodo seleccionado
                this.projectMonth = (String) selectedNode.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
                this.projectYear = (String) parent.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                parent = (DefaultMutableTreeNode) parent.getParent();
                this.projectName = (String) parent.getUserObject();

                System.out.println(this.projectMonth);
                System.out.println(this.projectYear);
                System.out.println(this.projectName);
                updateMainTable();
            }
        }
    }

    private void LeftNavigationValueChanged2(DefaultMutableTreeNode root) {
        // Buscar la primera hoja del árbol
        DefaultMutableTreeNode currentNode = root;
        while (!currentNode.isLeaf() && currentNode.getChildCount() > 0) {
            currentNode = (DefaultMutableTreeNode) currentNode.getFirstChild();
        }

        if (currentNode != root) {  // Si encontramos una hoja (que no sea el root)
            view.getLeftNavigation().setSelectionPath(new TreePath(currentNode.getPath()));
            LeftNavigationValueChanged();
        }
    }

    private void updateMainTable() {
        tableModel = (DefaultTableModel) view.getMainTable().getModel();
        tableModel.setRowCount(0);

        if (projectName == null) {
            return;
        }

        try {
            String sql = "SELECT * FROM " + projectName + "_" + projectYear + "_" + projectMonth;
            System.out.println("Consulta SQL: " + sql);
            ResultSet resul = model.executeQuery(sql);

            while (resul.next()) {
                tableModel.addRow(new Object[]{
                        resul.getString("date"),
                        resul.getString("company"),
                        resul.getDouble("amount"),
                        resul.getString("expense"),
                        resul.getString("matrix"),
                        resul.getString("payment"),});
            }
            view.getExpenseDateYear().setValue(Integer.valueOf(projectYear));
            view.getExpenseDateMonth().setValue(Integer.valueOf(projectMonth));
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    /*abrir name*/
    private void openProject() {

        // Simula la consulta a la base de datos para obtener los usuarios únicos
        List<String> usuarios = getUsuariosDeProyectos();
        if (usuarios == null) {
            JOptionPane.showMessageDialog(null, "Tabla usuarios no existente o no hay usuarios en la tabla.");
            return;
        }

        // Crear un ButtonGroup para que los radio buttons sean mutuamente excluyentes
        ButtonGroup grupoUsuarios = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usamos un layout vertical para los radio buttons

        // Crear un radio button por cada usuario y añadirlo al panel
        for (String usuario : usuarios) {
            JRadioButton radioButton = new JRadioButton(usuario);
            grupoUsuarios.add(radioButton); // Añadimos el radio button al grupo
            panel.add(radioButton); // Añadimos el radio button al panel
        }

        // Mostrar el diálogo con el panel de radio buttons
        int result = JOptionPane.showConfirmDialog(null, panel, "Open project", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si se presiona OK
        if (result == JOptionPane.OK_OPTION) {
            // Buscar el radio button seleccionado
            Enumeration<AbstractButton> elementos = grupoUsuarios.getElements();
            while (elementos.hasMoreElements()) {
                AbstractButton radioButton = elementos.nextElement();
                if (radioButton.isSelected()) {
                    this.projectName = radioButton.getText(); // Asigna el usuario seleccionado a projectYear
                    updateNavigationTree();
                    break;
                }
            }
            //mostrar los botones de agregar años, mes y gastos 
            setViewVisible(true);
        }
    }

    //method to get unique users
    private List<String> getUsuariosDeProyectos() {
        List<String> usuarios = new ArrayList<>();
        try {
            // Consulta SQL para obtener usuarios únicos de la tabla proyectos
            String sql = "SELECT DISTINCT name FROM projects";
            // Añadir cada usuario a la lista
            try (ResultSet rs = model.executeQuery(sql)) {
                // Añadir cada usuario a la lista
                while (rs.next()) {
                    usuarios.add(rs.getString("name"));
                }
            }
            return usuarios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }


    /* Methods to close up the programm */
    private void cleanupResources() {
        // Perform any cleanup tasks, such as saving data or closing files
        System.out.println("Cleaning up resources...");
        // Add your resource cleanup code here

        try {
            model.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeProgram() {
        // Confirm if the user really wants to exit the program
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            cleanupResources();
            System.exit(0);
        }
    }


    private void openAboutWindow() {

        // Create a JOptionPane with the panel and OK option
        JOptionPane optionPane = new JOptionPane(view.getAbout(), JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);

        // Create a JDialog to show the option pane
        JDialog dialog = optionPane.createDialog("About");

        // Optional: make it modal
        dialog.setModal(true);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    private void openJavaDoc() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.openai.com"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error abriendo link");
        }
    }

    private void openDocumentation() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.openai.com"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error abriendo link");
        }
    }

}

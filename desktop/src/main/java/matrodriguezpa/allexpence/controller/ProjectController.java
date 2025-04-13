package matrodriguezpa.allexpence.controller;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.AbstractButton;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

import matrodriguezpa.allexpence.model.project;
import matrodriguezpa.allexpence.view.Export;
import matrodriguezpa.allexpence.view.Main;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ProjectController {

    private final project model;
    private final Main view;

    private String projectName;
    private String projectYear;
    private String proyectMonth;

    private DefaultTableModel tableModel;
    private DefaultTreeModel treeModel;
    ButtonGroup buttonGroup = new ButtonGroup();

    public ProjectController(project model, Main view) {
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
        view.getNewProjectItem().addActionListener(e -> createProject());
        view.getOpenProjectItem().addActionListener(e -> openProject());
        view.getAddWorkBook().addActionListener(e -> createProject());
        view.getAddWorkBook1().addActionListener(e -> createMonth());
        view.getLeftNavigation().addTreeSelectionListener(e -> LeftNavigationValueChanged());
        view.getAddExpense().addActionListener(e -> createExpense());
        view.getExportItem().addActionListener(e -> ExportProject());
        view.getExitProgramItem().addActionListener(e -> closeProgram());
        view.getPreviewItem().addActionListener(e -> openPreview());
        view.getAddCompanyButton().addActionListener(e -> expeseAddButton(0));
        view.getAddExpenseButton().addActionListener(e -> expeseAddButton(1));
        view.getAddMatrixButton().addActionListener(e -> expeseAddButton(2));
        view.getAddPaymentButton().addActionListener(e -> expeseAddButton(3));
        
        //view.getAutoBudgetCheckBox().addActionListener(e -> monthlybudget());
        
        
        updateNavigationTree();
    }

    /*starting*/
    private void connectDatabase() {
        try {
            model.connect();
            JOptionPane.showMessageDialog(view, "Conexión exitosa.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void getSettings() {
        //ConfigController
    }

    /*Tables creation*/
    private void createProjectListTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS projects (name TEXT NOT NULL, year TEXT NOT NULL");

        for (int i = 1; i <= 12; i++) {
            sqlBuilder.append(String.format(", budget_%d REAL", i));
        }

        sqlBuilder.append(");");

        try {
            model.executeUpdate(sqlBuilder.toString());
            JOptionPane.showMessageDialog(view, "Project table created.");
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
            model.executeUpdate(sql);  // Assumes model handles statement execution
            JOptionPane.showMessageDialog(view, "Project's month table: '" + monthTableName + "' created.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creando la tabla: " + e.getMessage());
        }
    }

    /*Insertions on tables*/
    private void insertNewProject(String name, String year) {
        String sql = "INSERT INTO projects (name, year) VALUES (?,?)"; // SQL para insertar solo el usuario y el nombre del name
        try {
            model.executeUpdateProjectNameAndYear(sql, name, year);
            JOptionPane.showMessageDialog(view, "Project created succesfully.", "Succes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creating the project: " + e.getMessage());
        }
    }//insert a new project on the project list table

    private void insertNewMonth(String newProjectMonthBudget, int monthNumber, String projectName) {
        if (monthNumber < 1 || monthNumber > 12) {
            JOptionPane.showMessageDialog(view, "Invalid month number.");
            return;
        }
        if (newProjectMonthBudget == null || newProjectMonthBudget.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Budget cannot be empty.");
            return;
        }
        String budgetColumn = "budget_" + monthNumber;
        String sql = "UPDATE projects SET " + budgetColumn + " = ? WHERE name = ?";

        try {
            model.executeUpdateProjectMonthBudget(sql, newProjectMonthBudget, projectName);
            JOptionPane.showMessageDialog(view, "Month " + monthNumber + " added for the project " + projectName + ".");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error adding month to the project: " + e.getMessage());
        }
    }

    private void createProject() {
        int result = JOptionPane.showConfirmDialog(view, view.getNewProjectJPanel(), "New Proyect", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            this.projectName = view.getjTextField1().getText();
            this.projectYear = view.getjTextField2().getText();

            if (projectName.isEmpty()) {
                JOptionPane.showMessageDialog(view, "You must insert a project name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            connectDatabase();
            createProjectListTable();

            insertNewProject(projectName, projectYear); //Se agrega el name en la tabla de proyectos
            updateNavigationTree(); //Se carga el name en la vista

            result = JOptionPane.showConfirmDialog(view, "Create new month?", "New month", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                createMonth();
                updateNavigationTree();
            }

        }
    }

    private void createMonth() {
        // Buscar los proyectos de usuario
        ResultSet resul = null;
        try {
            resul = model.executeQuery("SELECT * FROM projects");
        } catch (SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ButtonGroup buttonGroup = new ButtonGroup();
        view.getProyectListJpanel().removeAll(); // Clear existing components before adding new ones

        try {
            // Crear un botón de opción por cada name encontrado

            while (resul.next()) {
                String projectNamelist = resul.getString(1);
                String projectYearlist = resul.getString(2);

                // Create a new panel for each project-year entry
                JPanel panelButtonList = new JPanel();

                JLabel label = new JLabel(projectNamelist);
                JRadioButton radioButton = new JRadioButton(projectYearlist);

                buttonGroup.add(radioButton);
                panelButtonList.add(label);
                panelButtonList.add(radioButton);

                // Add directly to view's panel
                view.getProyectListJpanel().add(panelButtonList);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Mostrar el diálogo para crear el mes
        int result = JOptionPane.showConfirmDialog(view, view.getCreateNewMonth(), "Create Month", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener el mes seleccionado
            int month = view.getjComboBox1().getSelectedIndex() + 1;

            // Buscar en cada sub-panel la etiqueta y el botón de opción seleccionado
            for (Component comp : view.getProyectListJpanel().getComponents()) {
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
                insertNewMonth("500", month, projectName);
            }
        }
        updateNavigationTree();
    }

    private void createExpense() {
        try {
            String sql = "INSERT INTO " + projectName + "_" + projectYear + "_" + proyectMonth + " (date, company, amount, expense, matrix, payment) VALUES (?, ?, ?, ?, ?, ?)";

            // Establecer los valores para cada columna (ajustar según los tipos de datos de las columnas)
            int Year = (int) view.getExpenseDate2().getValue();
            int Month = (int) view.getExpenseDate1().getValue();
            int Day = (int) view.getExpenseDate().getValue();
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
            if (Amount <0 ){
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
            
            //Agregar la nueva opción a la lista
            
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void expeseAddButton(int index) {

        int result = JOptionPane.showConfirmDialog(
                null,
                view.getjPanel12(),
                "Enter Expense",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        view.getAddExpensedata().setSelectedIndex(index);
       

        if (result == JOptionPane.OK_OPTION) {
            String resultado = view.getAddExpenseDataJText().getText();
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
        ResultSet resul;
        try {
            resul = model.executeQuery("SELECT * FROM projects WHERE name = '" + projectName + "'");

            // Crear el nodo raíz del árbol
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(projectName);

            // Recorrer todos los proyectos
            while (resul.next()) {
                String proyecto = resul.getString(2);
                DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode(proyecto);

                // seleccionar de cada resultado donde idProyectoMesN no sea null
                for (int i = 1; i <= 12; i++) {
                    String columnIdProyectoMes = "budget_" + i; // Nombre de la columna
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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void expandAllNodes(JTree tree, DefaultMutableTreeNode node) {
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
                this.proyectMonth = (String) selectedNode.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
                this.projectYear = (String) parent.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                parent = (DefaultMutableTreeNode) parent.getParent();
                this.projectName = (String) parent.getUserObject();

                System.out.println(this.proyectMonth);
                System.out.println(this.projectYear);
                System.out.println(this.projectName);
                updateMainTable();
            }
        }
    }

    private void updateMainTable() {
        tableModel = (DefaultTableModel) view.getMainTable().getModel();
        tableModel.setRowCount(0);
        ResultSet resul;
        try {
            String sql = "SELECT * FROM " + projectName + "_" + projectYear + "_" + proyectMonth;
            System.out.println("Consulta SQL: " + sql);
            resul = model.executeQuery(sql);

            while (resul.next()) {
                tableModel.addRow(new Object[]{
                    resul.getString("date"),
                    resul.getString("company"),
                    resul.getDouble("amount"),
                    resul.getString("expense"),
                    resul.getString("matrix"),
                    resul.getString("payment"),});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /*abrir name*/
    private void openProject() {

        // Simula la consulta a la base de datos para obtener los usuarios únicos
        List<String> usuarios = getUsuariosDeProyectos();

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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return usuarios;
    }

    /*Methods for the preview window*/
    private void openPreview() {
        // Create the main preview window
        JFrame previewFrame = new JFrame("Export Preview");
        previewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        previewFrame.setSize(600, 400);

        // Create the export panel within the preview window
        Export exportWindow = new Export();

        // Add the export panel to the preview frame's content pane
        previewFrame.getContentPane().add(exportWindow);

        // Center the window on the screen
        previewFrame.setLocationRelativeTo(null);

        // Make the window visible
        previewFrame.setVisible(true);
    }

    /*Exporting methods*/
    private void createExport(String filePath, String fileExtension) {
        // This is the method to handle the actual export logic
        System.out.println("Exporting to: " + filePath);
        System.out.println("File type: " + fileExtension);

        // Add your logic to export the file to Excel here
        String filename = filePath;
        File file = new File(filename);
        file.getParentFile().mkdirs(); // Crear directorios padres si no existen
        try (OutputStream fileOut = new FileOutputStream(file)) {
            Workbook wb = new HSSFWorkbook();
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void ExportProject() {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Set up the file filter for .xls and .xlsx files
        FileNameExtensionFilter filter;

        filter = new FileNameExtensionFilter("Excel 2003", "xls");
        fileChooser.setFileFilter(filter);
        filter = new FileNameExtensionFilter("Excel 2007", "xlsx");
        fileChooser.setFileFilter(filter);

        // Open the Save dialog
        int returnValue = fileChooser.showSaveDialog(null);

        // If the user selects a file and clicks save
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Get the file path
            String filePath = selectedFile.getAbsolutePath();

            // Get the selected file extension (xls or xlsx)
            String fileExtension = fileChooser.getFileFilter().getDescription().equals("Excel Files") ? "xls" : "xlsx";

            // If the user didn't include an extension, append .xls as default
            if (!filePath.toLowerCase().endsWith(".xls") && !filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += "." + fileExtension;
            }

            // Now you can pass the file path, name, and type to another method to handle the actual export
            createExport(filePath, fileExtension);
        }
    }

    /* Methods to close up the programm */
    private void cleanupResources() {
        // Perform any cleanup tasks, such as saving data or closing files
        System.out.println("Cleaning up resources...");
        // Add your resource cleanup code here

        try {
            model.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeProgram() {
        // Confirm if the user really wants to exit the program
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // If the user confirms, proceed with closing
        if (confirm == JOptionPane.YES_OPTION) {
            // Perform any necessary cleanup (e.g., saving state, closing resources)
            cleanupResources();

            // Exit the application
            System.exit(0);
        }
    }

    private void monthlybudget() {
        
    }
    
    /*
    public ConfigController() {

    }

    private void getSettings() {

        try {
            // Initialize ConfigManager with the path to your config file
            ConfigModel configManager = new ConfigModel("C:\\Users\\Usuario\\Documents\\GitHub\\one-spencer\\src\\main\\resources\\config.properties");

            // Retrieve properties
            String theme = configManager.getProperty("view.theme");
            String textSize = configManager.getProperty("view.textsize");
            String language = configManager.getProperty("view.language");

            // Print current settings
            System.out.println("Current theme: " + theme);
            System.out.println("Text size: " + textSize);
            System.out.println("Language: " + language);

            // Update a property
            configManager.setProperty("view.theme", "lightmode");

            // Confirm update
            System.out.println("Updated theme: " + configManager.getProperty("view.theme"));

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }*/
}

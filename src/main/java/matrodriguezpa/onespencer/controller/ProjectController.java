package matrodriguezpa.onespencer.controller;

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
import java.util.logging.Level;
import java.util.logging.Logger;

import matrodriguezpa.onespencer.model.DatabaseModel;
import matrodriguezpa.onespencer.view.ProjectView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ProjectController {

    private final DatabaseModel model;
    private final ProjectView view;

    private String month;
    private String nombreProyecto;
    private String noCuenta;

    private DefaultTableModel tableModel;
    private DefaultTreeModel treeModel;

    public ProjectController(DatabaseModel model, ProjectView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    public void start() {
        view.setVisible(true);
    }

    private void initController() {
        // crear un nuevo proyecto
        view.getNewProjectItem().addActionListener(e -> createProject());

        // abrir un proyecto
        view.getOpenProjectItem().addActionListener(e -> openProject());

        // agregar un nuevo workbook
        view.getAddWorkBook().addActionListener(e -> createProject());

        // agregar un nuevo mes al proyecto
        view.getAddWorkBook1().addActionListener(e -> createMonth(nombreProyecto));

        // manejar la selección de un nodo en la navegación izquierda
        view.getLeftNavigation().addTreeSelectionListener(e -> LeftNavigationValueChanged());

        // agregar un gasto
        view.getAddExpense().addActionListener(e -> createExpense());

        // agregar un gasto
        view.getExportItem().addActionListener(e -> ExportProject());

        // agregar un gasto
        view.getExitProgramItem().addActionListener(e -> closeProgram());
    }

    private void connectDatabase() {
        try {
            model.connect();
            JOptionPane.showMessageDialog(view, "Conexión exitosa.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void createProjectsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS proyectos ("
                + "usuario TEXT NOT NULL, nombre TEXT NOT NULL,"
                + "presupuestoMes1 REAL, idProyectoMes1 BOOLEAN,"
                + "presupuestoMes2 REAL, idProyectoMes2 BOOLEAN,"
                + "presupuestoMes3 REAL, idProyectoMes3 BOOLEAN,"
                + "presupuestoMes4 REAL, idProyectoMes4 BOOLEAN,"
                + "presupuestoMes5 REAL, idProyectoMes5 BOOLEAN,"
                + "presupuestoMes6 REAL, idProyectoMes6 BOOLEAN,"
                + "presupuestoMes7 REAL, idProyectoMes7 BOOLEAN,"
                + "presupuestoMes8 REAL, idProyectoMes8 BOOLEAN,"
                + "presupuestoMes9 REAL, idProyectoMes9 BOOLEAN,"
                + "presupuestoMes10 REAL, idProyectoMes10 BOOLEAN,"
                + "presupuestoMes11 REAL, idProyectoMes11 BOOLEAN,"
                + "presupuestoMes12 REAL, idProyectoMes12 BOOLEAN);";
        try {
            model.executeUpdate(sql);
            JOptionPane.showMessageDialog(view, "Tabla de proyectos creada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void createMonthTable(String nombreProyecto, String mes) {
        // Sanitize or validate table name inputs to avoid SQL injection
        String tableName = nombreProyecto + "_" + mes; // Use underscore as a separator

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "date VARCHAR(255), " // Using VARCHAR for strings
                + "company VARCHAR(255), " // Adjusting types based on SQL standards
                + "amount REAL, " // 'REAL' is fine for floating-point numbers
                + "expense VARCHAR(255), "
                + "matrix VARCHAR(255), "
                + "payment VARCHAR(255));";

        try {
            model.executeUpdate(sql);  // Assumes model handles statement execution
            JOptionPane.showMessageDialog(view, "Tabla del proyecto '" + tableName + "' creada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creando la tabla: " + e.getMessage());
        }
    }

    private void insertNewProject(String usuario, String nombreProyecto) {
        String sql = "INSERT INTO proyectos (usuario, nombre) VALUES (?,?)"; // SQL para insertar solo el usuario y el nombre del proyecto
        try {
            model.executeUpdate2(sql, usuario, nombreProyecto);
            JOptionPane.showMessageDialog(view, "Proyecto creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error al crear el proyecto: " + e.getMessage());
        }
    }

    private void insertNewMonth(String presupuesto, int mesNumber, String nombreProyecto) {
        // Verificar que mesNumber esté dentro del rango válido (1 a 12)
        if (mesNumber < 1 || mesNumber > 12) {
            JOptionPane.showMessageDialog(view, "Número de mes no válido.");
            return;
        }

        // Construir dinámicamente los nombres de las columnas
        String presupuestoColumn = "presupuestoMes" + mesNumber;

        // Crear la consulta SQL que actualiza las columnas específicas
        String sql = "UPDATE proyectos SET " + presupuestoColumn + " = ?, idProyectoMes" + mesNumber + " = ? WHERE nombre = '" + nombreProyecto + "' ";
        try {
            model.executeUpdate3(sql, presupuesto);
            JOptionPane.showMessageDialog(view, "Mes " + mesNumber + " añadido/actualizado para el proyecto " + nombreProyecto + ".");

        } catch (NumberFormatException | SQLException e) {
            System.out.println("HOLA DIOS SOY YO DE NUEVO");
            JOptionPane.showMessageDialog(view, "Error agregando el mes a el proyecto: " + e.getMessage());
        }
    }

    private void createProject() {
        int result = JOptionPane.showConfirmDialog(view, view.getjPanel2(), "Nuevo Proyecto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (!"---".equals(view.getjLabel3().getText())) { //si en la navegación esta abierta tomar ese numero de cuenta
            view.getjTextField2().setText(view.getjLabel3().getText());
        }

        if (result == JOptionPane.OK_OPTION) {
            this.nombreProyecto = view.getjTextField1().getText();
            this.noCuenta = view.getjTextField2().getText();

            if (nombreProyecto.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Debe ingresar el nombre del proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            connectDatabase();
            createProjectsTable();

            insertNewProject(noCuenta, nombreProyecto); //Se agrega el proyecto en la tabla de proyectos
            loadProject(); //Se carga el proyecto en la vista

            result = JOptionPane.showConfirmDialog(view, "¿Crear un nuevo mes?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                createMonth(nombreProyecto);
                loadProject();
            }

        }
    }

    private void createMonth(String nombreProyecto) {
        // Buscar los proyectos de usuario
        ResultSet resul = null;
        try {
            resul = model.executeQuery("SELECT * FROM proyectos WHERE usuario = '" + noCuenta + "'");
        } catch (SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Verificar si el jPanel5 ya tiene componentes
        if (view.getjPanel6().getComponentCount() == 0) {
            try {
                // Crear un botón de opción por cada proyecto encontrado
                while (resul.next()) {
                    String proyecto = resul.getString(2);
                    JRadioButton radioButton = new JRadioButton(proyecto);
                    view.getjPanel6().add(radioButton);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Agrupar los radio buttons para que sea un grupo de selección
            ButtonGroup buttonGroup = new ButtonGroup();
            for (Component comp : view.getjPanel6().getComponents()) {
                if (comp instanceof JRadioButton) {
                    buttonGroup.add((JRadioButton) comp);
                }
            }
        }

        // Mostrar el diálogo para crear el mes
        int result = JOptionPane.showConfirmDialog(view, view.getjPanel4(), "Crear mes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        int month = 0;
        if (result == JOptionPane.OK_OPTION) {
            // Obtener el mes seleccionado
            month = (view.getjComboBox1().getSelectedIndex() + 1);

            // Obtener el nombre del proyecto seleccionado
            for (Component comp : view.getjPanel6().getComponents()) {
                if (comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
                    nombreProyecto = ((JRadioButton) comp).getText();
                    break;
                }
            }

            // Crear la tabla para el mes
            createMonthTable(nombreProyecto, String.valueOf(month));

            // Insertar el nuevo mes
            insertNewMonth("500", month, nombreProyecto);
            loadProject();
        }
    }

    private void loadProject() {
        ResultSet resul;
        try {
            resul = model.executeQuery("SELECT * FROM proyectos WHERE usuario = '" + noCuenta + "'");

            // Crear el nodo raíz del árbol
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Cuenta: " + noCuenta);

            // Recorrer todos los proyectos
            while (resul.next()) {
                String proyecto = resul.getString(2);
                DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode(proyecto);

                // seleccionar de cada resultado donde idProyectoMesN no sea null
                for (int i = 1; i <= 12; i++) {
                    String columnIdProyectoMes = "idProyectoMes" + i; // Nombre de la columna
                    if (resul.getString(columnIdProyectoMes) != null) {
                        String monthName = String.valueOf(i);
                        DefaultMutableTreeNode monthNode = new DefaultMutableTreeNode(monthName);
                        projectNode.add(monthNode);
                    }
                }

                // Agregar el proyecto al nodo raíz
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

    // Método auxiliar para expandir todos los nodos
    public void expandAllNodes(JTree tree, DefaultMutableTreeNode node) {
        int row = tree.getRowForPath(new TreePath(node.getPath()));
        if (row != -1) {
            tree.expandRow(row);
            for (int i = 0; i < node.getChildCount(); i++) {
                expandAllNodes(tree, (DefaultMutableTreeNode) node.getChildAt(i));
            }
        }
    }

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
        int result = JOptionPane.showConfirmDialog(null, panel, "Abrir proyectos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si se presiona OK
        if (result == JOptionPane.OK_OPTION) {
            // Buscar el radio button seleccionado
            Enumeration<AbstractButton> elementos = grupoUsuarios.getElements();
            while (elementos.hasMoreElements()) {
                AbstractButton radioButton = elementos.nextElement();
                if (radioButton.isSelected()) {
                    this.noCuenta = radioButton.getText(); // Asigna el usuario seleccionado a noCuenta
                    loadProject();
                    break;
                }
            }
            view.getjLabel3().setText(this.noCuenta);

        }
    }

// Método que simula la consulta a la base de datos para obtener los usuarios únicos
    private List<String> getUsuariosDeProyectos() {
        List<String> usuarios = new ArrayList<>();
        try {
            // Consulta SQL para obtener usuarios únicos de la tabla proyectos
            String sql = "SELECT DISTINCT usuario FROM proyectos";
            // Añadir cada usuario a la lista
            try (ResultSet rs = model.executeQuery(sql)) {
                // Añadir cada usuario a la lista
                while (rs.next()) {
                    usuarios.add(rs.getString("usuario"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return usuarios;
    }

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
                this.month = (String) selectedNode.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
                this.nombreProyecto = (String) parent.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                System.out.println(this.month);
                System.out.println(this.nombreProyecto);
                System.out.println("CArgando tabla: " + nombreProyecto + "_" + month);
                loadMonth();
            }
        }
    }

    private void createExpense() {
        try {
            String sql = "INSERT INTO " + nombreProyecto + "_" + month + " (date, company, amount, expense, matrix, payment) VALUES (?, ?, ?, ?, ?, ?)";

            // Establecer los valores para cada columna (ajustar según los tipos de datos de las columnas)
            String day = String.valueOf(view.getExpenseDate().getDate().getDay());
            String month = String.valueOf(view.getExpenseDate().getDate().getMonth());
            String year = String.valueOf(view.getExpenseDate().getDate().getYear());

            String date = day + "-" + month + "-" + year;
            String razonSocial = view.getCompanyName().getText(); // RazonSocial
            Double Monto = Double.valueOf(view.getAmount().getText()); // Monto
            int index = view.getExpense().getSelectedIndex();
            String GGasto = view.getExpense().getItemAt(index); // GGasto
            index = view.getMatrix().getSelectedIndex(); // GGasto
            String Matriz = view.getMatrix().getItemAt(index); // GGasto
            index = view.getPaymentMethod().getSelectedIndex();
            String FPago = view.getPaymentMethod().getItemAt(index); // GGasto

            // Ejecutar la consulta
            model.executeUpdate4(sql, date, razonSocial, Monto, GGasto, Matriz, FPago);
            loadMonth();
            JOptionPane.showMessageDialog(null, "Inserción exitosa.");
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void loadMonth() {
        tableModel = (DefaultTableModel) view.getMainTable().getModel();
        tableModel.setRowCount(0);
        ResultSet resul;
        try {
            String sql = "SELECT * FROM " + nombreProyecto + "_" + month;
            System.out.println("Consulta SQL: " + sql);
            resul = model.executeQuery(sql);
            while (resul.next()) {
                tableModel.addRow(new Object[]{
                    resul.getString("date"),
                    resul.getString("company"),
                    resul.getDouble("amount"),
                    resul.getString("expense"),
                    resul.getString("matrix"),
                    resul.getString("payment")
                });

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    // Example cleanup method
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

    // This is the method to handle the actual export logic
    private void createExport(String filePath, String fileExtension) {
        System.out.println("Exporting to: " + filePath);
        System.out.println("File type: " + fileExtension);

        // Add your logic to export the file to Excel here
        String filename = filePath + "exported_file." + fileExtension;
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
}

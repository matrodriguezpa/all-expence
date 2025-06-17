package matrodriguezpa.allexpence.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import matrodriguezpa.allexpence.dao.ProjectDAO;
import matrodriguezpa.allexpence.model.MainModel;
import matrodriguezpa.allexpence.model.Month;
import matrodriguezpa.allexpence.model.Project;
import matrodriguezpa.allexpence.model.model;
import matrodriguezpa.allexpence.view.View;

public class MainController {

    private static View view;
    private static MainModel model2;
    private static model model;

    public static String projectName = null;
    public static String projectYear;
    public static String proyectMonth;

    private static DefaultTreeModel treeModel;
    private static DefaultTableModel tableModel;

    private static ProjectDAO projectDao = new ProjectDAO();

    public MainController(View view, MainModel model) {

        this.view = view;
        this.model2 = model;

        view.getAboutItem().addActionListener(e -> openAboutWindow());
        view.getJavadocItem().addActionListener(e -> openJavaDoc());
        view.getUserDocItem().addActionListener(e -> openDocumentation());
        view.getExitProgramItem().addActionListener(e -> closeProgram());

        updateViews(false);

        new ProjectController(view);
        new ExpenseController(view);
    }

    public void start() {
        view.setVisible(true);
    }

    protected static void updateViews(Boolean value) {
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

    protected static void updateNavigationTree() {
        if (projectName == null) {
            // Clear the tree
            DefaultMutableTreeNode emptyRoot = new DefaultMutableTreeNode("No Project Open");
            treeModel = new DefaultTreeModel(emptyRoot);
            view.getLeftNavigation().setModel(treeModel);
            return;
        }
        try {
            Project project = projectDao.findByName(projectName);

            if (project == null) {
                // Project not found
                DefaultMutableTreeNode emptyRoot = new DefaultMutableTreeNode("Project Not Found");
                treeModel = new DefaultTreeModel(emptyRoot);
                view.getLeftNavigation().setModel(treeModel);
                return;
            }

            // Create root node with project name
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(project.getName());

            // Add months if they exist
            List<Month> months = project.getMonth();
            if (months != null && !months.isEmpty()) {
                for (Month m : months) {
                    int monthNum = m.getMONTH();
                    String monthName = String.valueOf(monthNum);
                    DefaultMutableTreeNode monthNode = new DefaultMutableTreeNode(monthName);
                    root.add(monthNode);
                }
            } else {
                // Add "No months" node if no months exist
                root.add(new DefaultMutableTreeNode("No months"));
            }

            // Create tree model
            treeModel = new DefaultTreeModel(root);
            view.getLeftNavigation().setModel(treeModel);

            // Expand all nodes
            expandAllNodes(view.getLeftNavigation(), root);

            LeftNavigationValueChanged(root);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace(); // Add this for debugging
        }
    }

    private static void expandAllNodes(JTree tree, DefaultMutableTreeNode node) {
        // Método auxiliar para expandir todos los nodos
        int row = tree.getRowForPath(new TreePath(node.getPath()));
        if (row != -1) {
            tree.expandRow(row);
            for (int i = 0; i < node.getChildCount(); i++) {
                expandAllNodes(tree, (DefaultMutableTreeNode) node.getChildAt(i));
            }
        }
    }

    private static void LeftNavigationValueChanged(DefaultMutableTreeNode root) {
        // Buscar la primera hoja del árbol
        DefaultMutableTreeNode currentNode = root;
        while (!currentNode.isLeaf() && currentNode.getChildCount() > 0) {
            currentNode = (DefaultMutableTreeNode) currentNode.getFirstChild();
        }

        if (currentNode != root) {  // Si encontramos una hoja (que no sea el root)
            view.getLeftNavigation().setSelectionPath(new TreePath(currentNode.getPath()));
            TreePath selectedPath = view.getLeftNavigation().getSelectionPath();

            // Verificar si hay un nodo seleccionado
            if (selectedPath != null) {
                // Obtener el nodo seleccionado
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();

                // Verificar si el nodo es una hoja (nodo final)
                if (selectedNode.isLeaf()) {
                    // Asignar el valor del mes correspondiente al nodo seleccionado
                    proyectMonth = (String) selectedNode.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                    DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
                    projectYear = (String) parent.getUserObject(); // Asegúrate de que el objeto sea del tipo adecuado
                    parent = (DefaultMutableTreeNode) parent.getParent();
                    projectName = (String) parent.getUserObject();

                    System.out.println(proyectMonth);
                    System.out.println(projectYear);
                    System.out.println(projectName);
                    updateMainTable();
                }
            }
        }
    }

    protected static void updateMainTable() {
        tableModel = (DefaultTableModel) view.getMainTable().getModel();
        tableModel.setRowCount(0);

        if (projectName == null) {
            return;
        }

        try {
            String sql = "SELECT * FROM " + projectName + "_" + projectYear + "_" + proyectMonth;
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
            view.getExpenseDateMonth().setValue(Integer.valueOf(proyectMonth));
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //ventanas de sobre        
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

    private void closeProgram() {
        // Confirm if the user really wants to exit the program
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            //cleanupResources();
            System.exit(0);
        }
    }

    /* Methods to close up the programm 
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
     */

 /*
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
     */
}

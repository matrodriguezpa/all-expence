package matrodriguezpa.onespencer.controller;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import matrodriguezpa.onespencer.model.DatabaseModel;
import matrodriguezpa.onespencer.view.ProjectView;

public class ProjectController {

    private final DatabaseModel model;
    private final ProjectView view;

    public ProjectController(DatabaseModel model, ProjectView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    public void start() {
        view.setVisible(true);
    }

    private void initController() {
        view.getNewProjectItem().addActionListener((ActionEvent e) -> {
            addProject();
        });
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

    private void addProject() {
        int result = JOptionPane.showConfirmDialog(view, view.getjPanel2(), "Nuevo Proyecto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String projectName = view.getjTextField1().getText();
            //String accountName = view.getjTextField2().getText();

            if (projectName.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Debe ingresar el nombre del proyecto y de la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Conectar a la base de datos y crear la tabla si se ingresaron ambos valores
            connectDatabase();
            createProjectsTable();

            // Aquí podrías guardar el nombre del proyecto y de la cuenta en la base de datos
            // o utilizarlos como sea necesario en tu aplicación.
            JOptionPane.showMessageDialog(view, "Proyecto y cuenta creados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

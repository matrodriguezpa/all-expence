package matrodriguezpa.allexpence.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import matrodriguezpa.allexpence.dao.ProjectDAO;
import matrodriguezpa.allexpence.dao.UserDAO;
import matrodriguezpa.allexpence.model.Month;
import matrodriguezpa.allexpence.model.Project;
import matrodriguezpa.allexpence.model.User;
import matrodriguezpa.allexpence.view.View;

public class ProjectController {

    View view;
    Project project;

    ProjectDAO projectDao = new ProjectDAO();
    UserDAO userDao = new UserDAO();

    public ProjectController(View view) {
        this.view = view;

        view.getNewProjectItem().addActionListener(e -> createProject());
        view.getOpenProjectItem().addActionListener(e -> openProject());
        view.getCloseProjectItem().addActionListener(e -> closeProject());

        //table-year
        view.getAddProject().addActionListener(e -> createYear());

        view.getNewProjectName().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    view.getWarning().setText("El proyecto será guardado como texto-con-espacios");
                }
            }
        });
    }

    //CONTROLLER
    private void createProject() {
        while (true) {
            int result = JOptionPane.showConfirmDialog(
                    view,
                    view.getNewProject(),
                    "New Project",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (result != JOptionPane.OK_OPTION) {
                return;
            }

            String rawName = view.getNewProjectName().getText().trim();
            String yearText = view.getNewProjectYear().getText().trim();

            Project.isValidName(rawName);
            Project.isEmpty(yearText);
            Project.validateYear(yearText);

            MainController.projectName = rawName.replace(' ', '_');
            MainController.projectYear = String.valueOf(Project.validateYear(yearText));
            System.out.println(MainController.projectName);
            break;
        }

        // Load existing user instead of creating a new one
        User existingUser = userDao.findById(1L);  // Use your UserDAO

        if (existingUser == null) {
            // Create new user if doesn't exist
            existingUser = User.builder()
                    .name("Mateo")
                    .build();
            userDao.save(existingUser);
        }

        Project newProject = Project.builder()
                .name(MainController.projectName)
                .year(Integer.parseInt(MainController.projectYear))
                .user(existingUser)
                .month(new ArrayList<>())
                .build();

        projectDao.save(newProject);

        MainController.updateNavigationTree();
        /*
        if (JOptionPane.showConfirmDialog(view, "Create new month?", "New month",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            ExpenseController.createMonth();
            updateNavigationTree();
        }
         */
        MainController.updateViews(true);
        MainController.updateNavigationTree();
    }

    private void openProject() {

        List<Long> usersId = userDao.findDistictUsers();
        List<User> users = new ArrayList<>();

        for (Long user : usersId) {
            users.add(userDao.findById(user));
        }

        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tabla usuarios no existente o no hay usuarios en la tabla.");
            return;
        }

        // Crear un ButtonGroup para que los radio buttons sean mutuamente excluyentes
        ButtonGroup grupoUsuarios = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usamos un layout vertical para los radio buttons

        // Crear un radio button por cada usuario y añadirlo al panel
        for (User usuario : users) {
            JRadioButton radioButton = new JRadioButton(usuario.getName());
            grupoUsuarios.add(radioButton); // Añadimos el radio button al grupo
            panel.add(radioButton); // Añadimos el radio button al panel
        }

        // Mostrar el diálogo con el panel de radio buttons
        int result = JOptionPane
                .showConfirmDialog(null, panel, "Open project", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Buscar el radio button seleccionado
            Enumeration<AbstractButton> elementos = grupoUsuarios.getElements();
            while (elementos.hasMoreElements()) {
                AbstractButton radioButton = elementos.nextElement();
                if (radioButton.isSelected()) {
                    MainController.projectName = radioButton.getText();// Asigna el usuario seleccionado a projectYear
                    MainController.updateNavigationTree();
                    break;
                }
            }
            //mostrar los botones de agregar años, mes y gastos 
            MainController.updateViews(true);
        }
    }

    private void closeProject() {
        MainController.projectName = null;
        MainController.projectYear = null;
        MainController.proyectMonth = null;

        MainController.updateMainTable();
        MainController.updateNavigationTree();

        MainController.updateViews(false);
    }

    private void createYear() {
        while (true) {
            view.getAddNewYearProjectName().setText(MainController.projectName);

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
                Project.validateYear(yearText);
                MainController.projectYear = yearText;
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view,
                        "Please enter a valid year (0-9999)",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            //insertNewProject(projectName, projectYear);
            Project newProject = project.builder()
                    .name(MainController.projectName)
                    .year(Integer.parseInt(MainController.projectYear))
                    .user(null)
                    .year(Integer.parseInt(MainController.projectYear))
                    .build();

            projectDao.save(newProject);

            MainController.updateNavigationTree();
            /*
            if (JOptionPane.showConfirmDialog(view, "Create new month?", "New month",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                createMonth();
            }*/
            MainController.updateNavigationTree();
            break;
        }
    }

    //VALIDACION
    /*
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

    private void showError(String message) {
        JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
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

    // Later in the class
    private void showSpaceWarning() {
        view.getWarning().setText("El proyecto será guardado como texto-con-espacios");
    }
     */
 /*
    //MODELO
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

    private void insertNewProject(String name, String year) {
        String sql = "INSERT INTO projects (name, year) VALUES (?,?)"; // SQL para insertar solo el usuario y el nombre del name
        try {
            model.executeUpdateProjectNameAndYear(sql, name, year);
            JOptionPane.showMessageDialog(view, "Project created succesfully.", "Succes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creating the project: " + e.getMessage());
        }
    }//insert a new model on the model list table

    //CONTROLLER
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
        updateViews(true);
        updateNavigationTree();
    }
     */
 /*
    private void insertNewProject(String name, String year) {
        String sql = "INSERT INTO projects (name, year) VALUES (?,?)"; // SQL para insertar solo el usuario y el nombre del name
        try {
            model.executeUpdateProjectNameAndYear(sql, name, year);
            JOptionPane.showMessageDialog(view, "Project created succesfully.", "Succes", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error creating the project: " + e.getMessage());
        }
    }//insert a new model on the model list table
     */
}

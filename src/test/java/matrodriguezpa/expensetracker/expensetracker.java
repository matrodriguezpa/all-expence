package matrodriguezpa.expensetracker;

public class expensetracker {

    public static void main(String[] args) {
        Model modelo = new Model();
        View vista = new View(modelo);
        Controller controlador = new Controller(vista, modelo);
    }
}

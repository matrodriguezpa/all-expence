package matrodriguezpa.allexpence.dao;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.url", constructDatabaseUrl());
            sessionFactory = cfg.buildSessionFactory();
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Builds a JDBC URL pointing to Documents/OneSpencer/Database.db Ensures
     * the directories and file exist.
     */
    private static String constructDatabaseUrl() {
        // get the home folder (e.g. C:\Users\Usuario)
        String userHome = System.getProperty("user.home");

        // build path: ~/Documents/OneSpencer/Database.db
        Path dbPath = Paths.get(userHome, "Documents", "AllExpense", "allexpense.db");

        try {
            // create parent folders if needed
            if (!dbPath.getParent().toFile().exists()) {
                dbPath.getParent().toFile().mkdirs();
            }
            // create the file if it doesn’t exist
            if (!dbPath.toFile().exists()) {
                dbPath.toFile().createNewFile();
            }
        } catch (IOException e) {
            // you might want to re-throw as a RuntimeException, or at least log properly
            System.err.println("Unable to create SQLite file: " + e.getMessage());
        }

        // return the URL Hibernate needs
        // Note: use forward-slashes or escaped backslashes
        return "jdbc:sqlite:" + dbPath.toString().replace("\\", "/") + "?busy_timeout=5000";
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

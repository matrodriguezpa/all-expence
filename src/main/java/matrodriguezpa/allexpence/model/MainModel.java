package matrodriguezpa.allexpence.model;

import java.util.List;
import matrodriguezpa.allexpence.dao.HibernateUtil;
import org.hibernate.Session;

public class MainModel {

    public static String projectName;
    public static String projectYear;
    public static String proyectMonth;

    public Project findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Project.class, id);
        }
    }

    public Project findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("from Project p where p.name = :name", Project.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public List<Project> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("from Project", Project.class)
                    .list();
        }
    }
}

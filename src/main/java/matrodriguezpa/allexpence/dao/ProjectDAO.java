package matrodriguezpa.allexpence.dao;

import matrodriguezpa.allexpence.model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.HibernateException;

public class ProjectDAO {

    public void save(Project project) {
        executeTransaction(session -> {
            if (project.getId() == null) {
                project.setId(IdGenerator.getNextId(session, Project.class));
            }
            session.save(project);
        });
    }

    public void update(Project project) {
        executeTransaction(session -> session.update(project));
    }

    public void saveOrUpdate(Project project) {
        executeTransaction(session -> session.saveOrUpdate(project));
    }

    public List<Project> findByUserId(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Project p WHERE p.user.id = :userId",
                    Project.class
            )
                    .setParameter("userId", userId)
                    .list();
        }
    }

    /**
     * Generic column update for a project by id. Uses HQL to avoid embedding
     * raw SQL.
     *
     * @param projectId
     * @param column
     * @param value
     */
    public void updateColumn(Long projectId, String column, Object value) {
        executeTransaction(session -> {
            String hql = String.format("update Project p set p.%s = :val where p.id = :id", column);
            session.createQuery(hql)
                    .setParameter("val", value)
                    .setParameter("id", projectId)
                    .executeUpdate();
        });
    }

    private void executeTransaction(java.util.function.Consumer<Session> command) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            command.accept(session);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Project findById(Long id) {
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

    public void delete(Project project) {
        executeTransaction(session -> session.delete(project));
    }
}

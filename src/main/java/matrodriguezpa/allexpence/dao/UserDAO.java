package matrodriguezpa.allexpence.dao;

import matrodriguezpa.allexpence.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.HibernateException;

public class UserDAO {

    public void save(User user) {
        executeTransaction(session -> {
            if (user.getId() == null) {
                user.setId(IdGenerator.getNextId(session, User.class));
            }
            session.save(user);
        });
    }

    public void update(User user) {
        executeTransaction(session -> session.update(user));
    }

    public void saveOrUpdate(User user) {
        executeTransaction(session -> session.saveOrUpdate(user));
    }

    public void updateColumn(int MonthId, String column, Object value) {
        executeTransaction(session -> {
            String hql = String.format("update Month p set p.%s = :val where p.id = :id", column);
            session.createQuery(hql)
                    .setParameter("val", value)
                    .setParameter("id", MonthId)
                    .executeUpdate();
        });
    }

    public List<Long> findDistictUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT DISTINCT p.user.id FROM Project p",
                    Long.class
            ).getResultList();
        }
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

    public User findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    public void delete(User user) {
        executeTransaction(session -> session.delete(user));
    }
}

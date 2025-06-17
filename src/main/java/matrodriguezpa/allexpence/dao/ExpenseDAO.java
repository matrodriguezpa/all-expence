package matrodriguezpa.allexpence.dao;

import matrodriguezpa.allexpence.model.Expense;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.HibernateException;

public class ExpenseDAO {

    public void save(Expense expense) {
        executeTransaction(session -> {
            if (expense.getId() == 0) { // For primitive int
                Long maxId = session.createQuery("select max(id) from Expense", Long.class)
                        .uniqueResult();
                expense.setId(maxId == null ? 1 : maxId + 1);
            }
            session.save(expense);
        });
    }
    

    public void update(Expense expense) {
        executeTransaction(session -> session.update(expense));
    }

    public void saveOrUpdate(Expense expense) {
        executeTransaction(session -> session.saveOrUpdate(expense));
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

    public Expense findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Expense.class, id);
        }
    }

    public List<Expense> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Expense", Expense.class).list();
        }
    }

    public List<Expense> findByProjectId(Long projectId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Expense e where e.project.id = :pid", Expense.class)
                    .setParameter("pid", projectId)
                    .list();
        }
    }

    public void delete(Expense expense) {
        executeTransaction(session -> session.delete(expense));
    }
}

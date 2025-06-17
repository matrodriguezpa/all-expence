/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrodriguezpa.allexpence.dao;

import java.util.List;
import matrodriguezpa.allexpence.model.Month;
import matrodriguezpa.allexpence.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Usuario
 */
public class MonthDAO {

    public void save(Month month) {
        executeTransaction(session -> {
            if (month.getId() == null) {
                month.setId(IdGenerator.getNextId(session, Month.class));
            }
            session.save(month);
        });
    }

    public void update(Month month) {
        executeTransaction(session -> session.update(month));
    }

    public void saveOrUpdate(Month month) {
        executeTransaction(session -> session.saveOrUpdate(month));
    }

    /**
     * Generic column update for a project by id. Uses HQL to avoid embedding
     * raw SQL.
     *
     * @param MonthId
     * @param column
     * @param value
     */
    public void updateColumn(Long MonthId, String column, Object value) {
        executeTransaction(session -> {
            String hql = String.format("update Month p set p.%s = :val where p.id = :id", column);
            session.createQuery(hql)
                    .setParameter("val", value)
                    .setParameter("id", MonthId)
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

    public Month findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Month.class, id);
        }
    }

    public List<Month> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("from Month", Month.class)
                    .list();
        }
    }

    public void delete(Month month) {
        executeTransaction(session -> session.delete(month));
    }
}

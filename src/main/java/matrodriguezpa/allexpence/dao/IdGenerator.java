package matrodriguezpa.allexpence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class IdGenerator {
    public static Long getNextId(Session session, Class<?> entityClass) {
        String className = entityClass.getSimpleName();
        String queryString = String.format("select max(id) from %s", className);
        Query<Long> query = session.createQuery(queryString, Long.class);
        Long maxId = query.uniqueResult();
        return (maxId == null) ? 1L : maxId + 1;
    }
}
package mx.itson.classroom.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.classroom.entities.Work;
import mx.itson.classroom.utils.HibernateUtils;
import org.hibernate.Session;

public class WorkDAO {

    public static List<Work> obtenerTodos() {
        List<Work> works = new ArrayList<>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            CriteriaQuery<Work> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Work.class);
            criteriaQuery.from(Work.class);
            works = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return works;
    }

    public static boolean guardar(Work w) {
        boolean resultado = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(w);
            session.getTransaction().commit();
            resultado = w.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
}

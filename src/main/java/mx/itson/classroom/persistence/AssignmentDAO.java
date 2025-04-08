package mx.itson.classroom.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.classroom.entities.Assignment;
import mx.itson.classroom.utils.HibernateUtils;
import org.hibernate.Session;

public class AssignmentDAO {

    public static List<Assignment> obtenerTodos() {
        List<Assignment> assignments = new ArrayList<>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            CriteriaQuery<Assignment> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Assignment.class);
            criteriaQuery.from(Assignment.class);

            assignments = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return assignments;
    }

    public static boolean guardar(Assignment a) {
        boolean resultado = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(a);
            session.getTransaction().commit();

            resultado = a.getId() != null;
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
}


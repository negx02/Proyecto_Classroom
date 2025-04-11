package mx.itson.classroom.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.classroom.entities.Student;
import mx.itson.classroom.utils.HibernateUtils;
import org.hibernate.Session;

public class StudentDAO {

    public static List<Student> obtenerTodos() {
        List<Student> students = new ArrayList<>();
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            CriteriaQuery<Student> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Student.class);
            criteriaQuery.from(Student.class);
            students = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return students;
    }

    public static boolean guardar(Student s) {
        boolean resultado = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            resultado = s.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
}


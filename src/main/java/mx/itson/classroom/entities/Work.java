package mx.itson.classroom.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Work {

    /**
     * @return the idAssigment
     */
    public int getIdAssignment() {
        return idAssignment;
    }

    /**
     * @param idAssignment the idAssignment to set
     */
    public void setIdAssignment(int idAssignment) {
        this.idAssignment = idAssignment;
    }

    /**
     * @return the idStudent
     */
    public int getIdStudent() {
        return idStudent;
    }

    /**
     * @param idStudent the idStudent to set
     */
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String fileName;
    private int idAssignment;
    private int idStudent;

    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

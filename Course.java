package M6_Activity3;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")

public class Course {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@Column(name="course_name", nullable=false,length=50,columnDefinition="VARCHAR(50")
	private String courseName;
	
	@Column(name="grade", columnDefinition="DECIMAL(5,2)")
	private double grade;
	
	public Course() {
		
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void setCourseName(String name) {
		this.courseName = name;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
}

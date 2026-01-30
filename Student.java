package M6_Activity3;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="students")

public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "age", columnDefinition = "INT")
	private int age;
	
	@Column(name = "email", unique = true, length = 100, columnDefinition = "VARCHAR(100)")
	private String email;
	
	
	@OneToMany(mappedBy="student")
	private List<Course> courses;
	
	public Student() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
	}
}

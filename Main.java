package M6_Activity3;

import M6_Activity2.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
		
		try {
			persistOneToMany(em);
		}finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}
	
	static void persistOneToMany(EntityManager em) {
		em.getTransaction().begin();
		
		Student student1 = em.find(Student.class, 47);
		
		Course newCourse = new Course();
		
		newCourse.setCourseName("PE");
		newCourse.setGrade(70.5);
		newCourse.setStudent(student1);
		
		student1.addCourse(newCourse);
		
		em.persist(newCourse);
		
		em.getTransaction().commit();
	}

}

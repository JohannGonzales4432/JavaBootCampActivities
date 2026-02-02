package M6_Activity4;

import jakarta.persistence.EntityManager;
import M6_Activity3.Student;
import M6_Activity2.EntityManagerUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
		
		try {
			m6Activity4Solution(em);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}
	
	static void m6Activity4Solution(EntityManager em) {
		em.getTransaction().begin();
		
		// 1. Create Student object, assign values
		
		Student newStudent = new Student();
		
		newStudent.setName("Robert");
		newStudent.setAge(25);
		newStudent.setEmail("roberts@mails.com");
		
		// 2. attach transient student object to the persistence context 
		
		em.persist(newStudent);
		
		// 3. call flush()
		
		em.flush();
		
		// 4. detach the managed newStudent from the persistence context
		
		em.detach(newStudent);
		
		// 5. print "is newStudent inside the persistence context:"
		
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
		
		// 6. reattach the detached newStudent\
		
		newStudent = em.merge(newStudent);
		
		// 7. update newStudent
		
		newStudent.setEmail("robertsnew@mail.com");
		
		// 8. call flush()
		
		em.flush();
		
		// 9. print "is newStudent inside the persistence context:"
		
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
	
		// 10. mark managed newStudent for deletion
		
		em.remove(newStudent);
		
		// 11. call flush()
		
		em.flush();
		
		// 12. print "is newStudent inside the persistence context:"
		
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
	
		em.getTransaction().commit();
	}
	
}

package M6_Activity2;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
			
		try {
			runM6Activity(em);
		}finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}
	
	static void runM6Activity(EntityManager em) {
		try {
			em.getTransaction().begin();
			
			Student newStudent = new Student();
			newStudent.setName("Juan Dela Cruz");
			newStudent.setAge(50);
			newStudent.setEmail("juandelacruz@gmail2.com");
			
			
			em.persist(newStudent);
			em.getTransaction().commit();
		}finally {
			
		}
	}

}

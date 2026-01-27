package com.bpi.M6;

import jakarta.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        testConnection();
    }
    
    static void testConnection() {
    	
    	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
    	try {
    		if (em.isOpen()) {
    			System.out.println("Entity manager open, ready to create transaction");
    	
    		}
    	}finally {
    		EntityManagerUtil.getInstance().closeEntityManager(em);
    		EntityManagerUtil.getInstance().shutdownFactory();
    	}
    	
    }
}

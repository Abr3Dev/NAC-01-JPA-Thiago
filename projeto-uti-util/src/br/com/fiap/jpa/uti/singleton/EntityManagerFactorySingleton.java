package br.com.fiap.jpa.uti.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private static EntityManagerFactory emf;
	
	private  EntityManagerFactorySingleton () {}
	
	public static EntityManagerFactory getInstance() {
		
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("oracle");
		}
		return emf;
	}
}

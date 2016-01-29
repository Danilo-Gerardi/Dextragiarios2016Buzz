package br.com.dextra.estagio2015.atv07;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.dextra.estagio2015.atv04.JPAUtils_Atv4;

public class JPAUtils_Atv7 {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dextragiarios");

	private static EntityManager em = JPAUtils_Atv4.getEM();

	public static void open() {
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEM() {
		return emf.createEntityManager();
	}

	public static Object merge(Object obj) {
		if (em != null) {
			em.getTransaction().begin();
			obj = em.merge(obj);
			em.getTransaction().commit();
			return obj;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Query createQuery(String query, Class c){
		return (Query) em.createQuery(query, c);
	}

	public static <T> T find(Class<T> c, Object obj) {
		if (em != null) {
			return (T) em.find(c, obj);
		}
		return null;
	}

	public static void close() {
		if (em != null) {
			em.close();
		}
	}
}

package br.com.dextra.estagio2015.atv04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dextra.estagio2015.comum.Cliente;

/**
 * Criei essa classe pois a JPAUtils original fechava o EntityManager a cada
 * merge, e isso fazia com que não fosse posível fazer 2 merges seguidos ;(
 */

public class JPAUtils_Atv4 {
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

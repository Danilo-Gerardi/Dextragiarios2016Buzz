package br.com.dextra.estagio2015.atv04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.JPAUtils;

/**
 * Criei essa classe pois a JPAUtils original fechava o EntityManager a cada
 * merge, e isso fazia com que não fosse posível fazer 2 merges seguidos ;(
 */

public class JPAUtils_Atv4 {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dextragiarios");
	private static EntityManager em;

	public static EntityManager getEM() {
		return emf.createEntityManager();
	}

	public static void open() {
		em = emf.createEntityManager();
	}

	public static Object merge(Object obj) {
		if (!em.isOpen()) {
			open();
		}
		em.getTransaction().begin();
		obj = em.merge(obj);
		em.getTransaction().commit();
		return obj;
	}

	public static <T> T find(Class<T> c, Object obj) {
		if (!em.isOpen()) {
			open();
		}
		return em.find(c, obj);
	}

	public static void close() {
		if (!em.isOpen()) {
			open();
		}
		em.close();
	}
}

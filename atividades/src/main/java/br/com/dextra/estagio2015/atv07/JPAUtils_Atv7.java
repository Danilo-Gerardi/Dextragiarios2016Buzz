package br.com.dextra.estagio2015.atv07;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.dextra.estagio2015.atv04.JPAUtils_Atv4;
import br.com.dextra.estagio2015.comum.Produto;

public class JPAUtils_Atv7 {
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
	
	@SuppressWarnings("unchecked")
	public static Query createQuery(String qry, Class c){
		if (!em.isOpen()){
			open();
		}
		return em.createQuery(qry, c);
	}
}

package br.com.dextra.estagio2015.atv11;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.dextra.estagio2015.comum.JPAUtils;

public class HashMapTest {

/**
 * 
 * Nao alterar o teste!! 
 *
 */
	@Test
	public void testMap() {
		Map<Person, String> map = new HashMap<Person, String>();
		Person pessoa = new Person();
		pessoa.setId(3l);
		JPAUtils.merge(pessoa);
		pessoa.setName("name");
		map.put(pessoa, "comment1");
		Person p2 = JPAUtils.getEM().createQuery("FROM Person", Person.class).getSingleResult();
		assertTrue(map.containsKey(p2));
		Person key = map.keySet().iterator().next();
		assertTrue(map.containsKey(key));
	}

}
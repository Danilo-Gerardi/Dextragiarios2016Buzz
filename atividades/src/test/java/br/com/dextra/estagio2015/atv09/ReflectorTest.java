package br.com.dextra.estagio2015.atv09;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.estagio2015.atv09.Reflector;

public class ReflectorTest {

	@Test
	public void getNextUsingReflector() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		List<String> pessoas = new ArrayList<String>();

		pessoas.add("Neymar");
		pessoas.add("Cristiano Ronaldo");
		pessoas.add("Shevchenko");

		Assert.assertNotNull(Reflector.getNextValue(pessoas.iterator()));
	}
}

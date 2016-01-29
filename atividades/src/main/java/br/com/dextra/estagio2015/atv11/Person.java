package br.com.dextra.estagio2015.atv11;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private Long id;
	private String name;

	public Person() {

	}

	public Person(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
   /** R: O problema aqui eh que o HashMap testa pra ver se a chave adicionada ao banco eh igual a chave 
	 * recebida pela Query. Apos a adicao da chave no banco, uma das variaveis do objeto eh alterada e
	 * ele interpreta os objetos como se fossem diferentes. Isso ocorre pois o metodo containsKey() 
	 * do HashMap chama o metodo hashCode() pra calcular uma hash unica para cada objeto e, assim, 
	 * verificar se o valor hash retornado das duas sao iguais. Uma vez que alterar o valor de uma 
	 * variavel nao altera o objeto para o nosso caso (o equals() checa somente o ID), podemos gerar um 
	 * hashCode que depende somente do ID da pessoa no banco de dados. 
	 * */
	
	@Override
	public int hashCode() {
		return (int) ((int) Math.pow(2,id)) + 666;
	}
}

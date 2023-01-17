package de.schauderhaft.sqlresultmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@SpringBootTest
class IssueJpa2757SqlresultmappingApplicationTests {

	@Autowired
	PersonRepository persons;

	@Autowired
	EntityManager em;
	@Test
	void queryUsingResultSetMappings() {

		Person person = createPerson();

		persons.loadNonEntityById(person.id);
	}

	private Person createPerson() {
		Person person = new Person();
		person.id = 23L;
		person.firstName = "Jens";
		person.lastName = "Schauder";
		persons.save(person);
		return person;
	}

	@Test
	void queryUsingEM() {
		Person person = createPerson();

		TypedQuery<NotAPerson> query = em.createNamedQuery("loadNonEntityById", NotAPerson.class);
		query.setParameter("id", person.id);
		NotAPerson notAPerson = query.getSingleResult();

	}

}

package de.schauderhaft.sqlresultmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IssueJpa2757SqlresultmappingApplicationTests {

	@Autowired
	PersonRepository persons;
	@Test
	void contextLoads() {

		Person person = new Person();
		person.id = 23L;
		person.firstName = "Jens";
		person.lastName = "Schauder";
		persons.save(person);

		persons.loadNonEntityById(person.id);
	}

}

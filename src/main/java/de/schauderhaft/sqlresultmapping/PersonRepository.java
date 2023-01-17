package de.schauderhaft.sqlresultmapping;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
	@Query(value = "select first_name, last_name from person where id = :id", nativeQuery = true)
	NotAPerson loadNonEntityById(Long id);
}

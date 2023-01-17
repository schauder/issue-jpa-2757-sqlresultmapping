package de.schauderhaft.sqlresultmapping;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
	@Query(name = "loadNonEntityById")
	NotAPerson loadNonEntityById(Long id);
}

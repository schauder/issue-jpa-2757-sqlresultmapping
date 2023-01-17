package de.schauderhaft.sqlresultmapping;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "NotAPersonResult", classes = {
		@ConstructorResult(targetClass = NotAPerson.class,
				columns = {@ColumnResult(name = "first_name"), @ColumnResult(name = "last_name")})
})
@NamedNativeQuery(name = "loadNonEntityById", query = "select first_name, last_name from person where id = :id", resultSetMapping = "NotAPersonResult")
@Entity
public class Person {

	@Id
	Long id;

	String firstName;

	String lastName;
}

package de.schauderhaft.sqlresultmapping;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "NotAPersonResult", classes = { //
		@ConstructorResult(targetClass = NotAPerson.class, //
				columns = { //
				@ColumnResult(name = "first_name"), //
						@ColumnResult(name = "last_name") //
		}) //
})
@NamedNativeQuery(name = "loadNonEntityById", query = "select first_name, last_name from person where id = :id", resultSetMapping = "NotAPersonResult")
@Entity
public class Person {

	@Id
	Long id;

	String firstName;

	String lastName;
}

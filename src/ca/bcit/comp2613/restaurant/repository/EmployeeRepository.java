package ca.bcit.comp2613.restaurant.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.bcit.comp2613.restaurant.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
	@Query("select e from Employee e where e.firstName = :firstName or e.lastName = :lastName")
	Employee findByLastOrFirstName(@Param("lastName") String lastName,
									@Param("firstName") String firstName);
}

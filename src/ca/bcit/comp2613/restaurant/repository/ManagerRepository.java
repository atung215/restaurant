package ca.bcit.comp2613.restaurant.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.restaurant.model.Manager;

public interface ManagerRepository extends CrudRepository<Manager, String>
{
	List<Manager> findByLastName(String lastName);
}

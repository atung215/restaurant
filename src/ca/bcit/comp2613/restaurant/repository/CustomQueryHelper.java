package ca.bcit.comp2613.restaurant.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.model.Manager;

public class CustomQueryHelper 
{
	private EntityManagerFactory emf;
	
	public EntityManagerFactory getEmf()
	{
		return emf;		
	}
	
	public void setEmf(EntityManagerFactory emf)
	{
		this.emf = emf;		
	}
	
	public CustomQueryHelper(EntityManagerFactory emf)
	{
		this.emf = emf;
	}
	
	public List<Employee> getEmployeesOfManagerWithNativeQuery(String managerId) 
	{
		List<Employee> retval = null;
		EntityManager em = null;
		try 
		{
			em = emf.createEntityManager();
			Query query = em
					.createNativeQuery(
							" select "
									+ "       employee.* "
									+ "    from "
									+ "        manager_employee "
									+ "    left join "
									+ "        employee "
									+ "            on manager_employee.employee_id = employee.id where manager_employee.manager_id = :manager_id",
							Employee.class);
			query.setParameter("manager_id", managerId);
			retval = query.getResultList();
		} 
		catch (Exception e) 
		{
		} 
		finally 
		{
			try
			{
				em.close();
			} 
			catch (Exception e) 
			{
			}
		}
		return retval;
	}
	
	public List<Employee> getEmployeesOfManager(String managerId)
	{
		List<Employee> retval = null;
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Manager manager = em.find(Manager.class, managerId);
			manager.getEmployees().size();
			return manager.getEmployees();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				em.close();
			}
			catch(Exception e)
			{
			}
		}
		return retval;
	}
	
	public void addEmployeesToManager(String managerId, Long employeeId)
	{
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Manager manager = em.find(Manager.class, managerId);
			Employee employee = em.find(Employee.class, employeeId);
			System.out.println(manager.getEmployees().size()); // make a db call
			manager.getEmployees().add(employee);
			em.getTransaction().begin();
			em.persist(manager);
			em.getTransaction().commit();
			System.out.println(manager.getEmployees().size()); // make a db call
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				em.close();
			} 
			catch (Exception e) 
			{
			}
		}		
	}
	
	public void removeEmployeesFromManager(String managerId, Long employeeId) {
		EntityManager em = null;
		try 
		{
			em = emf.createEntityManager();
			Manager manager = em.find(Manager.class, managerId);
			manager.getEmployees().size(); // make a db call
			Iterator<Employee> iter = manager.getEmployees().iterator();
			while (iter.hasNext()) 
			{
				if (iter.next().getId().equals(employeeId)) 
				{
					iter.remove();
				}
			}		
			em.getTransaction().begin();
			em.persist(manager);
			em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				em.close();
			} catch (Exception e) 
			{
			}
		}		
	}
	
	
	
	
	
	
	
	
	
	
}

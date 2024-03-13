package com.one_to_one_unidirection.dao;


import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_one_unidirection.dto.Employee;
import com.one_to_one_unidirection.dto.Laptop;

public class EmployeeLaptopDao {

	EntityManagerFactory eMF=Persistence.createEntityManagerFactory("Enterprise");
	EntityManager em=eMF.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Employee saveEmployeeLaptopDao(Employee e,Laptop l) {
		
		et.begin();
		/**
		 * this setter method will pass laptop id to employee table
		 */
		e.setLaptop(l);
		em.persist(e);
		//em.persist();
		et.commit();
		return e;
		
	}
	
		public Employee getLaptopByEmployeeIdDao(int employeeId) {
			
			return em.find(Employee.class, employeeId);
		}
		public Employee deleteLaptopAndEmployeeByEmployeeIdDao(int employeeId) {
			Employee employee=getLaptopByEmployeeIdDao(employeeId);
			
			if(employee!=null) {
				et.begin();
				em.remove(employee);
				et.commit();
				return employee;
			}
			else {
				return null;
			}	
		}
		/**
		 * @param e
		 * @param laptopId
		 * @return
		 */
		public Employee saveEmployeeLaptopDao(Employee e,int laptopId) {
			Laptop l=em.find(Laptop.class, laptopId);
			
			if(l!=null) {
				e.setLaptop(l);
			}
			et.begin();
			/**
			 * this setter method will pass laptop id to employee table
			 */
			em.persist(e);
			//em.persist(l);
			return e;
		}
		/**
		 * display EMployee And Laptop Together
		 */
		public List<Employee> getAllEmployeeAndLaptopDetails(){
			
			Query query=em.createQuery("from Employee");
			return query.getResultList();
		}
	}


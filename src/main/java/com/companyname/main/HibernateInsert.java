package com.companyname.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.companyname.entity.Employee;

public class HibernateInsert {

	public static void main(String[] args) {

		//step-1: configure the hibernate.cfg.xml file
		
		Configuration configuration = new Configuration().configure("config/hibernate.cfg.xml");
		
		//step-2: create session factory 
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//step-3: session
				
		Session session = sessionFactory.openSession();
		
		//step-4: transaction
				
		Transaction transaction = session.beginTransaction();
		
				
		//create an object for employee class
	
		Employee employee = new Employee();
		
		employee.setEmployeeId(101);
		employee.setEmployeeName("Bhargavi");
		employee.setSalary(500000.00);
		employee.setEmailId("bhargavi@gmail.com");
		
		session.save(employee);
		
		/*
		Operation  -  Method
		insert     -  sace(), persist()
		select     -  get(),load()
		update     -  update(),merge(),save Or Update()
		delete     -  delete() 
		 */
		
	
		//fetching data from database
		employee = session.get(employee.getClass(), 101);
		System.out.println(employee.getEmployeeName());
		
		//updating the data
		employee.setEmployeeName("Alle");
		session.update(employee);
			
		// deleting the record
		session.delete(employee); 
		
		//step-5: commit
		transaction.commit();
		session.close();
	}

}

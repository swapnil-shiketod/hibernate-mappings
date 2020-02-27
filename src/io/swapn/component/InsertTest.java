package io.swapn.component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertTest {

	public static void main(String[] args) {
		
		//get Session
		Session session = HibernateUtil.getSession();
		
		//save objects
		JobType job=new JobType();
		job.setJob("developer");
		job.setSalary(70000);
		job.setDepartment(101);  
		Person person=new Person();
		person.setPersonId(1001);
		person.setPersonName("swapnil");
		person.setPersonJob(job);
		
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.save(person);
			tx.commit();
		}catch(Exception e){
		
			tx.rollback();
		}
		
		//close resources
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
		
	}
	 
}

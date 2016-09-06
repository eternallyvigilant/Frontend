

import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class DAO {

	private static SessionFactory factory;
	public static void instantiate(){	
	 
	      try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	     
	}
	   
	   public Integer addEmployee(int empid, String firstname, String lastname, String contact, String dob, String email, String line,String obs, String recruiter, String supervisor, String department, String bgroup,String grade){
		     System.out.println("Addition begins");
		   	  Session session = factory.openSession();
		      Transaction tx = null;
		      Integer employeeID = null;
		      DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		      java.sql.Date sqlDate = java.sql.Date.valueOf(dob);
		      try{
		         tx = session.beginTransaction();
		         Employee employee = new Employee(empid,firstname,lastname,contact,sqlDate,email,line,obs,recruiter,supervisor,department,bgroup,grade);
		         employeeID = (Integer) session.save(employee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return employeeID;
		   }
		   /* Method to  READ all the employees */
		   public void listEmployees( ){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         List employees = session.createQuery("FROM Employee").list(); 
		         for (Iterator iterator = 
		                           employees.iterator(); iterator.hasNext();){
		            Employee employee = (Employee) iterator.next(); 
		            System.out.print("First Name: " + employee.getFirstname()); 
		            System.out.print("  Last Name: " + employee.getLastname()); 
		            System.out.println(" DOB : " + employee.getDob());
		            System.out.println(" Contact : " + employee.getContact());
		            System.out.println(" Email : " + employee.getEmail());
		            System.out.println(" Supervisor : " + employee.getSupervisor());
		            System.out.println(" Line Manager : " + employee.getLine());
		            System.out.println(" OBS SPOC : " + employee.getObs());
		            System.out.println(" Department : " + employee.getDepartment());
		            System.out.println(" Recruiter : " + employee.getRecruiter());
		            System.out.println(" Blood Group  : " + employee.getBgroup());
		            System.out.println(" Grade : "+ employee.getGrade());
		         }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
		   /* Method to UPDATE details of an employee */
		   public void updateEmployee(int empid, String firstname, String lastname, String contact, String dob, String email, String line,String obs, String recruiter, String supervisor, String department, String bgroup,String grade){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      java.sql.Date sqlDate = java.sql.Date.valueOf(dob);
		      try{
		         tx = session.beginTransaction();
		         Employee employee = 
		                    (Employee)session.get(Employee.class, empid); 
		         employee.setFirstname(firstname);
		         employee.setLastname(lastname);
		         employee.setContact(contact);
		         employee.setDepartment(department);
		         employee.setDob(sqlDate);
		         employee.setLine(line);
		         employee.setObs(obs);
		         employee.setBgroup(bgroup);
		         employee.setRecruiter(recruiter);
				 employee.setSupervisor(supervisor);
				 employee.setGrade(grade);
		         session.update(employee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
		   /* Method to DELETE an employee from the records */
		   public void deleteEmployee(int empid){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         Employee employee = 
		                   (Employee)session.get(Employee.class, empid); 
		         session.delete(employee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      
		   }
		   
		   public void displayEmployee(int empid){
			   Session session = factory.openSession();
			   Transaction tx = null;
			   List query = session.createQuery("FROM Employee WHERE empid = "+Integer.toString(empid)).list();
			   System.out.println(query.get(0));
		   }
}


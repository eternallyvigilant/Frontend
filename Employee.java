

import java.sql.Date;
public class Employee {

	private int empid;
	private String firstname;
	private String lastname;
	private String contact;
	private Date dob;
	private String email;
	private String line;
	private String obs;
	private String recruiter;
	private String supervisor;
	private String department;
	private String bgroup;
	private String grade;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	
	public Employee()
	{
		
	}
	
	public Employee(int empid, String firstname, String lastname, String contact, Date dob, String email, String line,
			String obs, String recruiter, String supervisor, String department, String bgroup,String grade) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.dob = dob;
		this.email = email;
		this.line = line;
		this.obs = obs;
		this.recruiter = recruiter;
		this.supervisor = supervisor;
		this.department = department;
		this.bgroup = bgroup;
		this.grade=grade;
	}
	
}

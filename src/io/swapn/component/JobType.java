package io.swapn.component;

import javax.persistence.Embeddable;

// configure helper class that acts as component.  having sub properties like job type
@Embeddable
public class JobType {

	private String job;
	private int department;
	private double salary;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

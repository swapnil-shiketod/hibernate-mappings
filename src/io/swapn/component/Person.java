package io.swapn.component;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Has-a relationship Example

@Entity        
@Table(name="person_tab")    //if we are not using this then entity/class name = table name
public class Person {

	@Id
	private int personId;
	private String personName;
	@Embedded    // to configure component property personJob
	private JobType personJob;
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public JobType getPersonJob() {
		return personJob;
	}
	public void setPersonJob(JobType personJob) {
		this.personJob = personJob;
	}
	
	
}

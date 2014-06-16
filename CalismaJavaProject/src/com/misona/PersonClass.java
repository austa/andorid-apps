package com.misona;

public class PersonClass {
	private String name;
	private String lastname;
	private int old;
	private String job;
	
	public static void main(String[] args) {
		PersonClass person = new PersonClass("Alaattin");
	}
	
	public PersonClass(String myName) {
		this(myName, "Usta");
	}	
	
	public PersonClass(String name, String lastname){
		System.out.println(name+ " "+ lastname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	

}

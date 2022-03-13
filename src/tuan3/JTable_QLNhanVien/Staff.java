package tuan3.JTable_QLNhanVien;

import java.io.Serializable;

public class Staff implements Serializable{
	private String idStaff;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	
	public Staff(String idStaff, String firstName, String lastName, String gender, int age, double salary) {
		super();
		this.idStaff = idStaff;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
	}

	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}

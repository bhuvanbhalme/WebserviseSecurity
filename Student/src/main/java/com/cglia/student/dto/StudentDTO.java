package com.cglia.student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAIL")
public class StudentDTO {

	@Id
	@Column(name = "std_id")
	private int stdId;

	@Column(name = "std_name")
	private String stdName;

	@Column(name = "std_age")
	private int stdAge;
    
	@Column(name = "user_name")
	private String userName;
	 
	@Column(name = "password")
	private String password;
	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	

	public StudentDTO(int stdId, String stdName, int stdAge, String userName, String password) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.userName = userName;
		this.password = password;
	}

	public StudentDTO() {
	}

}

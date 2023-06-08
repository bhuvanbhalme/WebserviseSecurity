package com.cglia.student.dto;

public class RestCustomerDTO {

	private int id;

	private String customerName;

	private String customerEmail;

	private String customerPassword;

	public RestCustomerDTO() {
		// default constructor that used by hibernate
	}

	public RestCustomerDTO(String customerName, String customerEmail, String customerPassword) {
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", customerPassword=" + customerPassword + "]";
	}

}

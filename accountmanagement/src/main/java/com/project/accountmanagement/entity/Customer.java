package com.project.accountmanagement.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
//@TableGenerator(name = "Customer",initialValue = 100000)
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="Cid")
//	@GeneratedValue(strategy=GenerationType.TABLE, generator="Customer")
	@GeneratedValue
	private long cId;

	@Column(name = "Cname")
	private String customerName;
	
	@Column(name="DOB", columnDefinition = "DATE DEFAULT NULL")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
//	@NotNull(message = "Please provide your DOB.")
	private Date dateOfBirth;
	
	@Column(name="panNumber")
	private String panNumber;
	
	@Column(name="aadharNumber")
	private String aadherNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadherNumber() {
		return aadherNumber;
	}

	public void setAadherNumber(String aadherNumber) {
		this.aadherNumber = aadherNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(
			long cId, 
			String customerName, Date dateOfBirth, String panNumber, String aadherNumber,
			String address, String email) {
		super();
		this.cId = cId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.aadherNumber = aadherNumber;
		this.address = address;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", panNumber=" + panNumber + ", aadherNumber=" + aadherNumber + ", address=" + address + ", email="
				+ email + "]";
	}
	
}

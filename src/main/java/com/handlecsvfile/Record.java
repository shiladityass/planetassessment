package com.handlecsvfile.mavenproject;

import java.math.BigDecimal;

public class Record {

	private String id;
	private String mailId;
	private String phoneNo;
	private BigDecimal parcelWeight;
	private String country;
	
	public Record(String id, String mailId, String phoneNo, BigDecimal parcelWeight, String country) {
		this.id = id;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.parcelWeight = parcelWeight;
		this.country = country;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public BigDecimal getParcelWeight() {
		return parcelWeight;
	}
	public void setParcelWeight(BigDecimal parcelWeight) {
		this.parcelWeight = parcelWeight;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", mailId=" + mailId + ", phoneNo=" + phoneNo + ", parcelWeight=" + parcelWeight
				+ ", country=" + country + "]";
	}
	
}

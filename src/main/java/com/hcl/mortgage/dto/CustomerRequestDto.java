package com.hcl.mortgage.dto;

public class CustomerRequestDto {
		private String customerName;
		private String emailId;
		private Long mobileNumber;
		private String dob;
		
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public Long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
}

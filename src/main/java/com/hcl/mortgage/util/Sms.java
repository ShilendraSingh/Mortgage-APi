package com.hcl.mortgage.util;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

public class Sms {
		public void sendSms(Long mobileNumber, long accountNumber, String randomPassword,String accountType) {
			String mobile=Long.toString(mobileNumber);
			mobile="91"+mobile;
			System.out.println(mobile);
			NexmoClient client = NexmoClient.builder()
			        .apiKey("560e12ca")
			        .apiSecret("1dEXo2Cofkam2MS4")
			        .build();

			SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
			        "NEXMO",
			        mobile,
			        "Your Modal Bank "+accountType+" Account Number is "+accountNumber +" and the password is "+randomPassword));
			
		for (SmsSubmissionResponseMessage response : responses.getMessages()) {
		    System.out.println(response);
		}
}
}
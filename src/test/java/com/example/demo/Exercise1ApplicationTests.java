package com.example.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import wiremock.org.apache.http.HttpResponse;
import wiremock.org.apache.http.client.ClientProtocolException;
import wiremock.org.apache.http.client.methods.HttpGet;
import wiremock.org.apache.http.client.methods.HttpPost;
import wiremock.org.apache.http.client.methods.HttpUriRequest;
import wiremock.org.apache.http.entity.StringEntity;
import wiremock.org.apache.http.impl.client.HttpClientBuilder;

@RunWith(SpringRunner.class)

public class Exercise1ApplicationTests {
	
	@Test
    public void returnsOptionsWhenCallingGetOptions() throws ClientProtocolException, IOException {
		// Given
		   HttpUriRequest request = new HttpGet( "http://1ql1o.mocklab.io/status" );
		 
		   // When
		   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		 
		   // Then
		   System.out.println("\nTest Case GET");
		   System.out.print("Showing Status Code: ");
		   System.out.println(httpResponse.getStatusLine().getStatusCode());
		   System.out.print("Showing Up-Time: ");
		   RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		   long uptime = rb.getUptime();
		   System.out.println(uptime + "\n");
		   assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(207));
    }
	
	@Test
	public void Post() throws ClientProtocolException, IOException {
	  
	   // Given
		HttpPost post = new HttpPost( "http://1ql1o.mocklab.io/json" );
		//In the JSON I have a value that only accepts a POST message, if successful return code is 201, else 404
		StringEntity params =new StringEntity("{\"id\":12345,\"value\":\"abc-def-ghi\"} ");
		post.addHeader("content-type", "application/x-www-form-urlencoded");
		post.setEntity(params);
	 
	   // When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( post );
	 
	   // Then
		System.out.println("\nTest Case POST");
		System.out.print("Showing Response: ");
		System.out.println(httpResponse.getStatusLine().getReasonPhrase()); //Created is successful, Not found in other case
		System.out.print("Showing Status Code: ");
		System.out.println(httpResponse.getStatusLine().getStatusCode() + "\n"); //201 is successful, 404 in other case
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(201));
	}
}

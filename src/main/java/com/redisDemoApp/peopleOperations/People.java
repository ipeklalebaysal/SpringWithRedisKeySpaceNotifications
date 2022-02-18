package com.redisDemoApp.peopleOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.redisDemoApp.storageConfiguration.StorageClient;
import com.redisDemoApp.wiremockClient.WireMockClient;

@Component
public class People {
	@Autowired
	private StorageClient storageClient;

//	@Autowired
//	private WireMockClient wmClient;

	public void setName() {
		// Make a get requets to wiremock docker and see how it works.
//		System.out.println("IPEK people name: " + defaultName);
//		System.out.println("IPEK baseURL: " + baseUrl);
//		System.out.println("Ipek Wiremock Resp: ");
		//wmClient.getFromWiremock();
		storageClient.set("Name", "Elif");
	}

}

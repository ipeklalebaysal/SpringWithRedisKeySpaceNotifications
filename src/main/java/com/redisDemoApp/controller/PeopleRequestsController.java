package com.redisDemoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redisDemoApp.peopleOperations.People;
import com.redisDemoApp.storageConfiguration.StorageClient;

@RestController
public class PeopleRequestsController {

	@Autowired
	private People people;

	@Autowired
	private StorageClient storageClient;

	@GetMapping("/setName")
	public String setPeopleName() {
		storageClient.getStorageClient();
		people.setName();
		return "I set";
	}

	@GetMapping("/configure")
	public String getTry() {
		storageClient.getStorageClient();
		System.out.println("how do you work?");
		return "configured";
	}

	@GetMapping("/tryNoConfig")
	public String setPeopleNameNoConfig() {
		people.setName();
		return "I set";
	}
	@GetMapping("/getElif")
	public String getWhatIsInRedis() {
		String nameElif =  storageClient.get("Name") == null ? "Null" : storageClient.get("Name");
		return nameElif;
	}

}

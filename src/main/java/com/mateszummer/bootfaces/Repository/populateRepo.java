package com.mateszummer.bootfaces.Repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mateszummer.bootfaces.Model.User;

@Component
public class populateRepo {
	
	@Autowired
	UserRepo userRepo;
	
	@PostConstruct
	public void initializeDB() {
		for (int i = 0; i<100; i++) {
			userRepo.save(new User(i + " name",i + " email"));
		}
	}
}
